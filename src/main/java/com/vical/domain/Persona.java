package com.vical.domain;

public class Persona {
	private String nombre;
	public String getNombre() { return nombre; }
	public void setNombre(String nombre) { this.nombre = nombre; }
	
	private String paterno;
	public String getPaterno() { return paterno; }
	public void setPaterno(String paterno) { this.paterno = paterno; }
	
	private String materno;
	public String getMaterno() { return materno; }
	public void setMaterno(String materno) { this.materno = materno; }
	
	private Integer edad;
	public Integer getEdad() { return edad; }
	public void setEdad(Integer edad) { this.edad = edad; }
	
	private Valor tipoDocumento;
	public Valor getTipoDocumento() { return tipoDocumento; }
	public void setTipoDocumento(Valor tipoDocumento) { this.tipoDocumento = tipoDocumento; }
}