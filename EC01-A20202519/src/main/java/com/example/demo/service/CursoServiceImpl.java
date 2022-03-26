package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.CursoRequestDTO;
import com.example.demo.dto.CursoResponseDTO;
import com.example.demo.model.Curso;
import com.example.demo.repository.CursoRepository;
@Service
public class CursoServiceImpl implements CursoService {

	@Autowired
	private CursoRepository repository;
	
	@Override
	public void guardarCurso(CursoRequestDTO c) {
		Curso curso = new Curso();
		
		curso.setIdCurso(c.getIdRequest());
		curso.setDescripcion(c.getDescripcionCurso());
		curso.setCurso(c.getNombreCurso());
		curso.setMalla(c.getIdMalla());	
		repository.save(curso);

	}

	@Override
	public void eliminarCurso(Integer id) {
		repository.deleteById(id);

	}

	@Override
	public void editarCurso(CursoRequestDTO c) {
		Curso curso = new Curso();
		
		curso.setIdCurso(c.getIdRequest());
		curso.setDescripcion(c.getDescripcionCurso());
		curso.setCurso(c.getNombreCurso());		
		
		repository.saveAndFlush(curso);

	}

	@Override
	public List<CursoResponseDTO> listarCurso() {
		
		List<Curso> curso = repository.findAll();
		
		List<CursoResponseDTO> dto = new ArrayList<CursoResponseDTO>();
		CursoResponseDTO cursoDto = null;
		
		for (Curso cursos : curso) {
			cursoDto = new CursoResponseDTO();
			
			cursoDto.setIdResponse(cursos.getIdCurso());
			cursoDto.setDescripcionCurso(cursos.getDescripcion());
			cursoDto.setNombreCurso(cursos.getCurso());
			
			dto.add(cursoDto);
		}
		return dto;
	}

	@Override
	public CursoResponseDTO cursoById(Integer id) {
		
		Curso cursos = repository.findById(id).orElse(null);
		CursoResponseDTO cursooDto = new CursoResponseDTO();
		
		cursooDto = new CursoResponseDTO();		
		cursooDto.setIdResponse(cursos.getIdCurso());
		cursooDto.setDescripcionCurso(cursos.getDescripcion());
		cursooDto.setNombreCurso(cursos.getCurso());
		
		return cursooDto;
	}

}
