package com.perfact.server.dto.schedule;

import com.perfact.server.domain.Schedule;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;


@NoArgsConstructor
@Getter
@Setter
public class CreateScheduleDto {
    private Long userId;
    private String title;
    private String startDate;
    private String endDate;
    private String readyTime;
    private String transport;
    private String memo;


    @Builder
    public CreateScheduleDto(Long userId, String title, String startDate, String endDate,String readyTime, String transport, String memo) {
        this.userId = userId;
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
        this.readyTime = readyTime;
        this.transport = transport;
        this.memo = memo;

    }


    public Schedule toEntity(){
        return Schedule.builder()
                .userId(getUserId())
                .title(getTitle())
                .startDate(getStartDate())
                .endDate(getEndDate())
                .readyTime(getReadyTime())
                .transport(getTransport())
                .memo(getMemo())
                .build();
    }

}
