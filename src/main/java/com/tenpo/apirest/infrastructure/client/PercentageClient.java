package com.tenpo.apirest.infrastructure.client;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
@Service
public class PercentageClient {

    @Value("percentage.service.host")
    private String host;

    private WebClient webClient;

    public PercentageClient(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl(host).build();
    }
    public String getPercentage() {
        return webClient
                .get()
                .uri("/percentage")
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
}
