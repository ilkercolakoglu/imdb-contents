package com.imdb.entity;


import lombok.Data;

import javax.persistence.*;

/**
 * @developer -- ilkercolakoglu
 */
@Data
@Entity
@Table(name = "title_crew")
public class TitleCrew extends BaseEntity {

    @Id
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tconst", referencedColumnName = "tconst")
    private TitleBasic titleBasic;

    @Column(name = "directors", length = 500)
    private String directors;

    @Column(name = "writers", length = 500)
    private String writers;



}
