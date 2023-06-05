package com.testJPA.testJPA.practice.repository;

import com.testJPA.testJPA.practice.entity.Post;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback
class PostRepositoryTest {

    @Autowired
    HashTagRepository hashTagRepository;
    @Autowired
    PostRepository postRepository;

    @Test
    @DisplayName("bulk Input")
    void insertBulk() {
        //given
        for (int i = 1 ; i <423 ; i++) {
            Post build = Post.builder()
                    .title("post" + i)
                    .content("postContent" + i)
                    .writer("lee" + i)
                    .build();
            postRepository.save(build);
        };

    }





}