package com.vical.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.vical.domain.Persona;


@Path("/ejemplo")
public interface IPICServiceRest {
	
	@GET
	@Path("/obtenerPersona")
	@Produces({MediaType.APPLICATION_JSON})
	public Persona obtenerDatosPersona(
			@QueryParam("tipoDocumento") String tipoDocumento,
			@QueryParam("numeroDocumento") String numeroDocumento) throws RuntimeException;
	
	@GET
	@Path("/verificar")
	@Produces(MediaType.APPLICATION_JSON)
	public String verificarService(@QueryParam("argument") String argumento);
	
}