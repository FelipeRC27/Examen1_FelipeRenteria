package com.example.demo.dto;

import com.example.demo.model.Malla;

public class CursoRequestDTO {

	private Integer idRequest;
	private String nombreCurso;
	private String descripcionCurso;
	private Malla idMalla; //
	
	


	public Malla getIdMalla() {
		return idMalla;
	}
	public void setIdMalla(Malla idMalla) {
		this.idMalla = idMalla;
	}
	public Integer getIdRequest() {
		return idRequest;
	}
	public void setIdRequest(Integer idRequest) {
		this.idRequest = idRequest;
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
