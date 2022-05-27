package com.perfact.server.dto.checklist;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ListUpdateDto {
    private String content;
    private String status;

    @Builder
    public ListUpdateDto(String content, String status){
        this.content = content;
        this.status = status;
    }
}
