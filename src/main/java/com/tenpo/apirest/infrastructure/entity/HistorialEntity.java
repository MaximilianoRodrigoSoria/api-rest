package com.tenpo.apirest.infrastructure.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "history")
@NoArgsConstructor
public class HistorialEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String endpoint;
        private String request;
        private String response;
        private LocalDateTime timestamp;
        private boolean success;


}
