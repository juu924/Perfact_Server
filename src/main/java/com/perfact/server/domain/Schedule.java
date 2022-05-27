package com.perfact.server.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@NoArgsConstructor
@Getter
@AllArgsConstructor
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Oauth id 연동
    private Long userId;

    @Column(length = 40, nullable = false)
    private String title;

    @Column(nullable = false)
    private String startDate;

    @Column(nullable = false)
    private String endDate;

    @Column(nullable = false)
    private String transport;

    @Column(nullable = false)
    private String readyTime;

    @Column(length = 500, nullable = false)
    private String memo;

    @Builder
    public Schedule(Long userId, String title, String startDate, String endDate, String readyTime, String transport, String memo){
        this.userId = userId;
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
        this.readyTime = readyTime;
        this.transport = transport;
        this.memo = memo;
    }

    public void update(String title, String startDate, String endDate,String readyTime, String transport, String memo){
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
        this.readyTime = readyTime;
        this.transport = transport;
        this.memo = memo;
    }

}
