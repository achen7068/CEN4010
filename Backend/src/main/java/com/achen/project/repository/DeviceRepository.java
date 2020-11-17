package com.achen.project.repository;

import com.achen.project.repository.entity.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface DeviceRepository extends JpaRepository<Device,String>, QuerydslPredicateExecutor<Device> {
}
