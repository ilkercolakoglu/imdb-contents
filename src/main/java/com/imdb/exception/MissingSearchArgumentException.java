package com.imdb.exception;

import com.imdb.util.Consts;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @developer -- ilkercolakoglu
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = Consts.MISSING_ARGUMENT_SEARCH_EXCEPTION_MESSAGE)
public class MissingSearchArgumentException extends Exception {
    static final long serialVersionUID = -3387516993224229948L;


    public MissingSearchArgumentException(String message)
    {
        super(message);
    }
}
