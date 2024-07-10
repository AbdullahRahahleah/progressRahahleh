package com.Rahahleh.fxAnalyzer.service;

import com.Rahahleh.fxAnalyzer.entity.User;
import com.Rahahleh.fxAnalyzer.repository.UserRepository;
import com.Rahahleh.fxAnalyzer.security.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    public String login(String username, String password) throws Exception {
        User user = userRepository.findByUsername(username);
        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            // Generate JWT token
            return generateToken(username);
        }
        throw new Exception("invalid user name/password");
    }

    public User saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    private String generateToken(String username) {
        return jwtTokenUtil.generateToken(username);
    }
}
