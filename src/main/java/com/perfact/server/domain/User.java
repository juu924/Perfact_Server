package com.perfact.server.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 40, nullable = false)
    private String email;

    @Column(length = 40, nullable = false)
    private String passwd;

    @Column(length = 20, nullable = false)
    private String nickname;

    @Column(length = 2, nullable = true)
    private String gender;


    @Builder
    public User(String email, String passwd, String nickname, String gender){
        this.email = email;
        this.passwd = passwd;
        this.nickname = nickname;
        this.gender = gender;
    }

}
