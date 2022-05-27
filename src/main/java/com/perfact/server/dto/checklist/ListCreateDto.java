package com.perfact.server.dto.checklist;

import com.perfact.server.domain.CheckList;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class ListCreateDto {
    private Long userId;
    private String content;
    private String status;

    @Builder
    public ListCreateDto(Long userId, String content, String status){
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
