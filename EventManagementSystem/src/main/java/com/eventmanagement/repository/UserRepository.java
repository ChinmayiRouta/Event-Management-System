package com.eventmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.eventmanagement.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
