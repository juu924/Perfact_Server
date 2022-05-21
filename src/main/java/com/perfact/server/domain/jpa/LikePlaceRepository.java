package com.perfact.server.domain.jpa;

import com.perfact.server.domain.LikePlace;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LikePlaceRepository extends JpaRepository<LikePlace, Long> {
   List<LikePlace> findLikePlaceByUserId(Long userId);

}
