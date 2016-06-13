package com.vical.rest.impl;

import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vical.domain.Persona;
import com.vical.rest.IPICServiceRest;
import com.vical.service.IPersonaService;

@Component
public class PICServiceRestImpl implements IPICServiceRest {
	
	@Autowired
	private IPersonaService personaService;

	@Override
	public Persona obtenerDatosPersona(String tipoDocumento, String numeroDocumento) throws RuntimeException {
		return personaService.obtenerDatosPersona(tipoDocumento);
	}
	
	@Override
	public Response verifyRESTService() {
		if(true){
			throw new RuntimeException("Monitor not available");
		}
		String result = "Se tiene conexion al servicios rest de ejemplo";
		return Response.status(200).entity(result).build();
	}
}