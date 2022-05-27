package com.perfact.server.domain.jpa;

import com.perfact.server.domain.CheckList;
import com.perfact.server.dto.checklist.ListSearchDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CheckListRepository extends JpaRepository<CheckList, Long> {
    List<ListSearchDto>findByUserId(Long userId);
}
