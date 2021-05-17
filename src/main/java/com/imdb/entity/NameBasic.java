package com.imdb.entity;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @developer -- ilkercolakoglu
 */
@Data
@Entity
@Table(name = "name_basics")
public class NameBasic extends BaseEntity{

    @Id
    @Column(name = "nconst", length = 10)
    private String id;

    @Column(name = "primaryname", length = 110)
    private String primaryName;

    @Column(name = "birthyear")
    private Integer birthYear;

    @Column(name = "deathyear")
    private Integer deathYear;

    @Column(name = "primaryprofession", length = 200)
    private String primaryProfession;

    @Column(name = "knownfortitles",length = 100)
    private String knownForTitles;



}
