package com.perfact.server.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    //회사 위도 좌표
    @Column(nullable = false)
    private double companyLat;

    //회사 경도 좌표
    @Column(nullable = false)
    private double companyLong;

    @Column(nullable = false)
    private String companyAddr;

    @Builder
    public Company(Long userId, double companyLat, double companyLong, String companyAddr){
        this.userId = userId;
        this.companyLat = companyLat;
        this.companyLong = companyLong;
        this.companyAddr = companyAddr;
    }

    public void update(double companyLat, double companyLong, String companyAddr){
        this.companyLat = companyLat;
        this.companyLong = companyLong;
        this.companyAddr = companyAddr;
    }



}
