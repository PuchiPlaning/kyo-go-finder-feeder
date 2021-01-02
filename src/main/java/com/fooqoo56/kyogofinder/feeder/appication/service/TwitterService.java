package com.fooqoo56.kyogofinder.feeder.appication.service;

import com.fooqoo56.kyogofinder.feeder.domain.repository.api.TwitterRepository;
import com.fooqoo56.kyogofinder.feeder.infrastracture.api.dto.request.TwitterFollowerRequest;
import com.fooqoo56.kyogofinder.feeder.infrastracture.api.dto.response.TwitterFollowerResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class TwitterService {

    private final TwitterRepository twitterRepository;

    /**
     * フォロワー取得.
     *
     * @return TwitterFollowerResponse
     */
    public TwitterFollowerResponse getFollower(final String id) {
        final TwitterFollowerRequest request = TwitterFollowerRequest
                .builder()
                .id(id)
                .maxResult(10)
                .build();
        return twitterRepository.getFollower(request);
    }
}
