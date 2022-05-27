package com.perfact.server.domain.jpa;

import com.perfact.server.domain.Home;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HomeRepository extends JpaRepository<Home,Long> {
    Home findByUserId(Long userId);
}
