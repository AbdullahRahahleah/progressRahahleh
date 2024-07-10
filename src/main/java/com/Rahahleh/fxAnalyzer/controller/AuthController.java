package com.Rahahleh.fxAnalyzer.controller;
import com.Rahahleh.fxAnalyzer.entity.AuthinticationResponse;
import com.Rahahleh.fxAnalyzer.entity.LoginRequest;
import com.Rahahleh.fxAnalyzer.entity.User;
import com.Rahahleh.fxAnalyzer.security.JwtResponse;
import com.Rahahleh.fxAnalyzer.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    loginRequest.getUsername(), loginRequest.getPassword()));
        } catch (AuthenticationException e) {
            return ResponseEntity.status(401).body("Invalid username or password");
        }

        String jwtToken = authService.login(loginRequest.getUsername(), loginRequest.getPassword());
        return ResponseEntity.ok(new JwtResponse(jwtToken));

    }

    @PostMapping("/signup")
    public String register(@RequestBody User user) {
        User savedUser = authService.saveUser(user);
        return "User registered with username: " + savedUser.getUsername();
    }


}
