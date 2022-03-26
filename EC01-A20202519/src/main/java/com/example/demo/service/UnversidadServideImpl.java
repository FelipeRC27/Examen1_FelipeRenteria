package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.CursoResponseDTO;
import com.example.demo.dto.UniversidadRequestDTO;
import com.example.demo.dto.UniversidadResponseDTO;
import com.example.demo.model.Curso;
import com.example.demo.model.Universidad;
import com.example.demo.repository.CursoRepository;
import com.example.demo.repository.UniversidadRepository;
@Service
public class UnversidadServideImpl implements UniversidadService {

	
	@Autowired
	private UniversidadRepository repository;
	
	
	@Override
	public void guardarUniversidad(UniversidadRequestDTO u) {
		Universidad universidad = new Universidad();
		
		universidad.setIdUniversidad(u.getIdRequest());
		universidad.setUniversidad(u.getNombreUniversidad());
			
		repository.save(universidad);

	}

	@Override
	public void eliminarUniversidad(Integer id) {
		repository.deleteById(id);

	}

	@Override
	public void editarUniversidad(UniversidadRequestDTO u) {

		Universidad universidad = new Universidad();
		
		universidad.setIdUniversidad(u.getIdRequest());
		universidad.setUniversidad(u.getNombreUniversidad());			
		
		repository.saveAndFlush(universidad);

	}

	@Override
	public List<UniversidadResponseDTO> listarUnivrsidad() {
		List<Universidad> universidad = repository.findAll();
		
		List<UniversidadResponseDTO> dto = new ArrayList<UniversidadResponseDTO>();
		UniversidadResponseDTO universiddDto = null;
		
		for (Universidad universidades : universidad) {
			universiddDto = new UniversidadResponseDTO();
			
			universiddDto.setIdResponse(universidades.getIdUniversidad());
			universiddDto.setNombreUniversidad(universidades.getUniversidad());
			
			dto.add(universiddDto);
		}
		return dto;
	}

	@Override
	public UniversidadResponseDTO universidadById(Integer id) {

		Universidad universidades = repository.findById(id).orElse(null);
		UniversidadResponseDTO universidadDto = new UniversidadResponseDTO();
		
		universidadDto = new UniversidadResponseDTO();		
		universidadDto.setIdResponse(universidades.getIdUniversidad());
		universidadDto.setNombreUniversidad(universidades.getUniversidad());		
		
		return universidadDto;
	}

}
