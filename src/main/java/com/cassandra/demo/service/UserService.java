package com.cassandra.demo.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.cassandra.demo.cluster.UserRepository;
import com.cassandra.demo.exception.UserNotFoundException;
import com.cassandra.demo.model.User;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public void deleteUserById(String id) {
        UUID userId = UUID.fromString(id);
        userRepository.deleteById(userId);
    }

    public User findUserById(String id) {
        UUID userId = UUID.fromString(id);
        return userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found with ID: " + id));

    }

    public User createUser(String name) {
        User user = new User();
        user.setId(UUID.randomUUID());
        user.setName(name);
        return userRepository.save(user);
    }

    public User updateUser(String id, String name) {
        User user = this.findUserById(id);
        user.setName(name);
        return userRepository.save(user);

    }

}
