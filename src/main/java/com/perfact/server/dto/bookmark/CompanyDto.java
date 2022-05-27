package com.perfact.server.dto.bookmark;

import com.perfact.server.domain.Company;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompanyDto {
    private Long userId;
    private double companyLat;
    private double companyLong;
    private String companyAddr;

    @Builder
    public CompanyDto(Long userId, double companyLat, double companyLong, String companyAddr) {
        this.userId = userId;
        this.companyLat = companyLat;
        this.companyLong = companyLong;
        this.companyAddr = companyAddr;
    }


    public Company toEntity(){
        return Company.builder()
                .userId(userId)
                .companyLat(companyLat)
                .companyLong(companyLong)
                .companyAddr(companyAddr)
                .build();
    }


}
