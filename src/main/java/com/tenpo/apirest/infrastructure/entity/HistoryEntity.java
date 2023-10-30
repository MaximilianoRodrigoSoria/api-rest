package com.tenpo.apirest.infrastructure.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "history")
@NoArgsConstructor
public class HistoryEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String endpoint;
        private String requestBody;
        private String responseBody;
        private String status;
        private String method;
        private LocalDateTime timestamp;
        private boolean success;


}
