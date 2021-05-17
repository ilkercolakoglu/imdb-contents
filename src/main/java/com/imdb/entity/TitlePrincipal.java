package com.imdb.entity;


import lombok.Data;

import javax.persistence.*;

/**
 * @developer -- ilkercolakoglu
 */
@Data
@Entity
@Table(name = "title_principals")
public class TitlePrincipal extends BaseEntity{

    @Id
    @ManyToOne
    @JoinColumn(name = "tconst", referencedColumnName = "tconst")
    private TitleBasic titleBasic;

    @Id
    @Column(name = "ordering")
    private Integer ordering;

    @Id
    @ManyToOne
    @JoinColumn(name = "nconst", referencedColumnName = "nconst")
    private NameBasic nameBasic;

    @Column(name = "category", length = 100)
    private Integer category;

    @Column(name = "job", length = 300)
    private Integer job;

    @Column(name = "characters", length = 500)
    private Integer characters;





}
