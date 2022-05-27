package com.perfact.server.dto.schedule;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
public class UpdateScheduleDto {
    private String title;
    private String startDate;
    private String endDate;
    private String readyTime;
    private String transport;
    private String suggestTime;
    private String memo;

    @Builder
    public UpdateScheduleDto(String title, String startDate, String endDate, String readyTime, String transport, String suggestTime, String memo) {
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
        this.readyTime = readyTime;
        this.transport = transport;
        this.suggestTime = suggestTime;
        this.memo = memo;

    }
}
