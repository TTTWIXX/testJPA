package com.testJPA.testJPA.jpa.repository;

import com.testJPA.testJPA.jpa.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StudentPageRepository
        extends org.springframework.data.jpa.repository.JpaRepository<Student,String> {

    // 학생 조건없이 전체조회 페이징
//    Page<String> findAll(Pageable pageable);

    // 학생의 특정 이름이 들어간 List를 조회!
//    Page<Student> findByNameContaining(String name,Pageable pageable);
    Page<Student> findByNameContaining(String name, Pageable pageable);



}
