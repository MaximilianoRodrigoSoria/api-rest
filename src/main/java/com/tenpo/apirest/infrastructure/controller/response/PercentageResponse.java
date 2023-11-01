package com.tenpo.apirest.infrastructure.controller.response;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
public class PercentageResponse  implements Serializable {
        @JsonProperty("value")
        private int value;
        @JsonCreator
        public PercentageResponse(@JsonProperty("value") int value) {
                this.value = value;
        }
}
