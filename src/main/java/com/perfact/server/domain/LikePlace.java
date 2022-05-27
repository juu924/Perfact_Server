package com.perfact.server.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class LikePlace {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   @Column(nullable = false)
    private Long userId;

   @Column(length = 20, nullable = false)
    private String name;

   @Column(length = 200)
    private String addr;

   @Column(length = 50)
    private String telephone;

   @Builder
    public LikePlace(Long userId, String name, String addr, String telephone){
       this.userId = userId;
       this.name = name;
       this.addr = addr;
       this.telephone = telephone;
   }



}
