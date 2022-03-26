package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.CursoResponseDTO;
import com.example.demo.dto.ProfesorRequestDTO;
import com.example.demo.dto.ProfesorResponseDTO;
import com.example.demo.model.Curso;
import com.example.demo.model.Profesor;
import com.example.demo.repository.ProfesorRepository;
@Service
public class ProfesorServiceImpl implements ProfesorService {

	
	@Autowired
	private ProfesorRepository repository;
	
	@Override
	public void guardarProfesor(ProfesorRequestDTO p) {
		
		Profesor profesor = new Profesor();
		
		profesor.setIdProfesor(p.getIdRequest());
		profesor.setProfesor(p.getNombreProfesor());
	
		repository.save(profesor);

	}

	@Override
	public void eliminarProfesor(Integer id) {
		repository.deleteById(id);

	}

	@Override
	public void editarProfesor(ProfesorRequestDTO p) {
		
		Profesor profesor = new Profesor();
		
		profesor.setIdProfesor(p.getIdRequest());
		profesor.setProfesor(p.getNombreProfesor());	
		
		repository.saveAndFlush(profesor);

	}

	@Override
	public List<ProfesorResponseDTO> listarProfesor() {
		List<Profesor> profesor = repository.findAll();
		
		List<ProfesorResponseDTO> dto = new ArrayList<ProfesorResponseDTO>();
		ProfesorResponseDTO profesorDto = null;
		
		for (Profesor profesores : profesor) {
			profesorDto = new ProfesorResponseDTO();
			
			profesorDto.setIdResponse(profesores.getIdProfesor());
			profesorDto.setNombreProfesor(profesores.getProfesor());
			
			dto.add(profesorDto);
		}
		return dto;
	}

	@Override
	public ProfesorResponseDTO profesortById(Integer id) {
		Profesor profesor = repository.findById(id).orElse(null);
		ProfesorResponseDTO profesorDto = new ProfesorResponseDTO();
		
		profesorDto = new ProfesorResponseDTO();		
		profesorDto.setIdResponse(profesor.getIdProfesor());
		profesorDto.setNombreProfesor(profesor.getProfesor());
		
		
		return profesorDto;
	}

}
