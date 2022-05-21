package com.perfact.server.domain.dto.bookmark;

import com.perfact.server.domain.Company;

import lombok.Getter;

@Getter
public class SearchCompanyDto {

    private double companyLat;
    private double companyLong;
    private String companyAddr;

    public SearchCompanyDto(Company entity){
        companyLat = entity.getCompanyLat();
        companyLong = entity.getCompanyLong();
        companyAddr = entity.getCompanyAddr();
    }
}
