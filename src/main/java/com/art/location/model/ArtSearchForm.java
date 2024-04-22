package com.art.location.model;

import com.art.location.domain.Genre;
import lombok.Getter;

@Getter
public class ArtSearchForm {
    private String artName;
    private Genre genre;
}
