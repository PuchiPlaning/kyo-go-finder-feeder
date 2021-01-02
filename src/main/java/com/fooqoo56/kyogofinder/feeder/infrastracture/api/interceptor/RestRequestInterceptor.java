package com.fooqoo56.kyogofinder.feeder.infrastracture.api.interceptor;

import java.io.IOException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class RestRequestInterceptor implements ClientHttpRequestInterceptor {

    /**
     * interceptor.
     *
     * @param request   リクエスト
     * @param body      ボディ
     * @param execution ClientHttpRequestExecution
     * @return ClientHttpResponse
     * @throws IOException IOException
     */
    @Override
    public ClientHttpResponse intercept(
            final HttpRequest request, final byte[] body,
            final ClientHttpRequestExecution execution) throws IOException {

        log.info(
                "api request - {}: {}", request.getMethodValue(),
                request.getURI());
        final ClientHttpResponse response =
                execution.execute(request, body);
        log.info(
                "api response - {}: {}",
                response.getRawStatusCode(),
                response.getStatusText());

        return response;
    }
}
