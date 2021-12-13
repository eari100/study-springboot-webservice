package com.jaewook.studyspringbootwebservice.service;

import com.jaewook.studyspringbootwebservice.domain.posts.PostsRepository;
import com.jaewook.studyspringbootwebservice.web.dto.PostsSaveReqDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveReqDto postsSaveReqDto) {
        return postsRepository.save(postsSaveReqDto.toEntity()).getId();
    }
}
