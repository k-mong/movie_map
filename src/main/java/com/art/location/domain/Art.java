package com.art.location.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Art {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "art_id")
    private Long id;

    private String name;    // 작품명
    private String year;    // 년도

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "genre_id")
    private Genre genre;

    @OneToMany(mappedBy = "art", cascade = CascadeType.ALL)
    private List<Participates> participates = new ArrayList<>();

    @OneToMany(mappedBy = "art", cascade = CascadeType.ALL)
    private List<Filmed> filmedList = new ArrayList<>();
}
