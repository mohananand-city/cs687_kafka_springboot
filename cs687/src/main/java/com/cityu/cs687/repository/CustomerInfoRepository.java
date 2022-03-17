package com.cityu.cs687.repository;

import com.cityu.cs687.dto.CustomerInfoDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerInfoRepository extends JpaRepository<CustomerInfoDto, String> {
}
