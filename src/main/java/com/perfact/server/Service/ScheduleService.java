package com.perfact.server.Service;

import com.perfact.server.domain.Schedule;
import com.perfact.server.dto.schedule.CreateScheduleDto;
import com.perfact.server.dto.schedule.SearchScheduleDto;
import com.perfact.server.dto.schedule.UpdateScheduleDto;
import com.perfact.server.domain.jpa.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    //사용자 일정 등록
    @Transactional
    public Long saveSchedule(CreateScheduleDto createScheduleDto) {
        return scheduleRepository.save(createScheduleDto.toEntity()).getId();
    }

    //사용자의 일정 전체 조회
    @Transactional(readOnly = true)
    public List<SearchScheduleDto> getScheduleList(Long userId) {
        return scheduleRepository.findAllByOrderByIdDesc().stream()
                .map(SearchScheduleDto::new)
                .collect(Collectors.toList());
    }

    //사용자의 일정 조회
    @Transactional(readOnly = true)
    public SearchScheduleDto getSchedule(Long id) {
        Schedule schedule = scheduleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 일정이 존재하지 않습니다."));
        return new SearchScheduleDto(schedule);
    }


    //사용자 일정 수정
    @Transactional
    public Long updateSchedule(Long id, UpdateScheduleDto updateScheduleDto) {
        Schedule schedule = scheduleRepository.findById(id)
                .orElseThrow(() -> new
                        IllegalArgumentException("해당 일정이 존재하지 않습니다."));

        schedule.update(updateScheduleDto.getTitle(), updateScheduleDto.getStartDate(), updateScheduleDto.getEndDate(),
                updateScheduleDto.getReadyTime(), updateScheduleDto.getTransport(), updateScheduleDto.getMemo());

        return id;
    }


    //사용자 일정 삭제
    @Transactional
    public void deleteSchedule(Long id) {
        Schedule schedule = scheduleRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 일정이 존재하지 않습니다."));
        scheduleRepository.delete(schedule);
    }


}
