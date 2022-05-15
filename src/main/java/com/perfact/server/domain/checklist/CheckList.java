package com.perfact.server.domain.checklist;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor

public class CheckList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    @Column(length = 50, nullable = false)
    private String content;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Builder
    public CheckList(Long userId,String content, Status status){
        this.userId = userId;
        this.content = content;
        this.status = status;
    }

    public void update(String content, Status status) {
        this.content = content;
        this.status = status;
    }


}
