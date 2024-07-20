package com.example.SpringBoot.REST.API.Repository;

import com.example.SpringBoot.REST.API.Entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long > {
}
