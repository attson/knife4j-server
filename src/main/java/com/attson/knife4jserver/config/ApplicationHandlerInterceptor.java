package com.attson.knife4jserver.config;

import com.attson.knife4jserver.response.Response;
import org.apache.logging.log4j.util.Strings;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@ControllerAdvice
public class ApplicationHandlerInterceptor implements ResponseBodyAdvice<Response<Object>> {

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return returnType.getParameterType().isAssignableFrom(Response.class);
    }

    @Override
    public Response<Object> beforeBodyWrite(Response<Object> body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        assert body != null;
        if (Strings.isNotBlank(body.errorCode)) {
            response.setStatusCode(HttpStatusCode.valueOf(errorStatus(body.errorCode)));
        }

        return body;
    }

    public int errorStatus(String code) {
        var intCode = Integer.parseInt(code);

        if (intCode < 600) {
            return intCode;
        }

        return 500;
    }
}
