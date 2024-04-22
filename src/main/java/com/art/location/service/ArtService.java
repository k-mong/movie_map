package com.art.location.service;


import com.art.location.domain.Art;
import com.art.location.repository.ArtRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ArtService {


    private final ArtRepository artRepository;

    public List<Art> findAllarts() {
        return artRepository.findAll();
    }

    public List<Art> findArts(String artSearch) {
        return artRepository.findByName(artSearch);
    }

    
}
