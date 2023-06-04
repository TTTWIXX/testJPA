package com.testJPA.testJPA.jpa.repository;

import com.testJPA.testJPA.jpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, String> {

    List<Student> findByName(String name);

    List<Student> findByCityAndMajor(String major, String city);

    List<Student> findByMajorContaining(String major);

    // native query(nativeQuery=true 필수!!!)
    @Query(value = "SELECT * FROM tbl_student where stu_name=:name", nativeQuery = true)
    List<Student> thisIsNativeQuery(@Param("name") String name);


    // JPQL
    //?1=> 첫번째 parameter
    @Query("SELECT st FROM Student st WHERE st.city=?1")
    List<Student> jpqlCity(String city);

    @Modifying
    @Query("DELETE FROM Student st WHERE st.name=?1")
    void deleteByNameJpql(String name);

    @Query("SELECT st FROM Student st WHERE st.name Like %:name%")
    List<Student> findByNameConJPQL(@Param("name") String name);


}
