package com.testJPA.testJPA.practice.repository;

import com.testJPA.testJPA.practice.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {


}
