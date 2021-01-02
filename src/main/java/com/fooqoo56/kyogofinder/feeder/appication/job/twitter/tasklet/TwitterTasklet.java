package com.fooqoo56.kyogofinder.feeder.appication.job.twitter.tasklet;

import com.fooqoo56.kyogofinder.feeder.appication.service.KyoGoFinderApiService;
import com.fooqoo56.kyogofinder.feeder.appication.service.TwitterService;
import com.fooqoo56.kyogofinder.feeder.infrastracture.api.dto.response.KyoGoFinderFollowerApiResponse;
import com.fooqoo56.kyogofinder.feeder.infrastracture.api.dto.response.TwitterFollowerResponse;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class TwitterTasklet implements Tasklet {

    private final TwitterService twitterService;

    private final KyoGoFinderApiService kyoGoFinderApiService;

    /**
     * Twitterタスクレット.
     *
     * @param contribution StepContribution
     * @param chunkContext ChunkContext
     * @return RepeatStatus
     */
    @Override
    public RepeatStatus execute(@NonNull final StepContribution contribution,
                                @NonNull final ChunkContext chunkContext) {

        final KyoGoFinderFollowerApiResponse response = kyoGoFinderApiService.getOldestUser();

        for (final String userId : response.getResult().getUserIds()) {

            final List<TwitterFollowerResponse.User> users =
                    twitterService.getFollower(userId).getData();

            users.forEach(user -> kyoGoFinderApiService.postUser(user, userId));
        }

        return RepeatStatus.FINISHED;
    }
}
