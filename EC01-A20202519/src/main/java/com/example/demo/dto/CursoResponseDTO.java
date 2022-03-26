package com.example.demo.dto;

import com.example.demo.model.Malla;

public class CursoResponseDTO {
	
	private Integer idResponse;
	private String nombreCurso;
	private String descripcionCurso;
	private Malla idMalla; //
	

	public Malla getIdMalla() {
		return idMalla;
	}
	public void setIdMalla(Malla idMalla) {
		this.idMalla = idMalla;
	}
	public Integer getIdResponse() {
		return idResponse;
	}
	public void setIdResponse(Integer idResponse) {
		this.idResponse = idResponse;
	}
	public String getNombreCurso() {
		return nombreCurso;
	}
	public void setNombreCurso(String nombreCurso) {
		this.nombreCurso = nombreCurso;
	}
	public String getDescripcionCurso() {
		return descripcionCurso;
	}
	public void setDescripcionCurso(String descripcionCurso) {
		this.descripcionCurso = descripcionCurso;
	}
	
	
}
