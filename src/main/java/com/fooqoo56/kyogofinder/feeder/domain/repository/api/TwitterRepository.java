package com.fooqoo56.kyogofinder.feeder.domain.repository.api;

import com.fooqoo56.kyogofinder.feeder.infrastracture.api.dto.request.TwitterFollowerRequest;
import com.fooqoo56.kyogofinder.feeder.infrastracture.api.dto.response.TwitterFollowerResponse;

public interface TwitterRepository {

    /**
     * フォロワー取得.
     *
     * @param request TwitterFollowerRequest
     * @return TwitterFollowerResponse
     */
    TwitterFollowerResponse getFollower(final TwitterFollowerRequest request);
}
