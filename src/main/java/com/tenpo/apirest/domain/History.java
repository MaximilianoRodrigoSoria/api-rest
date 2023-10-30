package com.tenpo.apirest.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@Builder
public class History {


        private String endpoint;
        private String requestBody;
        private String responseBody;
        private String status;
        private String method;
        private LocalDateTime timestamp;
        private boolean success;


}
