package com.art.location.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Loc_id")
    private Long id;

    private String locName;

    private String CTPRVN_NM;
    private String SIGNGU_NM;
    private String Specific_Addr_NM;

    private LocalDateTime localDateTime;

    @OneToMany(mappedBy = "location", cascade = CascadeType.ALL)
    private List<Film> filmList = new ArrayList<>();

    public static Location createLoc(String name, String CTPRVN_NM, String SIGNGU_NM, String Specific_Addr_NM) {
        Location location = new Location();
        location.setLocName(name);
        location.setCTPRVN_NM(CTPRVN_NM);
        location.setSIGNGU_NM(SIGNGU_NM);
        location.setSpecific_Addr_NM(Specific_Addr_NM);
        location.setLocalDateTime(LocalDateTime.now());
        return location;
    }
}
