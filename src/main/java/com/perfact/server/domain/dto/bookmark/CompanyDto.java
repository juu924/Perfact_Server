package com.perfact.server.domain.dto.bookmark;

import com.perfact.server.domain.Company;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompanyDto {
    private Long id;
    private Long userId;
    private double companyLat;
    private double companyLong;
    private String companyAddr;

    @Builder
    public CompanyDto(Long id, Long userId, double companyLat, double companyLong, String companyAddr) {
        this.id = id;
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
