package com.fooqoo56.kyogofinder.feeder.infrastracture.api.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;
import org.apache.commons.lang3.StringUtils;

@Value
@JsonIgnoreProperties(ignoreUnknown = true)
public class KyoGoFinderUserApiResponse {

    @JsonProperty("result")
    Result result;

    /**
     * デフォルトコンストラクタ.
     */
    public KyoGoFinderUserApiResponse() {
        result = new Result();
    }

    @Value
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Result {

        String name;
        String screenName;
        String description;
        Integer followersCount;
        Integer friendsCount;
        Integer statusesCount;
        String profileImageUrlHttps;
        Boolean deleteFlag;

        /**
         * デフォルトコンストラクタ.
         */
        public Result() {
            name = StringUtils.EMPTY;
            screenName = StringUtils.EMPTY;
            description = StringUtils.EMPTY;
            followersCount = 0;
            friendsCount = 0;
            statusesCount = 0;
            profileImageUrlHttps = StringUtils.EMPTY;
            deleteFlag = Boolean.FALSE;
        }
    }
}
