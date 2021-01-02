package com.fooqoo56.kyogofinder.feeder.infrastracture.api.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Value;
import org.apache.commons.lang3.StringUtils;

@Value
@AllArgsConstructor
public class TwitterFollowerResponse implements Serializable {

    private static final long serialVersionUID = -5432848036095895135L;

    @JsonProperty("data")
    List<User> data;

    @JsonProperty("meta")
    Meta meta;

    /**
     * デフォルトコンストラクタ.
     */
    public TwitterFollowerResponse() {
        data = new ArrayList<>();
        meta = new Meta();
    }

    @Value
    @AllArgsConstructor
    public static class User implements Serializable {

        private static final long serialVersionUID = 8584459843295052381L;

        @JsonProperty("id")
        String id;

        @JsonProperty("name")
        String name;

        @JsonProperty("username")
        String username;

        @JsonProperty("public_metrics")
        PublicMetrics publicMetrics;

        @JsonProperty("profile_image_url")
        String profileImageUrl;

        @JsonProperty("description")
        String description;

        /**
         * デフォルトコンストラクタ.
         */
        public User() {
            id = StringUtils.EMPTY;
            name = StringUtils.EMPTY;
            username = StringUtils.EMPTY;
            publicMetrics = new PublicMetrics();
            profileImageUrl = StringUtils.EMPTY;
            description = StringUtils.EMPTY;
        }

    }

    @Value
    @AllArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class PublicMetrics implements Serializable {

        private static final long serialVersionUID = 1350486433494524479L;

        @JsonProperty("followers_count")
        Integer followersCount;

        @JsonProperty("following_count")
        Integer followingCount;

        @JsonProperty("tweet_count")
        Integer tweetCount;

        /**
         * デフォルトコンストラクタ.
         */
        public PublicMetrics() {
            followersCount = 0;
            followingCount = 0;
            tweetCount = 0;
        }
    }

    @Value
    @AllArgsConstructor
    public static class Meta implements Serializable {

        private static final long serialVersionUID = 8704175498262865972L;

        @JsonProperty("result_count")
        Integer resultCount;

        @JsonProperty("next_token")
        String nextToken;

        /**
         * デフォルトコンストラクタ.
         */
        public Meta() {
            resultCount = 0;
            nextToken = StringUtils.EMPTY;
        }
    }


}
