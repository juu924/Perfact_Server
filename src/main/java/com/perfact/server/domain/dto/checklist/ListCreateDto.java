package com.perfact.server.domain.dto.checklist;

import com.perfact.server.domain.checklist.CheckList;
import com.perfact.server.domain.checklist.Status;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class ListCreateDto {
    private Long id;
    private Long userId;
    private String content;
    private Status status;

    @Builder
    public ListCreateDto(Long userId, String content, Status status){
        this.userId = userId;
        this.content = content;
        this.status = status;
    }

    public CheckList toEntity(){
        return CheckList.builder()
                .userId(userId)
                .content(content)
                .status(status)
                .build();
    }





}
