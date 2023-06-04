package com.testJPA.testJPA.jpa.repository;

import com.testJPA.testJPA.jpa.entity.JpaEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static com.testJPA.testJPA.jpa.entity.JpaEntity.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback(value = false)
class JpaRepositoryTest {

    @Autowired
    JpaRepository jpaRepository;

    @BeforeEach
    void insertBulk() {
        JpaEntity e1 = builder()
                .name("신사임당")
                .gender(Gender.F)
                .salary(2000000)
                .build();

        JpaEntity e2 = builder()
                .name("이순신")
                .gender(Gender.M)
                .salary(2000000)
                .build();

        JpaEntity e3 = builder()
                .name("세종대왕")
                .gender(Gender.M)
                .salary(2500000)
                .build();


        JpaEntity save1 = jpaRepository.save(e1);
        JpaEntity save2 = jpaRepository.save(e2);
        JpaEntity save3 = jpaRepository.save(e3);
    }

    @Test
    @DisplayName("상품 전체 조회를 하면 3개여야 한다.")
    void testFindAll() {
        //given
        //when
        List<JpaEntity> empList = jpaRepository.findAll();
        //then
        empList.forEach(System.out::println);

        assertEquals(3,empList.size());
    }
    
    @Test
    @DisplayName("id가 3인 row를 찾고싶다.")
    void testFindOne() {
        //given
        Long id =3L;
        //when
        Optional<JpaEntity> employee = jpaRepository.findById(id);

        //then
        employee.ifPresent(p->{
            assertEquals("세종대왕",p.getName());
        });

        JpaEntity foundEmployee = employee.get();
        assertNotNull(foundEmployee);

        System.out.println("\nfoundEmployee = " + foundEmployee);


    }

    @Test
    @DisplayName("2번 emp의 이름과 성별을 변경해야 한다.")
    void modify() {
        //given
        long id=2;
        String newName="순신";
        Gender changeGender= Gender.F;

        //when
        // JPA에서는 UPDATE가 따로 없고 조회 후 SETTER로 변셩한다.
        // 변경후 다시 SAVE

        Optional<JpaEntity> byId = jpaRepository.findById(id);
        byId.ifPresent(d->{
            d.setName(newName);
            d.setGender(changeGender);
            jpaRepository.save(d);
        });
        //then

        assertTrue(byId.isPresent());

        JpaEntity en = byId.get();
        assertEquals("순신",en.getName());
    }

    @Test
    @DisplayName("id가 2번인 데이터를 제거해야한다.")
    void delete() {
        //given
        long id =2L;
        //when
        jpaRepository.deleteById(id);

        //then


    }

}