package com.perfact.server.domain.jpa;

import com.perfact.server.domain.Schedule;
import com.perfact.server.dto.schedule.SearchScheduleDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;


public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    List<Schedule> findAllByOrderByIdDesc();
}
