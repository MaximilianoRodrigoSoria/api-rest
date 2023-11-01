package com.tenpo.apirest.infrastructure.client;
import com.tenpo.apirest.infrastructure.controller.response.PercentageResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class PercentageClient {
    private final WebClient webClient;
    public PercentageClient(@Value("${percentage.service.host}") String percentageUrl) {
        this.webClient = WebClient.create(percentageUrl);
    }
    public Integer getPercentageValue() {
        return webClient.get()
                .uri("/percentage")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(PercentageResponse.class)
                .map(PercentageResponse::getValue)
                .block();
    }
}