package com.fooqoo56.kyogofinder.feeder.appication.service;

import com.fooqoo56.kyogofinder.feeder.domain.repository.api.KyoGoFinderApiRepository;
import com.fooqoo56.kyogofinder.feeder.infrastracture.api.dto.request.KyoGoFinderUserApiRequest;
import com.fooqoo56.kyogofinder.feeder.infrastracture.api.dto.response.KyoGoFinderFollowerApiResponse;
import com.fooqoo56.kyogofinder.feeder.infrastracture.api.dto.response.KyoGoFinderUserApiResponse;
import com.fooqoo56.kyogofinder.feeder.infrastracture.api.dto.response.TwitterFollowerResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class KyoGoFinderApiService {

    private final KyoGoFinderApiRepository kyoGoFinderApiRepository;

    /**
     * フォロワー取得.
     *
     * @return TwitterFollowerResponse
     */
    public KyoGoFinderFollowerApiResponse getOldestUser() {
        return kyoGoFinderApiRepository.getOldestUser();
    }

    /**
     * フォロワー保存.
     *
     * @param user ユーザ
     * @param id   フォロー元ユーザ
     * @return KyoGoFinderUserApiResponse
     */
    public KyoGoFinderUserApiResponse postUser(final TwitterFollowerResponse.User user,
                                               final String id) {
        final KyoGoFinderUserApiRequest request =
                KyoGoFinderUserApiRequest.convertTwitterResToKyoGoReq(user, id);

        return kyoGoFinderApiRepository.postUser(request);
    }
}
