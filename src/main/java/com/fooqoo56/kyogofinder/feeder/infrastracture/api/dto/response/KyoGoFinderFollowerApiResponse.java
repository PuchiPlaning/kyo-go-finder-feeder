package com.fooqoo56.kyogofinder.feeder.infrastracture.api.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;
import lombok.Value;

@Value
@JsonIgnoreProperties(ignoreUnknown = true)
public class KyoGoFinderFollowerApiResponse {

    @JsonProperty("result")
    Result result;

    public KyoGoFinderFollowerApiResponse() {
        result = new Result();
    }

    @Value
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Result {
        @JsonProperty("userIds")
        List<String> userIds;

        public Result() {
            userIds = new ArrayList<>();
        }
    }
}
