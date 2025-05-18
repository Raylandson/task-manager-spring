package com.example.taskmanager.repository;

import java.util.Optional;

// import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.taskmanager.model.entity.User;

// import io.micrometer.common.lang.NonNull;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);


    // Optional<User> findById(Long id);

    // void deleteById(@NonNull Long id);

    // void deleteByUsername(String username);

    // User save(User user);
}
