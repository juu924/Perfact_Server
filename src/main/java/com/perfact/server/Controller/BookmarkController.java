package com.perfact.server.Controller;

import com.perfact.server.Service.BookmarkService;
import com.perfact.server.domain.dto.bookmark.CompanyDto;
import com.perfact.server.domain.dto.bookmark.HomeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class BookmarkController {
    private final BookmarkService bookmarkService;

    //등록된 집 조회
    @GetMapping("/bookmark/home/{id}")
    public HomeDto searchHome(@PathVariable Long id){
        return bookmarkService.getHome(id);
    }

    //등록된 회사 조회
    @GetMapping("/bookmark/company/{id}")
    public CompanyDto searchCompany(@PathVariable Long id){
        return bookmarkService.getCompany(id);
    }

    //집 등록
    @PostMapping("/bookmark/home")
    public Long saveHome(@RequestBody HomeDto homeDto){
        return bookmarkService.saveHome(homeDto);
    }

    //회사 등록
    @PostMapping("/bookmark/company")
    public Long saveCompany(@RequestBody CompanyDto companyDto){
        return bookmarkService.saveCompany(companyDto);
    }

    //집 정보 수정
    @PutMapping("/bookmark/home/{id}")
    public String updateHome(@PathVariable Long id, @RequestBody HomeDto homeDto){
        bookmarkService.updateHome(id,homeDto);
        return "redirect:/";
    }

    //회사 정보 수정
    @PutMapping("/bookmark/company/{id}")
    public String updateCompany(@PathVariable Long id, @RequestBody CompanyDto companyDto){
        bookmarkService.updateCompany(id,companyDto);
        return "redirect:/";
    }

    //등록된 집 정보 삭제
    @DeleteMapping("/bookmark/home/{id}")
    public void deleteHome(@PathVariable Long id){
        bookmarkService.deleteHome(id);
    }

    //등록된 회사 정보 삭제
    @DeleteMapping("/bookmark/company/{id}")
    public void deleteCompany(@PathVariable Long id){
        bookmarkService.deleteCompany(id);
    }

}
