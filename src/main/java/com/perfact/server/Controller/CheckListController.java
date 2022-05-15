package com.perfact.server.Controller;

import com.perfact.server.Service.CheckListService;
import com.perfact.server.domain.dto.checklist.ListCreateDto;
import com.perfact.server.domain.dto.checklist.ListSearchDto;
import com.perfact.server.domain.dto.checklist.ListUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController

public class CheckListController {

    private final CheckListService checkListService;

    //체크 리스트 작성
    @PostMapping("/checklist")
    public Long save(@RequestBody ListCreateDto listCreateDto){
        return checkListService.saveList(listCreateDto);
    }

    //체크 리스트 조회
    @GetMapping("/checklist/{userId}")
    public List<ListSearchDto>searchList(@PathVariable Long userId){
           return checkListService.searchAllList(userId);
    }

    //체크 리스트 삭제
    @DeleteMapping("/checklist/{id}")
    public void delete(@PathVariable Long id){
        checkListService.delete(id);
    }

    //체크 리스트 수정
    @PutMapping("/checklist/{id}")
    public Long update(@PathVariable Long id, @RequestBody ListUpdateDto listUpdateDto){
        return checkListService.update(id,listUpdateDto);
    }




}
