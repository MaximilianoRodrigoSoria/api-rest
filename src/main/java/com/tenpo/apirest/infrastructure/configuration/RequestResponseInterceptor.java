package com.tenpo.apirest.infrastructure.configuration;


import com.tenpo.apirest.domain.History;
import com.tenpo.apirest.infrastructure.mapper.EnabledHistory;
import com.tenpo.apirest.infrastructure.util.JsonHandler;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.Optional;

@Component
@Slf4j
public class RequestResponseInterceptor implements HandlerInterceptor {


    public RequestResponseInterceptor(JsonHandler jsonHandler) {
        this.jsonHandler = jsonHandler;
    }

    private final JsonHandler jsonHandler;

    private boolean isFirstCall = true;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        try {
//
//            if (request.getMethod().equals("POST") && request.getContentType() != null && request.getContentType().startsWith(MediaType.APPLICATION_JSON_VALUE)) {
//                InputStream inputStream = request.getInputStream();
//                Object requestBody = new String(inputStream.readAllBytes());
//                request.setAttribute("requestBody", requestBody);
//                isFirstCall = false;
//            } else {
//                request.setAttribute("requestBody", "NONE");
//            }
//        }catch (HttpMessageNotReadableException e){
//                log.error(e.getMessage());
//        }
//
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

        try {
            String enabledHistory = Optional.ofNullable(request.getHeader("EnabledHistory")).orElse("");
            if(EnabledHistory.ENABLED.toString().equals(enabledHistory)){

                String endpoint = getFullUri(request);
                String method = request.getMethod();
                String statusCode = String.valueOf(response.getStatus());
                String requestBody = (String) Optional.ofNullable(request.getAttribute("requestBody")).orElse("NONE");
                String responseContent = getRequestBodyResponse(response);
                LocalDateTime timestamp = LocalDateTime.now();
                boolean success = response.getStatus() == HttpServletResponse.SC_OK;

                History history = History.builder()
                        .requestBody(requestBody)
                        .requestBody("requestContent")
                        .success(success)
                        .timestamp(timestamp)
                        .endpoint(endpoint)
                        .status(statusCode)
                        .method(method)
                        .build();
                System.out.println(history.toString());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }


    private String getFullUri(HttpServletRequest request) {
        HttpRequest httpRequest = new ServletServerHttpRequest(request);
        UriComponents uriComponents = UriComponentsBuilder.fromHttpRequest(httpRequest).build();
        String scheme = uriComponents.getScheme();
        String serverName = request.getServerName();
        int serverPort = request.getServerPort();
        StringBuilder url = new StringBuilder();
        url.append(scheme).append("://");
        url.append(serverName);
        if (serverPort != 80 && serverPort != 443) {
            url.append(":").append(serverPort);
        }
        url.append(request.getRequestURI());
        String queryString = request.getQueryString();

        if (queryString != null) {
            url.append("?").append(queryString);
        }
        return url.toString();
    }

    private String getRequestBody(HttpServletRequest request) throws IOException {
        if ("POST".equalsIgnoreCase(request.getMethod())) {
            String requestBody = IOUtils.toString(request.getInputStream(), StandardCharsets.UTF_8);

            return "";

        } else {
            return "No es una solicitud POST";
        }
    }



    private String getRequestBodyResponse(HttpServletResponse response) {
        if (response instanceof ContentCachingRequestWrapper) {
            ContentCachingRequestWrapper contentCachingRequestWrapper = (ContentCachingRequestWrapper) response;
            String contentType = contentCachingRequestWrapper.getContentType();
            if (contentType != null && contentType.contains("application/json")) {
                byte[] content = contentCachingRequestWrapper.getContentAsByteArray();
                if (content != null && content.length > 0) {
                    return new String(content);
                }
            }
        }


        return "No content";
    }


}
