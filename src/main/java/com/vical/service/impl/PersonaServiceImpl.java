package com.vical.service.impl;

import org.springframework.stereotype.Service;

import com.vical.domain.Persona;
import com.vical.domain.Valor;
import com.vical.service.IPersonaService;

@Service
public class PersonaServiceImpl implements IPersonaService {

	@Override
	public Persona obtenerDatosPersona(String tipoDOI) throws RuntimeException {
		Persona persona = null;
		if(tipoDOI.equals("12345678")){
			persona = new Persona();
			persona.setNombre("Vical");
			persona.setMaterno("Lozano");
			persona.setPaterno("Rodriguez");
			persona.setEdad(26);
			Valor tipoDocumento = new Valor(); tipoDocumento.setEtiqueta("DNI");
			persona.setTipoDocumento(tipoDocumento);
		}
		return persona;
	}
}
