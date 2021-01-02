package com.fooqoo56.kyogofinder.feeder.infrastracture.api.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;

public class RestTemplateConfig {

    /**
     * RestTemplateBuilder取得.
     *
     * @return RestTemplateBuilder
     */
    public static RestTemplateBuilder restTemplateBuilder() {
        final BufferingClientHttpRequestFactory bufferingClientHttpRequestFactory =
                new BufferingClientHttpRequestFactory(new SimpleClientHttpRequestFactory());

        return new RestTemplateBuilder().requestFactory(() -> bufferingClientHttpRequestFactory);
    }
}
