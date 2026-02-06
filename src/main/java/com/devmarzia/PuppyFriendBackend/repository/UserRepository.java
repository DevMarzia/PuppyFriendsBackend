package com.devmarzia.PuppyFriendBackend.repository;
// serve per cercare l'utente per email durante il login

import com.devmarzia.PuppyFriendBackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByEmail(String email);
    boolean existsByEmail(String email);
}