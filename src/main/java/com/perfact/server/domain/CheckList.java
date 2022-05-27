package com.perfact.server.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor

public class CheckList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long userId;

    @Column(length = 50, nullable = false)
    private String content;

    private String status;

    @Builder
    public CheckList(Long userId,String content, String status){
        this.userId = userId;
        this.content = content;
        this.status = status;
    }

    public void update(String content, String status) {
        this.content = content;
        this.status = status;
    }


}
