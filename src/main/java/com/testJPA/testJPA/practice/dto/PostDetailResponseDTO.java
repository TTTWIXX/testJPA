package com.testJPA.testJPA.practice.dto;

import com.testJPA.testJPA.practice.entity.HashTag;
import com.testJPA.testJPA.practice.entity.Post;
import lombok.*;

import javax.persistence.Column;
import java.util.List;
import java.util.stream.Collectors;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class PostDetailResponseDTO {


    private String writer; // 작성자
    private String title; // 제목
    private String content; // 내용
    private List<String> hashTags; //  해쉬태그


    public PostDetailResponseDTO(Post post) {
        this.writer = post.getWriter();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.hashTags = post.getHashTags()
                        .stream()
                        .map(HashTag::getTagName)
                        .collect(Collectors.toList());


    }

    ;


}
