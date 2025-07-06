package com.example.myretro;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.myretro.client.User;
import com.example.myretro.client.UsersClient;

@SpringBootTest
public class UsersClientTest {
    @Autowired
    UsersClient usersClient;

    @Test
    public void findUserTest() {
        User user = usersClient.findUserByEmail("norma@email.com");
        assertThat(user).isNotNull();
        assertThat(user.getName()).isEqualTo("Norma");
        assertThat(user.getEmail()).isEqualTo("norma@email.com");
    }
}
