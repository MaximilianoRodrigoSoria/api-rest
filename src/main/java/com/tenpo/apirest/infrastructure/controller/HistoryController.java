package com.tenpo.apirest.infrastructure.controller;

import com.tenpo.apirest.application.service.HistoryService;
import com.tenpo.apirest.domain.History;
import com.tenpo.apirest.infrastructure.mapper.SortType;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("/history")
@Tag(name = "History", description = "Operations related to history")
@AllArgsConstructor
public class HistoryController {

    private HistoryService service;
    @Operation(summary = "Return a page with history can be sorted or not")
    @GetMapping
    public ResponseEntity<Page<History>> getAll(
            @RequestParam Integer page,
            @RequestParam Integer size,
            @RequestParam SortType sortType
    ){
        if(Objects.isNull(sortType))sortType=SortType.NONE;
        var response = service.readAll(page, size, sortType);
        return  response.isEmpty()?ResponseEntity.noContent().build():ResponseEntity.ok(response);
    }
}
