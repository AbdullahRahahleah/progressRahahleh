package com.Rahahleh.fxAnalyzer.repository;
import com.Rahahleh.fxAnalyzer.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
