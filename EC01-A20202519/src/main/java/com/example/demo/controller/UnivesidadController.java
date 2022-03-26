package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.UniversidadRequestDTO;
import com.example.demo.dto.UniversidadResponseDTO;
import com.example.demo.service.UniversidadService;

@RestController
@RequestMapping("/universidad/v1")
public class UnivesidadController {
	
	@Autowired
	private UniversidadService service;
	
	@RequestMapping(method = RequestMethod.GET, path = "/listar")
	public ResponseEntity<List<UniversidadResponseDTO>>listar(){
		return new ResponseEntity<List<UniversidadResponseDTO>>	(service.listarUnivrsidad(),HttpStatus.OK);	
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/guardar")
	public ResponseEntity<Void> guardar(@RequestBody UniversidadRequestDTO universidad){
		service.guardarUniversidad(universidad);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	
	@RequestMapping(method = RequestMethod.GET, path = "/listar/{id}")
	public @ResponseBody ResponseEntity<UniversidadResponseDTO> productById(@PathVariable Integer id){
		UniversidadResponseDTO universidad = service.universidadById(id);
		if(universidad != null) {
			return new ResponseEntity<UniversidadResponseDTO>(universidad, HttpStatus.OK);

		}
		return new ResponseEntity<UniversidadResponseDTO>(HttpStatus.NOT_FOUND);

	}
	
	@RequestMapping(method = RequestMethod.DELETE, path = "/eliminar/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable Integer id){
		UniversidadResponseDTO universidad = service.universidadById(id);
		if(universidad != null) {
			service.eliminarUniversidad(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);

	}
	
	@RequestMapping(method = RequestMethod.PUT, path = "/editar")
	public ResponseEntity<Void> editar(@RequestBody UniversidadRequestDTO universidad){
		UniversidadResponseDTO univer = service.universidadById(universidad.getIdRequest());
		if(univer != null) {
			service.editarUniversidad(universidad);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}


}
