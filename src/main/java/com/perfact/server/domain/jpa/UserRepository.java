package com.perfact.server.domain.jpa;

import com.perfact.server.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
   Optional<User>findUserByEmail(String email);
}
