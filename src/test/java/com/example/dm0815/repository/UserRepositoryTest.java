package com.example.dm0815.repository;

import com.example.dm0815.domain.Gender;
import com.example.dm0815.domain.User;
import com.example.dm0815.domain.User;
import com.example.dm0815.domain.UserHistory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.IntStream;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserHistoryRepository userHistoryRepository;

    @Test
    public void createTest() {
        IntStream.rangeClosed(1,10).forEach(i ->{
            User user = User.builder()
                    .name("dsg" + i)
                    .email("title"+i+"@test.com")
                    .gender(Gender.FEMALE)
                    .build();
            System.out.println(userRepository.save(user));

        });

    }
    
    @Test
    void userRelationTest() {

        List<UserHistory> result = userHistoryRepository.findByUserId(
            userRepository.findByEmail("title10@test.com").getId());

        result.forEach(System.out::println);
    }
}