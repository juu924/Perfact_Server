package com.perfact.server.dto.likedplace;


import com.perfact.server.domain.LikePlace;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class CreateLikePlaceDto {
    private Long userId;
    private String name;
    private String addr;
    private String telephone;

    @Builder
    public CreateLikePlaceDto(Long userId, String name, String addr, String telephone){
        this.userId = userId;
        this.name = name;
        this.addr = addr;
        this.telephone = telephone;
    }

    public LikePlace toEntity(){
        return LikePlace.builder()
                .userId(userId)
                .name(name)
                .addr(addr)
                .telephone(telephone)
                .build();
    }


}
