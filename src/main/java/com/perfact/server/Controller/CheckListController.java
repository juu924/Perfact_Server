package com.perfact.server.Controller;

import com.perfact.server.Service.CheckListService;
import com.perfact.server.dto.Response;
import com.perfact.server.dto.checklist.ListCreateDto;
import com.perfact.server.dto.checklist.ListUpdateDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@Tag(name = "checkList", description = "체크리스트 API")
@RequiredArgsConstructor
@RestController

public class CheckListController {


    private final CheckListService checkListService;

    @Operation(summary = "create checklist", description = "체크리스트 작성하기")

    //체크 리스트 작성
    @PostMapping("/checklist")
    public Response save(@RequestBody ListCreateDto listCreateDto){
         Long list_id = checkListService.saveList(listCreateDto);
         return Response.builder()
                 .code("200")
                 .messages("체크리스트 저장이 완료되었습니다. id = "+list_id)
                 .build();
    }

    //체크 리스트 조회
    @GetMapping("/checklist/list/{userId}")
    public Response searchList(@PathVariable Long userId){
        return  Response.builder()
                .code("200")
                .messages("체크리스트의 조회가 왼료되었습니다.")
                .data(Collections.singletonList(checkListService.searchAllList(userId)))
                .build();
    }

    //특정 체크 리스트 조회
    @GetMapping("/checklist/{id}")
    public Response getList(@PathVariable Long id){
        return Response.builder()
                .code("200")
                .messages("체크리스트 항목 조회가 완료되었습니다.")
                .data(Collections.singletonList(checkListService.getList(id)))
                .build();
    }


    //체크 리스트 삭제
    @DeleteMapping("/checklist/{id}")
    public Response delete(@PathVariable Long id){
        checkListService.delete(id);
        return Response.builder()
                .code("201")
                .messages("체크리스트 삭제가 완료되었습니다.")
                .build();
    }

    //체크 리스트 수정
    @PutMapping("/checklist/{id}")
    public Response update(@PathVariable Long id, @RequestBody ListUpdateDto listUpdateDto){
        Long update_id = checkListService.update(id,listUpdateDto);
        return Response.builder()
                .code("201")
                .messages("체크리스트 수정이 완료되었습니다. id = "+ update_id)
                .data(Collections.singletonList(checkListService.getList(id)))
                .build();
    }

}
