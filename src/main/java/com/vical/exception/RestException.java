package com.vical.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class RestException implements ExceptionMapper<Throwable> {

	@Override
	public Response toResponse(Throwable ex) {
		int type = getStatusType(ex);

		ErrorResponse error = new ErrorResponse(
                0, null, ex.getLocalizedMessage());

        return Response.status(error.getStatusCode())
                .entity(error)
                .type(MediaType.APPLICATION_JSON)
                .build();
	}
	
	 private int getStatusType(Throwable ex) {
	        if (ex instanceof WebApplicationException) {
	        	return ((WebApplicationException) ex).getResponse().getStatus();
	        } else {
	            return Response.Status.INTERNAL_SERVER_ERROR.getStatusCode();
	        }
	    }

}
