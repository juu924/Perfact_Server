package com.perfact.server.dto.schedule;

import com.perfact.server.domain.Schedule;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class SearchScheduleDto {
    private Long id;
    private Long userId;
    private String title;
    private String startDate;
    private String endDate;
    private String readyTime;
    private String memo;

    public SearchScheduleDto(Schedule entity){
        this.id = entity.getId();
        this.userId = entity.getUserId();
        this.title = entity.getTitle();
        this.startDate = entity.getStartDate();
        this.endDate = entity.getEndDate();
        this.readyTime = entity.getReadyTime();
        this.memo = entity.getMemo();
    }
}
