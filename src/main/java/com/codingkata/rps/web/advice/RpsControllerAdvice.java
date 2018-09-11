package com.codingkata.rps.web.advice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

/**
 * Handles exception in the RpsController
 *
 * @author Tim Silhan
 */
@ControllerAdvice
public class RpsControllerAdvice {
    private Logger log = LoggerFactory.getLogger(RpsControllerAdvice.class);

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorResponse handleIllegalArgumentException(final IllegalArgumentException ex,
                                                        final HttpServletRequest request) {
        log.warn("IllegalArgumentException thrown with message: " + ex.getMessage());

        return new ErrorResponse(HttpStatus.BAD_REQUEST.value(),
                request.getRequestURL().toString(), ex.toString());
    }
}
