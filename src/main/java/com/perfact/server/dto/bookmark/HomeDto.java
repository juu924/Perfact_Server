package com.perfact.server.dto.bookmark;

import com.perfact.server.domain.Home;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HomeDto {
    private Long userId;
    private double homeLat;
    private double homeLong;
    private String homeAddr;

    @Builder
    public HomeDto(Long userId, double homeLat, double homeLong, String homeAddr){
        this.userId = userId;
        this.homeLat =homeLat;
        this.homeLong = homeLong;
        this.homeAddr = homeAddr;
    }

    public Home toEntity(){
        return Home.builder()
                .userId(userId)
                .homeLat(homeLat)
                .homeLong(homeLong)
                .homeAddr(homeAddr)
                .build();

    }

}
