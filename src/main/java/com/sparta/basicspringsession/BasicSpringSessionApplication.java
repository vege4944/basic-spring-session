package com.sparta.basicspringsession;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication

public class BasicSpringSessionApplication {

    public static void main(String[] args) {
        SpringApplication.run(BasicSpringSessionApplication.class, args);
    }

}
