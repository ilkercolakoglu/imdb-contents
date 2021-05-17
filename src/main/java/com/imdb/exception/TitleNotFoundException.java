package com.imdb.exception;

import com.imdb.util.Consts;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @developer -- ilkercolakoglu
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = Consts.TITLE_NOT_FOUND_EXCEPTION_MESSAGE)
public class TitleNotFoundException extends Exception {
    static final long serialVersionUID = -3387516993224229948L;


    public TitleNotFoundException(String message)
    {
        super(message);
    }
}
