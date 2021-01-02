package com.fooqoo56.kyogofinder.feeder.infrastracture.api.dto.request;

import java.io.Serializable;
import java.util.Objects;
import lombok.Builder;
import lombok.Value;
import org.springframework.lang.NonNull;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@Value
@Builder
public class TwitterFollowerRequest implements Serializable {

    private static final long serialVersionUID = -5471057875520817034L;

    private static final String MAX_RESULT_QUERY = "max_results";

    private static final String PAGINATION_TOKEN_QUERY = "pagination_token";

    private static final String TWEETS_FIELD_QUERY = "tweet.fields";

    private static final String USER_FIELD_QUERY = "user.fields";

    // パスパラメータ
    @NonNull
    String id;

    String tweetsFields = "public_metrics";

    String userFields = "description,profile_image_url,public_metrics";

    Integer maxResult; // default: 1000

    String paginationToken;

    /**
     * クエリをMap型に変換.
     *
     * @return Map
     */
    public MultiValueMap<String, String> getQueryMap() {
        final MultiValueMap<String, String> queries = new LinkedMultiValueMap<>();

        queries.add(MAX_RESULT_QUERY, maxResult.toString());
        queries.add(USER_FIELD_QUERY, userFields);
        queries.add(TWEETS_FIELD_QUERY, tweetsFields);

        if (Objects.nonNull(paginationToken)) {
            queries.add(PAGINATION_TOKEN_QUERY, paginationToken);
        }

        return queries;
    }
}
