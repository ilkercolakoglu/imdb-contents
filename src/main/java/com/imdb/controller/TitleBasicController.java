package com.imdb.controller;

import com.imdb.dto.TitleBasicDTO;
import com.imdb.dto.TitleSearchDTO;
import com.imdb.exception.InvalidGenreException;
import com.imdb.exception.InvalidTopException;
import com.imdb.exception.MissingSearchArgumentException;
import com.imdb.exception.TitleNotFoundException;
import com.imdb.service.impl.TitleBasicService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.imdb.util.Consts.*;

/**
 * @developer -- ilkercolakoglu
 */
@RestController
@RequestMapping("/title")
@Slf4j
public class TitleBasicController {

    private final TitleBasicService titleBasicService;

    public TitleBasicController(TitleBasicService titleBasicService) {
        this.titleBasicService = titleBasicService;
    }

    @ResponseStatus(HttpStatus.OK)
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = MISSING_ARGUMENT_SEARCH_EXCEPTION_MESSAGE),
            @ApiResponse(code = 404, message = TITLE_NOT_FOUND_EXCEPTION_MESSAGE)
    })
    @PostMapping("/search")
    public List<TitleBasicDTO> getByOriginalTitle(@RequestBody TitleSearchDTO titleSearchDTO)
            throws MissingSearchArgumentException, TitleNotFoundException {

        return titleBasicService.getByOriginalTitleAndPrimaryTitle(titleSearchDTO);
    }

    @ResponseStatus(HttpStatus.OK)
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = INVALID_GENRE_EXCEPTION_MESSAGE),
            @ApiResponse(code = 400, message = INVALID_TOP_EXCEPTION_MESSAGE)
    })
    @GetMapping("/top_rated_movies_by_genre/{genre}/{top}")
    public List<TitleBasicDTO> getTopRatedMoviesByGenre(@PathVariable String genre, @PathVariable int top)
            throws InvalidGenreException, InvalidTopException {
        return titleBasicService.getTopRatedMoviesByGenre(genre, top);
    }
}
