package com.fooqoo56.kyogofinder.feeder.infrastracture.api.repositoryimpl;

import com.fooqoo56.kyogofinder.feeder.domain.repository.api.TwitterRepository;
import com.fooqoo56.kyogofinder.feeder.infrastracture.api.config.TwitterConfig;
import com.fooqoo56.kyogofinder.feeder.infrastracture.api.dto.request.TwitterFollowerRequest;
import com.fooqoo56.kyogofinder.feeder.infrastracture.api.dto.response.TwitterFollowerResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;


@Repository
@RequiredArgsConstructor
public class TwitterRepositoryImpl implements TwitterRepository {

    private final TwitterConfig config;
    private final RestTemplate twitterTemplate;

    /**
     * フォロワー取得.
     *
     * @param request TwitterFollowerRequest
     * @return TwitterFollowerResponse
     */
    @Override
    public TwitterFollowerResponse getFollower(final TwitterFollowerRequest request) {
        final HttpHeaders headers = new HttpHeaders();

        final String url =
                UriComponentsBuilder.fromHttpUrl(config.getBaseUrl())
                        .path(getFollowerPath(request.getId()))
                        .queryParams(request.getQueryMap())
                        .build()
                        .toString();

        return twitterTemplate
                .exchange(url, HttpMethod.GET, new HttpEntity<String>(headers),
                        TwitterFollowerResponse.class)
                .getBody();
    }

    /**
     * フォロワー取得のTwitterパス.
     *
     * @param id ユーザID
     * @return パス
     */
    private String getFollowerPath(final String id) {
        return config.getPath() + id + "/followers";
    }

}
