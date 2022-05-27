package com.perfact.server.domain.jpa;

import com.perfact.server.domain.Company;
import com.perfact.server.domain.Home;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CompanyRepository extends JpaRepository<Company, Long> {
    Company findByUserId(Long userId);
}
