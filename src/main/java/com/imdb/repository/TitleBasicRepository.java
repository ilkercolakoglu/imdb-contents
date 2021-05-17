package com.imdb.repository;

import com.imdb.entity.TitleBasic;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

/**
 * @developer -- ilkercolakoglu
 */
public interface TitleBasicRepository extends PagingAndSortingRepository<TitleBasic, String> {

    @Query("select tb from TitleBasic tb where 1=1 and (:originalTitle is null or tb.originalTitle LIKE %:originalTitle%)" +
            " and (:primaryTitle is null or tb.primaryTitle LIKE %:primaryTitle%)")
    List<TitleBasic> getByOriginalTitleAndPrimaryTitle(String originalTitle, String primaryTitle);

    Page<TitleBasic> findByTitleRating_AverageratingNotNullAndGenresIsLikeOrderByTitleRating_AverageratingDesc(String genres, Pageable pageable);
}
