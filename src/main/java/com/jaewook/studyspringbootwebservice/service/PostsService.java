package com.jaewook.studyspringbootwebservice.service;

import com.jaewook.studyspringbootwebservice.domain.posts.Posts;
import com.jaewook.studyspringbootwebservice.domain.posts.PostsRepository;
import com.jaewook.studyspringbootwebservice.web.dto.PostsListResDto;
import com.jaewook.studyspringbootwebservice.web.dto.PostsResDto;
import com.jaewook.studyspringbootwebservice.web.dto.PostsSaveReqDto;
import com.jaewook.studyspringbootwebservice.web.dto.PostsUpdateReqDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveReqDto postsSaveReqDto) {
        return postsRepository.save(postsSaveReqDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateReqDto postsUpdateReqDto) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        posts.update(postsUpdateReqDto.getTitle(), postsUpdateReqDto.getContent());

        return id;
    }

    public PostsResDto findById(Long id) {
        Posts entity = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        return new PostsResDto(entity);
    }

    @Transactional(readOnly = true)
    public List<PostsListResDto> findAllDesc() {
        return postsRepository.findAllByOrderByIdDesc().stream()
                .map(PostsListResDto::new)
                .collect(Collectors.toList());
    }

}
