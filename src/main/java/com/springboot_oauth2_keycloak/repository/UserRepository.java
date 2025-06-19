package com.springboot_oauth2_keycloak.repository;

import com.springboot_oauth2_keycloak.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    boolean existsByEmail(String email);

    List<User> findUserByAddress(String address);
}
