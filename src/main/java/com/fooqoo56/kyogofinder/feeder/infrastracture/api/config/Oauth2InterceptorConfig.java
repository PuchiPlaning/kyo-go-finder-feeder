package com.fooqoo56.kyogofinder.feeder.infrastracture.api.config;

import com.fooqoo56.kyogofinder.feeder.infrastracture.api.interceptor.Oauth2Interceptor;
import com.fooqoo56.kyogofinder.feeder.infrastracture.api.repositoryimpl.BearerTokenClient;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;

@RequiredArgsConstructor
public class Oauth2InterceptorConfig {

    /**
     * twitterOauth2Interceptor.
     *
     * @param bearerTokenClient bearerトークン
     * @return Oauth2Interceptor
     */
    @Bean
    public Oauth2Interceptor twitterOauth2Interceptor(
            final BearerTokenClient bearerTokenClient) {
        return new Oauth2Interceptor(bearerTokenClient);
    }
}
