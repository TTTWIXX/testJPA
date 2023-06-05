package com.testJPA.testJPA.jpa.repository;

import com.testJPA.testJPA.jpa.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department,Long> {


    @Query("SELECT DISTINCT de FROM Department de JOIN FETCH de.employees")
    List<Department> findAllJoinEmployees();


}
