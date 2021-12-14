package com.jaewook.studyspringbootwebservice.web;

import com.jaewook.studyspringbootwebservice.service.PostsService;
import com.jaewook.studyspringbootwebservice.web.dto.PostsResDto;
import com.jaewook.studyspringbootwebservice.web.dto.PostsSaveReqDto;
import com.jaewook.studyspringbootwebservice.web.dto.PostsUpdateReqDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {
    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveReqDto reqDto) {
        return postsService.save(reqDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateReqDto dto) {
        return postsService.update(id, dto);
    }

    @GetMapping("api/v1/posts/{id}")
    public PostsResDto findById(@PathVariable Long id) {
        return postsService.findById(id);
    }
}
