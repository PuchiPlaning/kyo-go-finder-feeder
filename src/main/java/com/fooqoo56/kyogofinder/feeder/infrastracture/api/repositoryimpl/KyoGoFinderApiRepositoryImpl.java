package com.fooqoo56.kyogofinder.feeder.infrastracture.api.repositoryimpl;

import com.fooqoo56.kyogofinder.feeder.domain.repository.api.KyoGoFinderApiRepository;
import com.fooqoo56.kyogofinder.feeder.infrastracture.api.config.KyoGoFinderApiConfig;
import com.fooqoo56.kyogofinder.feeder.infrastracture.api.dto.request.KyoGoFinderUserApiRequest;
import com.fooqoo56.kyogofinder.feeder.infrastracture.api.dto.response.KyoGoFinderFollowerApiResponse;
import com.fooqoo56.kyogofinder.feeder.infrastracture.api.dto.response.KyoGoFinderUserApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Repository
@RequiredArgsConstructor
public class KyoGoFinderApiRepositoryImpl implements KyoGoFinderApiRepository {

    final RestTemplate kyoGoFinderApiTemplate;
    final KyoGoFinderApiConfig config;

    /**
     * {@inheritDoc}
     */
    @Override
    public KyoGoFinderFollowerApiResponse getOldestUser() {
        final HttpHeaders headers = new HttpHeaders();

        final String url =
                UriComponentsBuilder.fromHttpUrl(config.getBaseUrl())
                        .path(getOldestUserPath())
                        .build()
                        .toString();

        return kyoGoFinderApiTemplate
                .exchange(url, HttpMethod.GET, new HttpEntity<String>(headers),
                        KyoGoFinderFollowerApiResponse.class)
                .getBody();
    }

    /**
     * {@inheritDoc}
     */
    public KyoGoFinderUserApiResponse postUser(final KyoGoFinderUserApiRequest request) {
        final String url =
                UriComponentsBuilder.fromHttpUrl(config.getBaseUrl())
                        .path(getPostUserPath(request.getId(), request.getFollowerId()))
                        .build()
                        .toString();

        return kyoGoFinderApiTemplate
                .exchange(url, HttpMethod.POST,
                        new HttpEntity<>(request.getBody(), new HttpHeaders()),
                        KyoGoFinderUserApiResponse.class)
                .getBody();
    }

    /**
     * /api/v1/user/oldestパスの取得.
     *
     * @return パス
     */
    private String getOldestUserPath() {
        return config.getPath() + "oldest";
    }

    /**
     * /api/v1/user/:id/follower/:followerIdパスの取得.
     *
     * @param id         フォロー元ユーザID
     * @param followerId フォロワーID
     * @return パス
     */
    private String getPostUserPath(final String id, final String followerId) {
        return config.getPath() + id + "/follower/" + followerId;
    }
}
