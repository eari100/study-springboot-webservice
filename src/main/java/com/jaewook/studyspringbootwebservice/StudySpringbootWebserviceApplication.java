package com.jaewook.studyspringbootwebservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class StudySpringbootWebserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudySpringbootWebserviceApplication.class, args);
    }

}
