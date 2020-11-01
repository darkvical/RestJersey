package com.vical.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.vical.domain.Persona;
import com.vical.domain.User;


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
	
	@POST
	@Path("/crearUser")
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	public void verificarService(List<User> users);
	
}