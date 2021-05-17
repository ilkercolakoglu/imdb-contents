package com.imdb.entity;


import lombok.Data;

import javax.persistence.*;

/**
 * @developer -- ilkercolakoglu
 */
@Data
@Entity
@Table(name = "title_basics")
public class TitleBasic extends BaseEntity {

    @Id
    @Column(name = "tconst", length = 10)
    private String id;

    @Column(name = "titletype", length = 20)
    private String titleType;

    @Column(name = "primarytitle", length = 500)
    private String primaryTitle;

    @Column(name = "originaltitle", length = 500)
    private String originalTitle;

    @Column(name = "isadult")
    private Boolean isAdult;

    @Column(name = "startyear")
    private Integer startYear;

    @Column(name = "endyear")
    private Integer endYear;

    @Column(name = "runtimeminutes")
    private Integer runTimeMinutes;

    @Column(name = "genres", length = 200)
    private String genres;

    @OneToOne
    @JoinColumn(name = "tconst")
    private TitleCrew titleCrew;

    @OneToOne
    @JoinColumn(name = "tconst")
    private TitleRating titleRating;


}
