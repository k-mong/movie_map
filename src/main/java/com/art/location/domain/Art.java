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
public class Art {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Art_id")
    private Long id;

    private String artName;

    private int year;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Gen_id")
    private Genre genre;

    @OneToMany(mappedBy = "art", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Participates> participatesList = new ArrayList<>();

    @OneToMany(mappedBy = "art", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Film> filmList = new ArrayList<>();

    public void addFilm(Film film) {
        filmList.add(film);
        film.setArt(this);
    }

    public void addParticipaties(Participates participates) {
        participatesList.add(participates);
        participates.setArt(this);
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
        genre.getArt().add(this);
    }
    public static Art createArt(String artName, int year, List<Film> filmList, List<Actor> actors, Genre genre) {
        Art art = new Art();
        art.setArtName(artName);
        art.setYear(year);
        art.setGenre(genre);

        for (Film film : filmList) {
            art.addFilm(film);
        }

        for (Actor actor : actors) {
            Participates participates = Participates.createParticpate(actor);
            art.addParticipaties(participates);
        }

        return art;
    }
}
