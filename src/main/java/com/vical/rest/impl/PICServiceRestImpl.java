package com.vical.rest.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

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
	public String verificarService(String argumento) {
		if(StringUtils.isEmpty(argumento)) {
			throw new RuntimeException();
		} else {
			return "Exito";
		}
	}
}