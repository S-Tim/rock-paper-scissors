package com.codingkata.rps.web.advice;

/**
 * Error Response for controller advices
 *
 * @author Tim Silhan
 */
public class ErrorResponse {
    public int status;
    public String url;
    public String exception;

    // Needed for serialization
    private ErrorResponse() {
    }

    public ErrorResponse(int status, String url, String exception) {
        this.status = status;
        this.url = url;
        this.exception = exception;
    }
}
