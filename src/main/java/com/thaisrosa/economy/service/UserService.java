package com.thaisrosa.economy.service;

import com.thaisrosa.economy.domain.User;
import com.thaisrosa.economy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User create(User user) {
        userRepository.save(user);
        return user;
    }

    public User getByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User login(String email, String senha) {
        User user = userRepository.findByEmail(email);
        if (senha.equals(user.getSenha())) {
            String token = UUID.randomUUID().toString();
            user.setToken(token);
            userRepository.save(user);
            return user;
        }
        else {
            return null;
        }
    }
}
