package com.art.location.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Participates {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Partic_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Actor_id")
    private Actor actor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Art_id")
    private Art art;

    public static Participates createParticpate(Actor actor) {
        Participates participates =  new Participates();
        participates.setActor(actor);
        return participates;
    }
}
