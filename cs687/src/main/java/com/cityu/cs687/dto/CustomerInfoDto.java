package com.cityu.cs687.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "customerinfo")
@Data
public class CustomerInfoDto {

  @Id
  @Column(name = "correlation_id")
  private String correlation_id;

  @Column(name = "first_name")
  private String first_name;

  @Column(name = "last_name")
  private String last_name;

}
