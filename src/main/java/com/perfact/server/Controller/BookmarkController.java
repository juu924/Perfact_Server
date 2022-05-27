package com.perfact.server.Controller;

import com.perfact.server.Service.BookmarkService;
import com.perfact.server.dto.Response;
import com.perfact.server.dto.bookmark.CompanyDto;
import com.perfact.server.dto.bookmark.HomeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
@RequiredArgsConstructor
public class BookmarkController {
    private final BookmarkService bookmarkService;

    //등록된 집 조회
    @GetMapping("/bookmark/home/{id}")
    public Response searchHome(@PathVariable Long userId){
        return Response.builder()
                .code("200")
                .messages("집 정보 조회가 완료되었습니다.")
                .data(Collections.singletonList( bookmarkService.getHome(userId)))
                .build();
    }

    //등록된 회사 조회
    @GetMapping("/bookmark/company/{id}")
    public Response searchCompany(@PathVariable Long userId){
        return Response.builder()
                .code("200")
                .messages("회사 정보 조회가 완료되었습니다.")
                .data(Collections.singletonList( bookmarkService.getCompany(userId)))
                .build();
    }

    //집 등록
    @PostMapping("/bookmark/home")
    public Response saveHome(@RequestBody HomeDto homeDto){
         Long homeId = bookmarkService.saveHome(homeDto);
        return Response.builder()
                .code("201")
                .messages("집 등록이 완료되었습니다. id = " + homeId)
                .build();
    }

    //회사 등록
    @PostMapping("/bookmark/company")
    public Response saveCompany(@RequestBody CompanyDto companyDto){
        Long companyId = bookmarkService.saveCompany(companyDto);
        return Response.builder()
                .code("201")
                .messages("회사 등록이 완료되었습니다. id = "+ companyId)
                .build();
    }

    //집 정보 수정
    @PutMapping("/bookmark/home/{id}")
    public Response updateHome(@PathVariable Long id, @RequestBody HomeDto homeDto){
        bookmarkService.updateHome(id,homeDto);
        return Response.builder()
                .code("201")
                .messages("집 정보 수정이 완료되었습니다.")
                .data(Collections.singletonList(bookmarkService.getHome(id)))
                .build();
    }

    //회사 정보 수정
    @PutMapping("/bookmark/company/{id}")
    public Response updateCompany(@PathVariable Long id, @RequestBody CompanyDto companyDto){
        bookmarkService.updateCompany(id,companyDto);
        return Response.builder()
                .code("201")
                .messages("회사 정보 수정이 완료되었습니다.")
                .data(Collections.singletonList(bookmarkService.getCompany(id)))
                .build();
    }

    //등록된 집 정보 삭제
    @DeleteMapping("/bookmark/home/{id}")
    public Response deleteHome(@PathVariable Long id){
        bookmarkService.deleteHome(id);
        return Response.builder()
                .code("200")
                .messages("등록된 집을 삭제하였습니다.")
                .build();
    }

    //등록된 회사 정보 삭제
    @DeleteMapping("/bookmark/company/{id}")
    public Response deleteCompany(@PathVariable Long id){
        bookmarkService.deleteCompany(id);
        return Response.builder()
                .code("200")
                .messages("등록된 회사를 삭제하였습니다.")
                .build();
    }

}
