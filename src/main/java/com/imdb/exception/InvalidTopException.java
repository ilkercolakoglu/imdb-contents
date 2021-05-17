package com.imdb.exception;

import com.imdb.util.Consts;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @developer -- ilkercolakoglu
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = Consts.INVALID_TOP_EXCEPTION_MESSAGE)
public class InvalidTopException extends Exception {
    static final long serialVersionUID = -3387516993224229948L;


    public InvalidTopException(String message)
    {
        super(message);
    }
}
