package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.CursoResponseDTO;
import com.example.demo.dto.MallaRequestDTO;
import com.example.demo.dto.MallaResponseDTO;
import com.example.demo.model.Curso;
import com.example.demo.model.Malla;
import com.example.demo.repository.MallaRepository;
@Service
public class MallaServideImpl implements MallaService {

	@Autowired
	private MallaRepository repository;
	
	@Override
	public void guardarMalla(MallaRequestDTO m) {
		
		Malla malla = new Malla();
		
		malla.setIdMalla(m.getIdRequest());
		malla.setAnio(m.getAnioMalla());
		repository.save(malla);

	}

	@Override
	public void eliminarMalla(Integer id) {
		repository.deleteById(id);

	}

	@Override
	public void editarMalla(MallaRequestDTO m) {
		Malla malla = new Malla();
		
		malla.setIdMalla(m.getIdRequest());
		malla.setAnio(m.getAnioMalla());				
		
		repository.saveAndFlush(malla);
	}

	@Override
	public List<MallaResponseDTO> listarMalla() {
		List<Malla> malla = repository.findAll();
		
		List<MallaResponseDTO> dto = new ArrayList<MallaResponseDTO>();
		MallaResponseDTO mallaDto = null;
		
		for (Malla mallas : malla) {
			mallaDto = new MallaResponseDTO();
			
			mallaDto.setIdResponse(mallas.getIdMalla());
			mallaDto.setAnioMalla(mallas.getAnio());			
			
			dto.add(mallaDto);
		}
		return dto;
	}

	@Override
	public MallaResponseDTO mallaById(Integer id) {
		Malla malla = repository.findById(id).orElse(null);
		MallaResponseDTO mallaDto = new MallaResponseDTO();
		
		mallaDto = new MallaResponseDTO();		
		mallaDto.setIdResponse(malla.getIdMalla());
		mallaDto.setAnioMalla(malla.getAnio());

		return mallaDto;
	}

}
