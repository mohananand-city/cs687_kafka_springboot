package com.cityu.cs687.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CustomerInfo {

  @JsonProperty
  String firstName;

  @JsonProperty
  String lastName;

}
