package com.testJPA.testJPA.jpa.repository;

import com.testJPA.testJPA.jpa.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {


}
