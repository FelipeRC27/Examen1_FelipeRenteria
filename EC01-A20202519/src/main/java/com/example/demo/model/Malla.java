package com.example.demo.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name = "malla")
@Entity
public class Malla implements Serializable {

	private static final long serialVersionUID = -2574290163340279615L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Integer idMalla;
	private String anio;
	
	@OneToMany(mappedBy = "malla")
	private List<Malla> malla = new ArrayList<>();
	
	@OneToOne(mappedBy = "mallas") 
	private Universidad universidades;

	public Integer getIdMalla() {
		return idMalla;
	}

	public void setIdMalla(Integer idMalla) {
		this.idMalla = idMalla;
	}

	public String getAnio() {
		return anio;
	}

	public void setAnio(String anio) {
		this.anio = anio;
	}

	public List<Malla> getMalla() {
		return malla;
	}

	public void setMalla(List<Malla> malla) {
		this.malla = malla;
	}

	public Universidad getUniversidades() {
		return universidades;
	}

	public void setUniversidades(Universidad universidades) {
		this.universidades = universidades;
	}


	
	
	
}
