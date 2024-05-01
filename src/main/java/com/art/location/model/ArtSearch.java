package com.art.location.model;

import com.art.location.domain.Genre;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArtSearch {
    private String artName;
    private Genre genre;
}
