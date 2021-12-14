package com.jaewook.studyspringbootwebservice.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class PostsUpdateReqDto {
    private String title;
    private String content;
}
