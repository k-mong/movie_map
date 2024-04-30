package com.art.location.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "film_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Art_id")
    private Art art;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Loc_id")
    private Location location;

    public static Film createFilm(Location location) {
        Film film = new Film();
        film.setLocation(location);
        return film;
    }
}
