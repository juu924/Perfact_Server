package com.perfact.server.domain.jpa;

import com.perfact.server.domain.checklist.CheckList;
import com.perfact.server.domain.dto.checklist.ListSearchDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CheckListRepository extends JpaRepository<CheckList, Long> {
    List<ListSearchDto>findByUserId(Long user_id);
}
