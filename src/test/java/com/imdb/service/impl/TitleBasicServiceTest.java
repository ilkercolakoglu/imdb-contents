package com.imdb.service.impl;

import com.imdb.MicroImdbApplication;
import com.imdb.dto.TitleBasicDTO;
import com.imdb.dto.TitleSearchDTO;
import com.imdb.exception.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static com.imdb.util.InMemoryCheckValues.IS_TITLE_MAP_READY;
import static org.junit.Assert.*;

/**
 * @developer -- ilkercolakoglu
 */
@RunWith(SpringRunner.class)
@SpringBootTest(
        classes = MicroImdbApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(
        locations = "classpath:application.yaml")
public class TitleBasicServiceTest {

    @Autowired
    TitleBasicService titleBasicService;

    @Test
    public void getByOriginalTitleAndPrimaryTitle() throws MissingSearchArgumentException, TitleNotFoundException {
        TitleSearchDTO titleSearchDTO=new TitleSearchDTO();
        titleSearchDTO.setOriginalTitle("Hamlet");
        List<TitleBasicDTO> titleBasicDTOList = titleBasicService.getByOriginalTitleAndPrimaryTitle(titleSearchDTO);
        assertNotNull(titleBasicDTOList);
    }

    @Test(expected = MissingSearchArgumentException.class)
    public void should_get_missing_search_argument_exception()
            throws MissingSearchArgumentException, TitleNotFoundException {
        TitleSearchDTO titleSearchDTO=new TitleSearchDTO();
        titleSearchDTO.setOriginalTitle(null);
        titleSearchDTO.setPrimaryTitle(null);
        titleBasicService.getByOriginalTitleAndPrimaryTitle(titleSearchDTO);
    }

    @Test(expected = TitleNotFoundException.class)
    public void should_get_title_not_found_exception()
            throws MissingSearchArgumentException, TitleNotFoundException {
        TitleSearchDTO titleSearchDTO=new TitleSearchDTO();
        titleSearchDTO.setPrimaryTitle("unknown film");
        titleBasicService.getByOriginalTitleAndPrimaryTitle(titleSearchDTO);
    }

    @Test
    public void getTopRatedMoviesByGenre() throws InvalidTopException, InvalidGenreException {
        String genre="Horror";
        List<TitleBasicDTO> titleBasicDTOList = titleBasicService.getTopRatedMoviesByGenre(genre,50);
        assertTrue(titleBasicDTOList.get(0).getTitleRating().getAveragerating()>=titleBasicDTOList.get(1).getTitleRating().getAveragerating());
    }

    @Test(expected = InvalidTopException.class)
    public void should_get_invalid_top_exception()
            throws InvalidTopException, InvalidGenreException {
        String genre="Horror";
        int top = -1;
        titleBasicService.getTopRatedMoviesByGenre(genre, top);
    }

    @Test(expected = InvalidGenreException.class)
    public void should_get_invalid_genre_exception()
            throws InvalidTopException, InvalidGenreException {
        String genre="unknown genre";
        int top = 50;
        titleBasicService.getTopRatedMoviesByGenre(genre, top);
    }
}
