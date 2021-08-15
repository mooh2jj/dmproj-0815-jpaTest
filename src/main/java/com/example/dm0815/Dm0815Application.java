package com.example.dm0815;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Dm0815Application {

    public static void main(String[] args) {
        SpringApplication.run(Dm0815Application.class, args);
    }

}
