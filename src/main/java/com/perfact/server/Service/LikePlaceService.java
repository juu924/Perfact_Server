package com.perfact.server.Service;

import com.perfact.server.domain.LikePlace;
import com.perfact.server.domain.dto.likedplace.CreateLikePlaceDto;
import com.perfact.server.domain.jpa.LikePlaceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LikePlaceService {
    private final LikePlaceRepository likePlaceRepository;


    //장소 스크랩
    @Transactional
    public Long savePlace(CreateLikePlaceDto createLikePlaceDto) {
        return likePlaceRepository.save(createLikePlaceDto.toEntity()).getId();
    }

    //스크랩 취소
    //place_id 만 받으면 되는건지? user_id 는 필요 없는지?
    @Transactional
    public void deletePlace(Long id) {
        LikePlace place = likePlaceRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 장소가 존재하지 않습니다."));

        likePlaceRepository.delete(place);
    }

    //스크랩 조회
    @Transactional(readOnly = true)
    public List<LikePlace> searchAllPlace(Long user_id) {
        return likePlaceRepository.findLikePlaceByUserId(user_id);
    }


}
