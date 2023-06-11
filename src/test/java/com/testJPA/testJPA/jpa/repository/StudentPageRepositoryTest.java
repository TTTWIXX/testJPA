package com.testJPA.testJPA.jpa.repository;

import com.testJPA.testJPA.jpa.entity.Student;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Transactional
@Rollback
class StudentPageRepositoryTest {

    @Autowired
    StudentPageRepository studentPageRepository;

//    @BeforeEach
//    void InsertBulk(){
//        for (int i = 1; i <=147 ; i++) {
//            Student build = Student.builder()
//                    .name("kimkim" + i)
//                    .city("citycity" + i)
//                    .major("majormajor" + i)
//                    .build();
//            studentPageRepository.save(build);
//
//        }
//    }
    
    @Test
    @DisplayName("testPaging")
    void searchAndPage() {
        //given
        String name="ki";
        // 페이지 정보 생성!!!
        int size=10;
        int page=1;
        PageRequest pageRequest = PageRequest.of(page-1, size);

        //when
        Page<Student> byNameContaining
                = studentPageRepository.findByNameContaining(name, pageRequest);

        List<Student> contents = byNameContaining.getContent();
        //then

        System.out.println("\n\n\n");
        contents.forEach(System.out::println);
        System.out.println("\n\n\n");



    }

}