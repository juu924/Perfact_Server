package com.perfact.server.domain.dto.checklist;

import com.perfact.server.domain.checklist.Status;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ListUpdateDto {
    private String content;
    private Status status;

    @Builder
    public ListUpdateDto(String content, Status status){
        this.content = content;
        this.status = status;
    }
}
