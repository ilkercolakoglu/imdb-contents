package com.imdb.controller;

import com.imdb.util.InMemoryCheckValues;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @developer -- ilkercolakoglu
 */

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class NameBasicControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        Thread.sleep(10000);
    }

    @Test
    public void should_get_degrees_of_kevin_bacon() throws Exception {
        InMemoryCheckValues.IS_TITLE_MAP_READY = true;
        this.mockMvc.perform(post("/names/get_degrees_of_kevin_bacon").param("actor","Rishaab Chauhaan"))
                .andExpect(status().isOk());
    }

    @Test
    public void should_get_service_not_ready_exception() throws Exception {
        InMemoryCheckValues.IS_TITLE_MAP_READY = false;
        this.mockMvc.perform(post("/names/get_degrees_of_kevin_bacon").param("actor","Rishaab Chauhaan"))
                .andExpect(status().isPreconditionFailed());
    }

    @Test
    public void should_get_title_not_found_as_actor_actress_exception() throws Exception {
        InMemoryCheckValues.IS_TITLE_MAP_READY = true;
        this.mockMvc.perform(post("/names/get_degrees_of_kevin_bacon").param("actor","Frank Martinez"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void should_get_out_of_kevin_bacon_network_exception() throws Exception {
        InMemoryCheckValues.IS_TITLE_MAP_READY = true;
        this.mockMvc.perform(post("/names/get_degrees_of_kevin_bacon").param("actor","Suresh Kamal"))
                .andExpect(status().isNotFound());
    }



}
