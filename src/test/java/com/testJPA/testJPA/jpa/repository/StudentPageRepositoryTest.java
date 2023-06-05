package com.testJPA.testJPA.jpa.repository;

import com.testJPA.testJPA.jpa.entity.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Transactional
@Rollback(value = false)
class StudentPageRepositoryTest {

    @Autowired
    StudentPageRepository studentPageRepository;

    @BeforeEach
    void InsertBulk(){
        for (int i = 1; i <=147 ; i++) {
            Student build = Student.builder()
                    .name("kimkim" + i)
                    .city("citycity" + i)
                    .major("majormajor" + i)
                    .build();
            studentPageRepository.save(build);

        }
    }

    @Test
    @DisplayName("testPaging")
    void searchAndPage() {
        //given
        String name = "ki";

        // 페이지 정보 생성!!!
        int size = 10;
        int page = 1;
        PageRequest pageRequest = PageRequest.of(page - 1, size);

        //when
        Page<Student> byNameContaining
                = studentPageRepository.findByNameContaining(name, pageRequest);

        // 페이징 완료된 List
        List<Student> contents = byNameContaining.getContent();

        // 총 페이지 수!
        int totalPages = byNameContaining.getTotalPages();

        // List 의 size!!!!
        long totalElements = byNameContaining.getTotalElements();

        Pageable prev = byNameContaining.getPageable().previousOrFirst();
        Pageable next = byNameContaining.getPageable().next();


        //then

        System.out.println("\n\n\n");
        System.out.println("totalPages = " + totalPages);
        System.out.println("totalElements = " + totalElements);
        System.out.println("prev = " + prev);
        System.out.println("next = " + next);
        System.out.println("\n\n\n");
        contents.forEach(System.out::println);
        System.out.println("\n\n\n");

    }

}