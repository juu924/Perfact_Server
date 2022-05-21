package com.perfact.server.Controller;

import com.perfact.server.Service.LikePlaceService;
import com.perfact.server.domain.LikePlace;
import com.perfact.server.domain.dto.likedplace.CreateLikePlaceDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class LikePlaceController {

    private final LikePlaceService likePlaceService;

    //장소 스크랩
    @PostMapping("/likeplace")
    public Long savePlace(@RequestBody CreateLikePlaceDto createLikePlaceDto) {
        return likePlaceService.savePlace(createLikePlaceDto);
    }

    //스크랩 취소
    @DeleteMapping("/likeplace/{id}")
    public void delete(@PathVariable Long id) {
        likePlaceService.deletePlace(id);
    }

    //스크랩 목록 조회
    @GetMapping("/likeplace/{id}")
    public List<LikePlace> searchLikePlace(@PathVariable Long user_id) {
        return likePlaceService.searchAllPlace(user_id);
    }


}
