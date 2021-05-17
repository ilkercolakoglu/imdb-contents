package com.imdb.exception;

import com.imdb.util.Consts;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @developer -- ilkercolakoglu
 */
@ResponseStatus(value = HttpStatus.PRECONDITION_FAILED, reason = Consts.SERVICE_NOT_READY_EXCEPTION)
public class ServiceNotReadyException extends Exception {
    static final long serialVersionUID = -3387516993224229948L;


    public ServiceNotReadyException(String message)
    {
        super(message);
    }
}
