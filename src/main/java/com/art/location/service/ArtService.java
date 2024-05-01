package com.art.location.service;

import com.art.location.domain.Art;
import com.art.location.model.ArtSearch;
import com.art.location.repository.ArtRepository;
import com.art.location.repository.GenreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArtService {

    private final ArtRepository artRepository;
    private final GenreRepository genreRepository;

    public List<Art> rindAllArts() {
        return artRepository.findAllArts();
    }

    // 모든 작품 찾기
    public List<Art> findArts(ArtSearch artSearch) {
        return artRepository.findAll(artSearch);
    }

    // 작품검색 및 페이징
    public Page<Art> findArtsPage(ArtSearch artSearch, Pageable pageable) {
        return artRepository.findArtPage(artSearch, pageable);
    }

    // URL 장르 검색 기능
    public void setArtSearchGenre(ArtSearch artSearch, String genreStatus) {
        genreRepository.setArtSearchGenre(artSearch, genreStatus);
    }

}
