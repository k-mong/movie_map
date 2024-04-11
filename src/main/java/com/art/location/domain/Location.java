package com.art.location.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "location_id")
    private Long id;

    private String loc_name;
    private String CTPRVN_NM;
    private String SIGNGU_NM;
    private String specific_addr_NM;

    private LocalDateTime Last_modified_date;

    @OneToMany(mappedBy = "location", cascade = CascadeType.ALL)
    private List<Filmed> filmedList = new ArrayList<>();

}
