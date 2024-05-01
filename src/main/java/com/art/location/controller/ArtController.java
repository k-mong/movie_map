package com.art.location.controller;

import com.art.location.domain.Art;
import com.art.location.model.ArtSearch;
import com.art.location.service.ArtService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
public class ArtController {

    private final ArtService artService;

    // 장르 작품명 페이징(4개씩)
    @RequestMapping("/")
    public String home(@ModelAttribute("artSearch")ArtSearch artSearch,
                       @RequestParam(value = "genreStatus", required = false) String genreStatus,
                       @RequestParam(value = "page", defaultValue = "0") int page,
                       Model model) {
        artService.setArtSearchGenre(artSearch, genreStatus);

        List<Art> allArts = artService.findArts(artSearch);
        model.addAttribute("allArts", allArts);

        Page<Art> paging = artService.findArtsPage(artSearch, PageRequest.of(page, 4));
        model.addAttribute("paging", paging);

        return "/main";
    }
}
