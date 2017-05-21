package com.betterjavacode.benefits.utilities;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.Provider;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.glassfish.jersey.spi.ExtendedExceptionMapper;

@Provider
public class UncaughtExceptionMapper implements ExtendedExceptionMapper<Throwable> {

    private static final Logger LOGGER = LogManager.getLogger(UncaughtExceptionMapper.class);

    @Override
    public Response toResponse(Throwable exception) {
        LOGGER.info("Enter >> toResponse ");
        LOGGER.debug("Exception Caught: " + exception.getMessage());
        LOGGER.info("Exit << toResponse");
        return Response.status(Status.BAD_REQUEST)
            .entity(exception.getMessage())
            .build();
    }

    @Override
    public boolean isMappable(Throwable arg0) {
        return !(arg0 instanceof WebApplicationException);
    }

}
