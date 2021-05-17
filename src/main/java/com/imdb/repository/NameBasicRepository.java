package com.imdb.repository;

import com.imdb.entity.NameBasic;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;

import static com.imdb.util.Consts.ACTOR;
import static com.imdb.util.Consts.ACTRESS;

/**
 * @developer -- ilkercolakoglu
 */
public interface NameBasicRepository extends PagingAndSortingRepository<NameBasic, String> {

    @Query("select nb from NameBasic nb where nb.primaryName=:primaryName" +
            " and (nb.primaryProfession like '%"+ACTRESS+"%' or nb.primaryProfession like '%"+ACTOR+"%')")
    List<NameBasic> findByPrimaryNameAsActorOrActress(String primaryName);


    @Query("select nb from NameBasic nb where nb.knownForTitles is not null" +
            " and (nb.primaryProfession like '%"+ACTRESS+"%' or nb.primaryProfession like '%"+ACTOR+"%')")
    List<NameBasic> findByKnownForTitlesIsNotNullAsActorsAndActress();

}
