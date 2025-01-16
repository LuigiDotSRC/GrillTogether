package com.example.GrillTogether.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // TODO: protect this endpoint
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    // TODO: must hash the password before storing it
    public User addUser(User user) {
        return userRepository.save(user);
    }
}
