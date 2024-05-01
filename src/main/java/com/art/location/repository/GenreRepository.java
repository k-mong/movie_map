package com.art.location.repository;

import com.art.location.domain.Genre;
import com.art.location.model.ArtSearch;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class GenreRepository {

    private final EntityManager em;

    public List<Genre> findAll() {
        return em.createQuery("select g from Genre g", Genre.class).getResultList();
    }

    // URL 장르검색
    public void setArtSearchGenre(ArtSearch artSearch, String genreStatus) {
        if (genreStatus != null && !genreStatus.isEmpty()) {
            Genre genre = em.createQuery("select g from Genre g where g.genreName = :genreName", Genre.class)
                    .setParameter("genreName", genreStatus)
                    .getSingleResult();
            artSearch.setGenre(genre);
        }
    }
}
