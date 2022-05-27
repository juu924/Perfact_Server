package com.perfact.server.dto.bookmark;

import com.perfact.server.domain.Home;
import lombok.Getter;

@Getter
public class SearchHomeDto {
    private double homeLat;
    private double homeLong;
    private String homeAddr;


    public SearchHomeDto(Home entity){
        homeLat = entity.getHomeLat();
        homeLong = entity.getHomeLong();
        homeAddr = entity.getHomeAddr();
    }


}
