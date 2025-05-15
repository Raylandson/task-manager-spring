package com.example.taskmanager.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.taskmanager.model.entity.User;

@Configuration
public class UserConfig {

    @Bean
    public User user() {
        return new User(1L, "bolsonaro", "2222222");
    }
}
