package com.art.location.repository;

import com.art.location.domain.Art;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ArtRepository extends JpaRepository<Art, Long> {

    Optional<Art> findById(Long id);

    // 장르 겁색
    List<Art> findByGenreGenreName(String genreName);

    // 장품명 검색
    List<Art> findByName(String atrName);
}
