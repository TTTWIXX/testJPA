package com.testJPA.testJPA.jpa.repository;

import com.testJPA.testJPA.jpa.entity.Department;
import com.testJPA.testJPA.jpa.entity.Employee;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback
class DepartmentRepositoryTest {

    @Autowired
    DepartmentRepository departmentRepository;
    @Autowired
    EmployeeRepository employeeRepository;

    @Test
    @DisplayName("특정 부서를 조회하면 해당 부서원들도 함께 조회한다.!!!")
    void testJoin() {
        //given
        Long id = 2L;
        Department department = departmentRepository.findById(id).orElseThrow();

        //when
        System.out.println("\n\n\n");
        System.out.println("department = " + department);
        System.out.println("department.getEmployees(); = " + department.getEmployees());
        System.out.println("\n\n\n");

        //then
    }

    @Test
    @DisplayName("양방향 연관관계에서 연관데이터의 수정")
    void testChangeDept() {
        // 3번사원의 부서를 2번부서에 1번부서로 변경해야 한다.
        //given

        Employee employee
                = employeeRepository.findById(3L).orElseThrow();

        Department department
                = departmentRepository.findById(1L).orElseThrow();

        //when
        employee.setDepartment(department);

        employeeRepository.save(employee);


        //then
        Department foundD = departmentRepository.findById(1L).orElseThrow();
        System.out.println("\n\n\n");
        foundD.getEmployees().forEach(System.out::println);
        System.out.println("\n\n\n");

    }



}