package com.art.location.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Gen_id")
    private Long id;

    private String genreName;

    @OneToMany(mappedBy = "genre", fetch = FetchType.LAZY)
    private List<Art> art = new ArrayList<>();

    public static Genre createGenre(String genreName) {
        Genre genre = new Genre();
        genre.setGenreName(genreName);
        return genre;
    }
}
