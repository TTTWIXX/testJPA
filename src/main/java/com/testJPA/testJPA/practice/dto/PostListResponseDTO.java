package com.testJPA.testJPA.practice.dto;

import com.testJPA.testJPA.practice.dto.page.PageInfo;
import lombok.*;

import java.util.List;

@Setter
@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostListResponseDTO {

    //페이징 정보
    private PageInfo pageInfo;

    //Post 정보
    private List<PostDetailResponseDTO> postList;





}
