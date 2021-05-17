package com.imdb.entity;


import lombok.Data;

import javax.persistence.*;

/**
 * @developer -- ilkercolakoglu
 */
@Data
@Entity
@Table(name = "title_ratings")
public class TitleRating extends BaseEntity {

    @Id
    @OneToOne
    @JoinColumn(name = "tconst", referencedColumnName = "tconst")
    private TitleBasic titleBasic;

    @Column(name = "averagerating")
    private Double averagerating;

    @Column(name = "numvotes")
    private Integer numVotes;



}
