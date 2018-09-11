package com.codingkata.rps.web.advice;

/**
 * Error Response for controller advices
 *
 * @author Tim Silhan
 */
public class ErrorResponse {
    public final int status;
    public final String url;
    public final String exception;

    public ErrorResponse(int status, String url, String exception) {
        this.status = status;
        this.url = url;
        this.exception = exception;
    }
}
