package com.vical.exception;

import java.util.Locale;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class RestException implements ExceptionMapper<Throwable> {

	@Override
	public Response toResponse(Throwable ex) {
		ErrorResponse errorMensaje = new ErrorResponse();
		this.setHttpStatus(ex, errorMensaje);
		errorMensaje.setStatusDescription("Error interno de la aplicación");
		errorMensaje.setErrorMessage("Ocurrió algo inesperado");
		errorMensaje.setSeverity("MEDIA");
		return Response.status(errorMensaje.getStatusCode())
                .entity(errorMensaje).language(new Locale("es", "PE")).type(MediaType.APPLICATION_JSON).build();
	}
	
	private void setHttpStatus(Throwable ex, ErrorResponse errorResponse) {
		if(ex instanceof WebApplicationException) {
			errorResponse.setStatusCode(((WebApplicationException) ex).getResponse().getStatus());
		} else {
			errorResponse.setStatusCode(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
		}
	}

}
