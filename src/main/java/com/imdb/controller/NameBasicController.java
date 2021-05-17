package com.imdb.controller;

import com.imdb.exception.OutOfKevinBaconNetworkException;
import com.imdb.exception.ServiceNotReadyException;
import com.imdb.exception.TitleNotFoundException;
import com.imdb.service.impl.NameBasicService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static com.imdb.util.Consts.*;

/**
 * @developer -- ilkercolakoglu
 */
@RestController
@RequestMapping("/names")
@Slf4j
public class NameBasicController {

    private final NameBasicService nameBasicService;

    public NameBasicController(NameBasicService nameBasicService) {
        this.nameBasicService = nameBasicService;
    }

    @ResponseStatus(HttpStatus.OK)
    @ApiResponses(value = {
            @ApiResponse(code = 412, message = SERVICE_NOT_READY_EXCEPTION),
            @ApiResponse(code = 404, message = TITLE_NOT_FOUND_AS_ACTOR_ACTRESS_EXCEPTION_MESSAGE),
            @ApiResponse(code = 404, message = OUT_OF_KEVIN_BACON_NETWORK_EXCEPTION)
    })
    @PostMapping("/get_degrees_of_kevin_bacon")
    public int getDegreesOfKevinBacon(@RequestParam String actor)
            throws ServiceNotReadyException, TitleNotFoundException, OutOfKevinBaconNetworkException {
        return nameBasicService.findDegreesOfKevinBacon(actor);
    }


}
