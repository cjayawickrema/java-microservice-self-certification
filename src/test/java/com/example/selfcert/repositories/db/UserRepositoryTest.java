package com.example.selfcert.repositories.db;

import com.example.selfcert.framework.IntegrationTest;
import com.example.selfcert.models.User;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;


@Tag("integration")
class UserRepositoryTest extends IntegrationTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void shouldFindUserForValidId() {
        User user = userRepository.findUser(1L);
        assertThat(user).isNotNull();
        assertThat(user.getEmail()).isEqualTo("john@wick.com");
        assertThat(user.getName()).isEqualTo("John Wick");
    }

    @Test
    void shouldReturnNullForInvalidId() {
        User user = userRepository.findUser(-1L);
        assertThat(user).isNull();
    }
}