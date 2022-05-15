package com.perfact.server.domain.dto.checklist;

import com.perfact.server.domain.checklist.CheckList;
import com.perfact.server.domain.checklist.Status;
import lombok.Getter;

@Getter
public class ListSearchDto {
    private Long id;
    private Long userId;
    private String content;
    private Status status;

    public ListSearchDto(CheckList entity){
        id = entity.getId();
        userId = entity.getUserId();
        content = entity.getContent();
        status = entity.getStatus();
    }


}
