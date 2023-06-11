package com.testJPA.testJPA.practice.service;

import com.testJPA.testJPA.practice.dto.PageDTO;
import com.testJPA.testJPA.practice.dto.PostDetailResponseDTO;
import com.testJPA.testJPA.practice.dto.PostListResponseDTO;
import com.testJPA.testJPA.practice.dto.PostRequestSaveDTO;
import com.testJPA.testJPA.practice.dto.page.PageInfo;
import com.testJPA.testJPA.practice.entity.HashTag;
import com.testJPA.testJPA.practice.entity.Post;
import com.testJPA.testJPA.practice.repository.HashTagRepository;
import com.testJPA.testJPA.practice.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class PostService {

    private final PostRepository postRepository;
    private final HashTagRepository hashTagRepository;


    public PostListResponseDTO getPosts(PageDTO pageDTO) {
        // 페이징 처리된 post를 보고싶다.

        // Pageable 객체 생성
        Pageable pageable
                = PageRequest.of(pageDTO.getPageNo() - 1
                , pageDTO.getAmount()
                , Sort.by("createDate").descending());

        // PostListResponseDTO에 넣을 List<PostDetailResponseDTO> 만들기
        Page<Post> posts = postRepository.findAll(pageable);
        List<Post> postList = posts.getContent();

        List<PostDetailResponseDTO> postDetailResponseDTOS = postList.stream()
                .map(PostDetailResponseDTO::new)
                .collect(Collectors.toList());

        return PostListResponseDTO.builder()
                .pageInfo(new PageInfo<Post>(posts))
                .postList(postDetailResponseDTOS)
                .build();
    }

    // 저장기능
    public PostDetailResponseDTO insert(PostRequestSaveDTO dto) {
        Post postEntity = dto.changeToEntity();
        Post save = postRepository.save(postEntity);
        if (dto.getHashTags().size() > 0 && dto.getHashTags() != null) {
            List<HashTag> hashTags = dto.getHashTags();
            hashTags.forEach(d ->
                    hashTagRepository.save(HashTag.builder()
                            .tagName(d.getTagName())
                            .post(postEntity)
                            .build()));

        }


            return new PostDetailResponseDTO(save);


    }
