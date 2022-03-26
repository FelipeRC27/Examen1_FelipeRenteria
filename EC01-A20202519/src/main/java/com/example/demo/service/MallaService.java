package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.MallaRequestDTO;
import com.example.demo.dto.MallaResponseDTO;

public interface MallaService {

	public void guardarMalla(MallaRequestDTO m);
	public void eliminarMalla(Integer id);
	public void editarMalla(MallaRequestDTO m);
	public List<MallaResponseDTO> listarMalla();
	public MallaResponseDTO mallaById(Integer id);
}
