package com.example.selfcert.repositories.db;

import com.example.selfcert.framework.IntegrationTest;
import com.example.selfcert.models.User;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

@Tag("integration")
class UserRepositoryTest extends IntegrationTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void findUser() {
        User user = userRepository.findUser(1L);
        System.out.println(user);
    }
}