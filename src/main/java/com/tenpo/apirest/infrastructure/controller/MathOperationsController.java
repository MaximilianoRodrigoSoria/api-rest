package com.tenpo.apirest.infrastructure.controller;



import com.tenpo.apirest.application.service.MathOperationsService;
import com.tenpo.apirest.infrastructure.mapper.EnabledHistory;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/math")
@Tag(name = "Math operations controller", description = "Math operations controller")
@AllArgsConstructor
public class MathOperationsController {

    private MathOperationsService service;

    @GetMapping("/add-with-percentage")
    public Integer additionWithPercentage(
            @RequestHeader(value = "EnabledHistory", defaultValue = "ENABLED") EnabledHistory enabledHistory,
            @RequestParam(name = "numberA") @Pattern(regexp = "\\d+", message = "numberA parameter only accepts numeric values.") int numberA,
            @RequestParam(name = "numberB") @Pattern(regexp = "\\d+", message = "numberB parameter only accepts numeric values.") int numberb) {
        return service.additionWithPercentage(numberA, numberb);

    }
}
