package com.imdb.exception;

import com.imdb.util.Consts;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @developer -- ilkercolakoglu
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = Consts.OUT_OF_KEVIN_BACON_NETWORK_EXCEPTION)
public class OutOfKevinBaconNetworkException extends Exception {
    static final long serialVersionUID = -3387516993224229948L;


    public OutOfKevinBaconNetworkException(String message)
    {
        super(message);
    }
}
