package com.tenpo.apirest.application.service;


import com.tenpo.apirest.infrastructure.client.PercentageClient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
public class MathOperationsService {
  private PercentageClient client;
    public MathOperationsService(PercentageClient client) {
        this.client = client;
    }
    public Integer additionWithPercentage(Integer numA, Integer numB){
      var percentage = client.getPercentageValue();
      var sum = (numA + numB);
      var result = sum + (sum* percentage / 100);
      return result;
  }
}
