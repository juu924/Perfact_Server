package com.perfact.server.dto.checklist;

import com.perfact.server.domain.CheckList;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ListSearchDto {
    private Long id;
    private String content;
    private String status;

    @Builder
    public ListSearchDto(CheckList entity){
        id = entity.getId();
        content = entity.getContent();
        status = entity.getStatus();
    }


}
