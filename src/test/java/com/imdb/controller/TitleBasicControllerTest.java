package com.imdb.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.imdb.dto.TitleSearchDTO;
import com.imdb.service.impl.TitleBasicService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @developer -- ilkercolakoglu
 */

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class TitleBasicControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private TitleBasicService titleBasicService;

    private ObjectMapper objectMapper;

    @Before
    public void setUp() throws Exception {
        this.objectMapper = new ObjectMapper();
    }

    @Test
    public void should_get_by_original_title() throws Exception {
        TitleSearchDTO request = new TitleSearchDTO();
        request.setOriginalTitle("Hamlet");

        String requestBody = this.objectMapper.writeValueAsString(request);

        this.mockMvc.perform(post("/title/search")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody))
                .andExpect(status().isOk());
    }

    @Test
    public void should_get_title_not_found_exception() throws Exception {

        TitleSearchDTO request = new TitleSearchDTO();
        request.setOriginalTitle("Not Found Title");

        String requestBody = this.objectMapper.writeValueAsString(request);

        this.mockMvc.perform(post("/title/search")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody))
                .andExpect(status().isNotFound());

    }

    @Test
    public void should_get_missing_search_argument_exception() throws Exception {

        TitleSearchDTO request = new TitleSearchDTO();

        String requestBody = this.objectMapper.writeValueAsString(request);

        this.mockMvc.perform(post("/title/search")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody))
                .andExpect(status().isBadRequest());

    }

    @Test
    public void should_get_top_rated_movies_by_genre() throws Exception {

        this.mockMvc.perform(get("/title/top_rated_movies_by_genre/Horror/50")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void should_get_invalid_genre_exception() throws Exception {
        this.mockMvc.perform(get("/title/top_rated_movies_by_genre/Unknowngenre/50")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void should_get_invalid_top_exception() throws Exception {
        this.mockMvc.perform(get("/title/top_rated_movies_by_genre/Horror/1500")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }


}
