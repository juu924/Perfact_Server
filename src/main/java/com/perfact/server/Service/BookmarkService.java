package com.perfact.server.Service;

import com.perfact.server.domain.Company;
import com.perfact.server.domain.Home;
import com.perfact.server.dto.bookmark.CompanyDto;
import com.perfact.server.dto.bookmark.HomeDto;
import com.perfact.server.domain.jpa.CompanyRepository;
import com.perfact.server.domain.jpa.HomeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BookmarkService {
    private final HomeRepository homeRepository;
    private final CompanyRepository companyRepository;

    @Transactional
    public Long saveHome(HomeDto homeDto) {
        return homeRepository.save(homeDto.toEntity()).getId();
    }

    @Transactional
    public Long saveCompany(CompanyDto companyDto) {
        return companyRepository.save(companyDto.toEntity()).getId();
    }

    @Transactional(readOnly = true)
    public HomeDto getHome(Long userId) {
        Home home = homeRepository.findByUserId(userId);

        HomeDto homeDto = HomeDto.builder()
                .homeLong(home.getHomeLong())
                .homeLat(home.getHomeLat())
                .homeAddr(home.getHomeAddr())
                .build();

        return homeDto;
    }

    @Transactional(readOnly = true)
    public CompanyDto getCompany(Long userId) {
        Company company = companyRepository.findByUserId(userId);

        CompanyDto companyDto = CompanyDto.builder()
                .companyLong(company.getCompanyLong())
                .companyLat(company.getCompanyLat())
                .companyAddr(company.getCompanyAddr())
                .build();

        return companyDto;
    }

    @Transactional
    public void deleteHome(Long userId){
        Home home = homeRepository.findByUserId(userId);
        homeRepository.delete(home);
    }

    @Transactional
    public void deleteCompany(Long userId){
        Company company = companyRepository.findByUserId(userId);
        companyRepository.delete(company);
    }

    @Transactional
    public Long updateHome(Long id, HomeDto homeDto){
        Home home = homeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("등록된 집이 없습니다. id=" + id));
        home.update(homeDto.getHomeLat(), homeDto.getHomeLong(), homeDto.getHomeAddr());
        return id;
    }

    @Transactional
    public Long updateCompany(Long id, CompanyDto companyDto){
        Company company = companyRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("등록된 회사가 없습니다. id=" + id));
        company.update(companyDto.getCompanyLat(), companyDto.getCompanyLong(), companyDto.getCompanyAddr());
        return id;
    }


}
