package com.tenpo.apirest.infrastructure.controller;

import com.tenpo.apirest.infrastructure.mapper.EnabledHistory;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HealthController {
    @GetMapping("/api/v1/health")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "For Success", content = @Content(schema = @Schema(implementation = String.class))),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema(implementation = Exception.class))),
    })
    @Operation(summary = "Health service")
    public ResponseEntity<String> health(@RequestHeader(value = "EnabledHistory", defaultValue = "DISABLED") EnabledHistory enabledHistory){
        return ResponseEntity
                .ok()
                .body("OK");}
}
