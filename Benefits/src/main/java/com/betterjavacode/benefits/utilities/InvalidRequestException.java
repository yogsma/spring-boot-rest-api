package com.betterjavacode.benefits.utilities;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

public class InvalidRequestException extends WebApplicationException {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private int errorcode = 00; // 00 indicates - no error

    public InvalidRequestException() {

    }

    public InvalidRequestException(int errorcode, String message) {
        super(Response.status(Response.Status.BAD_REQUEST)
            .entity(message)
            .build());
        this.errorcode = errorcode;
    }

    public InvalidRequestException(int errorcode, String message, Throwable cause) {
        super(cause, Response.status(Response.Status.BAD_REQUEST)
            .entity(message)
            .build());
        this.errorcode = errorcode;
    }
}
