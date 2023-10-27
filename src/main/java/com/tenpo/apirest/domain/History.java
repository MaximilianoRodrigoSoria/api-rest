package com.tenpo.apirest.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor
public class History {

        private Long id;
        private String endpoint;
        private String request;
        private String response;
        private LocalDateTime timestamp;
        private boolean success;


}
