package com.testJPA.testJPA.practice.dto;

import com.testJPA.testJPA.practice.entity.HashTag;
import com.testJPA.testJPA.practice.entity.Post;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@Setter
@Getter
@Builder
@ToString
@EqualsAndHashCode
public class PostRequestSaveDTO {

    @NotNull
    private String title;
    @NotNull
    private String content;
    @NotNull
    private String writer;

    private List<HashTag> hashTags;

    public Post changeToEntity() {
        return Post.builder()
                .title(this.title)
                .content(this.content)
                .writer(this.writer)
                .build();

    }

}
