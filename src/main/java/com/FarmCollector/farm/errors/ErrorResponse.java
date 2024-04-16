package com.FarmCollector.farm.errors;

import java.util.List;

import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@XmlRootElement(name = "error")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ErrorResponse {

  private String message;
  private List<String> details;
}

