package com.fooqoo56.kyogofinder.feeder.domain.repository.api;

import com.fooqoo56.kyogofinder.feeder.infrastracture.api.dto.request.KyoGoFinderUserApiRequest;
import com.fooqoo56.kyogofinder.feeder.infrastracture.api.dto.response.KyoGoFinderFollowerApiResponse;
import com.fooqoo56.kyogofinder.feeder.infrastracture.api.dto.response.KyoGoFinderUserApiResponse;

public interface KyoGoFinderApiRepository {

    /**
     * 最も古いユーザのIDを取得.
     *
     * @return KyoGoFinderApiResponse
     */
    KyoGoFinderFollowerApiResponse getOldestUser();

    /**
     * ユーザ保存.
     *
     * @param request KyoGoFinderUserApiRequest
     * @return KyoGoFinderUserApiResponse
     */
    KyoGoFinderUserApiResponse postUser(final KyoGoFinderUserApiRequest request);
}
