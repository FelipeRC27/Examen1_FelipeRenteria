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

import com.example.demo.dto.ProfesorRequestDTO;
import com.example.demo.dto.ProfesorResponseDTO;
import com.example.demo.service.ProfesorService;

@RestController
@RequestMapping("/profesor/v1")
public class ProfesorController {
	
	@Autowired
	private ProfesorService service;
	
	@RequestMapping(method = RequestMethod.GET, path = "/listar")
	public ResponseEntity<List<ProfesorResponseDTO>>listar(){
		return new ResponseEntity<List<ProfesorResponseDTO>>	(service.listarProfesor(),HttpStatus.OK);	
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/guardar")
	public ResponseEntity<Void> guardar(@RequestBody ProfesorRequestDTO profesor){
		service.guardarProfesor(profesor);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/listar/{id}")
	public @ResponseBody ResponseEntity<ProfesorResponseDTO> profesortById(@PathVariable Integer id){
		ProfesorResponseDTO profesor = service.profesortById(id);
		if(profesor != null) {
			return new ResponseEntity<ProfesorResponseDTO>(profesor, HttpStatus.OK);

		}
		return new ResponseEntity<ProfesorResponseDTO>(HttpStatus.NOT_FOUND);

	}
	
	@RequestMapping(method = RequestMethod.DELETE, path = "/eliminar/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable Integer id){
		ProfesorResponseDTO profesor = service.profesortById(id);
		if(profesor != null) {
			service.eliminarProfesor(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);

	}
	
	@RequestMapping(method = RequestMethod.PUT, path = "/editar")
	public ResponseEntity<Void> editar(@RequestBody ProfesorRequestDTO profesor){
		ProfesorResponseDTO profesors = service.profesortById(profesor.getIdRequest());
		if(profesors != null) {
			service.editarProfesor(profesor);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	

}
