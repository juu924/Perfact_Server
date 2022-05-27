package com.perfact.server.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Home {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //추후에 user table 과 관계 매핑
    @Column(name = "user_id")
    private Long userId;

    //집 위도 좌표
    @Column(nullable = false)
    private double homeLat;

    //집 경도 좌표
    @Column(nullable = false)
    private double homeLong;

    @Column(nullable = false)
    private String homeAddr;

    @Builder
    public Home(Long userId, double homeLat, double homeLong, String homeAddr){
        this.userId = userId;
        this.homeLat = homeLat;
        this.homeLong = homeLong;
        this.homeAddr = homeAddr;
    }

    public void update(double homeLat, double homeLong, String homeAddr){
        this.homeLat = homeLat;
        this.homeLong = homeLong;
        this.homeAddr = homeAddr;
    }






}
