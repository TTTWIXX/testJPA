package com.testJPA.testJPA.jpa.entity;

import com.testJPA.testJPA.jpa.repository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Transactional
@Rollback
class StudentTest {

    @Autowired
    StudentRepository studentRepository;

    @BeforeEach
    void insertBulk() {
        //given
        Student s1 = Student.builder()
                .name("jack")
                .city("seoul")
                .major("math")
                .build();
        Student s2 = Student.builder()
                .name("john")
                .city("busan")
                .major("math")
                .build();
        Student s3 = Student.builder()
                .name("ashe")
                .city("hanwang")
                .major("physical")
                .build();
        //when

        studentRepository.save(s1);
        studentRepository.save(s2);
        studentRepository.save(s3);
    }

    @Test
    @DisplayName("이름이 춘식이인 학생의 정보를 조회")
    void findByName() {
        //given
        String name="john";
        //when
        List<Student> byName = studentRepository.findByName(name);

        //then

        System.out.println("\n\n\n");
        byName.forEach(System.out::println);
        System.out.println("\n\n\n");


    }
    
    @Test
    @DisplayName("findByCITYANDMAJOR")
    void findByCityAndMajor() {
        //given
        String major="math";
        String city="seoul";
        //when
        List<Student> byCityAndMajor = studentRepository.findByCityAndMajor(city, major);


        //then

        assertEquals(3,byCityAndMajor.size());
        assertEquals("jack",byCityAndMajor.get(0).getName());
        System.out.println("byCityAndMajor.get(0) = " + byCityAndMajor.get(0));

    }

    @Test
    @DisplayName("testFindByMajorContaining")
    void containingE() {
        //given
        String major="m";
        List<Student> byMajorContaining = studentRepository.findByMajorContaining(major);

        //when


        System.out.println("\n\n\n");
        byMajorContaining.forEach(System.out::println);
        System.out.println("\n\n\n");



        //then

    }

    @Test
    @DisplayName("using native query ")
    void nativeQuery() {
        //given
        String name="jack";

        //when
        List<Student> students = studentRepository.thisIsNativeQuery(name);


        //then
        System.out.println("\n\n\n\n");
        students.forEach(System.out::println);
        System.out.println("\n\n\n\n");
    }
    
    @Test
    @DisplayName("jpql 도시 로 찾기")
    void jpqlcity() {
        //given
        String city="seoul";

        //when
        List<Student> students = studentRepository.jpqlCity(city);

        //then
        System.out.println("\n\n\n");
        students.forEach(System.out::println);
        System.out.println("\n\n\n");
    }
    
    @Test
    @DisplayName("이름으로 지우기")
    void deleteByNameWithJPQL() {
        //given
        String name="jack";
        //when
        studentRepository.deleteByNameJpql(name);
        List<Student> all = studentRepository.findAll();

        //then
        System.out.println("\n\n\n");
        all.forEach(System.out::println);
        System.out.println("\n\n\n");

    }
    @Test
    @DisplayName("jac이 들어간 row 찾기")
    void jpqlContainetest() {
        //given
        String name="jac";

        //when
        List<Student> byNameConJPQL = studentRepository.findByNameConJPQL(name);

        //then
        System.out.println("\n\n\n");
        byNameConJPQL.forEach(System.out::println);
        System.out.println("\n\n\n");
    }

}