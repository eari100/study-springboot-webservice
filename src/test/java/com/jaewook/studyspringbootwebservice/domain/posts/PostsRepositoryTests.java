package com.jaewook.studyspringbootwebservice.domain.posts;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class PostsRepositoryTests {

    @Autowired
    private PostsRepository postsRepository;

    @AfterEach
    public void cleanUp() {
        postsRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기() {
        // given
        String title = "테스트 게시글";
        String content = "테스트 본문";
        String author = "eari100@naver.com";

        postsRepository.save(Posts.builder()
            .title(title)
            .content(content)
            .author(author)
            .build());

        // when
        List<Posts> postsList = postsRepository.findAll();

        // then
        Posts posts = postsList.get(0);
        assertEquals(title, posts.getTitle());
        assertEquals(content, posts.getContent());
        assertEquals(author, posts.getAuthor());
    }

    @Test
    public void BaseTimeEntity_등록() {
        // given
        LocalDateTime pastTime = LocalDateTime.of(2019, 6, 4, 0, 0,0);
        postsRepository.save(Posts.builder()
            .title("title")
            .content("content")
            .author("author")
            .build());

        // when
        List<Posts> all = postsRepository.findAll();

        // then
        Posts posts = all.get(0);

        System.out.println(">>>>>> createDate=" + posts.getCreatedDate()
            +", modifiedDate=" + posts.getModifiedDate());

        assertThat(posts.getCreatedDate()).isAfter(pastTime);
        assertThat(posts.getModifiedDate()).isAfter(pastTime);
    }

}
