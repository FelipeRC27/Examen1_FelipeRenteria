package com.example.demo.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name = "universidad")
@Entity
public class Universidad implements Serializable{

	private static final long serialVersionUID = -1998297166784249392L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Integer idUniversidad;
	private String universidad;
	
	@OneToOne
	@JoinColumn(name = "id_malla", nullable = false, unique = true,
	foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key (id_malla) references malla (id_malla)"))
	private Malla mallas;

	public Integer getIdUniversidad() {
		return idUniversidad;
	}

	public void setIdUniversidad(Integer idUniversidad) {
		this.idUniversidad = idUniversidad;
	}

	public String getUniversidad() {
		return universidad;
	}

	public void setUniversidad(String universidad) {
		this.universidad = universidad;
	}

	public Malla getMallas() {
		return mallas;
	}

	public void setMallas(Malla mallas) {
		this.mallas = mallas;
	}
	
	

}
