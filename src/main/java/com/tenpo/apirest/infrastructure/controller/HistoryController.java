package com.tenpo.apirest.infrastructure.controller;

import com.tenpo.apirest.application.service.HistoryService;
import com.tenpo.apirest.domain.History;
import com.tenpo.apirest.infrastructure.controller.response.ErrorsResponse;
import com.tenpo.apirest.infrastructure.mapper.EnabledHistory;
import com.tenpo.apirest.infrastructure.mapper.SortType;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/api/v1/history")
@Tag(name = "History", description = "Operations related to history")
@AllArgsConstructor
public class HistoryController {

    private HistoryService service;

    @ApiResponse(
            responseCode = "400",
            description = "When the request have a field invalid we response this",
            content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorsResponse.class))
            }
    )
    @Operation(summary = "Return a page with history can be sorted for timestamp or not")
    @GetMapping
    public ResponseEntity<Page<History>> getAll(
            @RequestHeader(value = "EnabledHistory", defaultValue = "DISABLED") EnabledHistory enabledHistory,
            @RequestParam Integer page,
            @RequestParam Integer size,
            @RequestParam SortType sortType
    ){
        if(Objects.isNull(sortType))sortType=SortType.NONE;
        var response = service.readAll(page, size, sortType);
        return  response.isEmpty()?ResponseEntity.noContent().build():ResponseEntity.ok(response);
    }

    @Operation(summary = "Save a history")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<History> post(
            @RequestHeader(value = "EnabledHistory", defaultValue = "DISABLED") EnabledHistory enabledHistory,
            @RequestBody History request){
        return ResponseEntity.ok(service.created(request));
    }
    @Operation(summary = "Return a history")
    @GetMapping(path = "/{id}")
    public ResponseEntity<History> get(
            @RequestHeader(value = "EnabledHistory", defaultValue = "DISABLED") EnabledHistory enabledHistory,
            @PathVariable Integer id){
        return  ResponseEntity.ok(service.read(id));
    }

    @Operation(summary = "Update history")
    @PutMapping(path = "/{id}")
    public ResponseEntity<History> put(
            @RequestHeader(value = "EnabledHistory", defaultValue = "DISABLED") EnabledHistory enabledHistory,
            @PathVariable Integer id, @RequestBody History request){
        return ResponseEntity.ok(service.update(request, id));
    }
    @Operation(summary = "Delete a history")
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(
            @RequestHeader(value = "EnabledHistory", defaultValue = "DISABLED") EnabledHistory enabledHistory,
            @PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
