package com.imdb.service.impl;

import com.imdb.dto.TitleBasicDTO;
import com.imdb.dto.TitleSearchDTO;
import com.imdb.entity.TitleBasic;
import com.imdb.exception.InvalidGenreException;
import com.imdb.exception.InvalidTopException;
import com.imdb.exception.MissingSearchArgumentException;
import com.imdb.exception.TitleNotFoundException;
import com.imdb.mapper.TitleBasicMapper;
import com.imdb.repository.TitleBasicRepository;
import com.imdb.util.ImdbAPIProviderUtil;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.imdb.util.Consts.*;

/**
 * @developer -- ilkercolakoglu
 */
@Service
public class TitleBasicService {

    private final TitleBasicRepository titleBasicRepository;

    private final TitleBasicMapper titleBasicMapper;

    public TitleBasicService(TitleBasicRepository TitleBasicRepository, TitleBasicMapper titleBasicMapper) {
        this.titleBasicRepository = TitleBasicRepository;
        this.titleBasicMapper = titleBasicMapper;
    }

    /**
     * returns titles by originalTitle and/or primaryTitle
     *
     * @param titleSearchDTO
     * @return
     * @throws MissingSearchArgumentException
     */
    @Cacheable(TITLE_SEARCH)
    public List<TitleBasicDTO> getByOriginalTitleAndPrimaryTitle(TitleSearchDTO titleSearchDTO)
            throws MissingSearchArgumentException, TitleNotFoundException {

        if ((titleSearchDTO.getOriginalTitle() == null || titleSearchDTO.getOriginalTitle().length()==0) &&
                (titleSearchDTO.getPrimaryTitle() == null || titleSearchDTO.getPrimaryTitle().length() == 0)) {
            throw new MissingSearchArgumentException(MISSING_ARGUMENT_SEARCH_EXCEPTION_MESSAGE);
        }

        List<TitleBasic> titleBasicList = titleBasicRepository
                .getByOriginalTitleAndPrimaryTitle(titleSearchDTO.getOriginalTitle(), titleSearchDTO.getPrimaryTitle());

        if (titleBasicList.size() == 0) throw new TitleNotFoundException(TITLE_NOT_FOUND_EXCEPTION_MESSAGE);

        return titleBasicMapper.toDTOList(titleBasicList);
    }


    /**
     * returns top titles by genre and restricted 1 to 1000 size.
     *
     * @param genre
     * @param top
     * @return
     * @throws InvalidGenreException
     * @throws InvalidTopException
     */
    @Cacheable(TOP_GENRES)
    public List<TitleBasicDTO> getTopRatedMoviesByGenre(String genre, int top) throws InvalidGenreException, InvalidTopException {

        if (top < 1 || top > 1000) {
            throw new InvalidTopException(INVALID_TOP_EXCEPTION_MESSAGE);
        }

        Pageable topPage = PageRequest.of(1, top);
        genre = ImdbAPIProviderUtil.createLikeQueryForField(genre);
        Page<TitleBasic> topTitlesByGenrePage =
                titleBasicRepository.findByTitleRating_AverageratingNotNullAndGenresIsLikeOrderByTitleRating_AverageratingDesc(genre, topPage);

        if (topTitlesByGenrePage.getTotalElements() == 0) {
            throw new InvalidGenreException(INVALID_GENRE_EXCEPTION_MESSAGE);
        }

        return titleBasicMapper.toDTOList(topTitlesByGenrePage.getContent());
    }
}
