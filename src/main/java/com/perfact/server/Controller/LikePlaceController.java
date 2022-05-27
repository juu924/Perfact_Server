package com.perfact.server.Controller;

import com.perfact.server.Service.LikePlaceService;
import com.perfact.server.domain.LikePlace;
import com.perfact.server.dto.Response;
import com.perfact.server.dto.likedplace.CreateLikePlaceDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class LikePlaceController {

    private final LikePlaceService likePlaceService;

    //장소 스크랩
    @PostMapping("/likeplace")
    public Response savePlace(@RequestBody CreateLikePlaceDto createLikePlaceDto) {
        Long placeId = likePlaceService.savePlace(createLikePlaceDto);
        return Response.builder()
                .code("200")
                .messages("장소가 스크랩 되었습니다. id = " + placeId)
                .build();
    }

    //스크랩 취소
    @DeleteMapping("/likeplace/{id}")
    public Response delete(@PathVariable Long id) {
        likePlaceService.deletePlace(id);
        return Response.builder()
                .code("200")
                .messages("장소 스크랩이 취소 되었습니다.")
                .build();
    }

    /*
    //스크랩 목록 조회
    @GetMapping("/likeplace/{id}")
    public Response searchLikePlace(@PathVariable Long user_id) {
        return likePlaceService.searchAllPlace(user_id);
    }
     */


}
