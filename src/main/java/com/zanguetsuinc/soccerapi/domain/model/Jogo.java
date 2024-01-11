package com.zanguetsuinc.soccerapi.domain.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Jogo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    private OffsetDateTime data;
    private Integer score_team_One;
    private Integer score_team_two;
    @ManyToOne
    private Team team_One;
    @ManyToOne
    private Team team_Two;
    @ManyToOne
    private Team supported_team;
}
