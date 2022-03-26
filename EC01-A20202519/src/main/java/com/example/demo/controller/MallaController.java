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

import com.example.demo.dto.MallaRequestDTO;
import com.example.demo.dto.MallaResponseDTO;
import com.example.demo.service.MallaService;

@RestController
@RequestMapping("/malla/v1")
public class MallaController {

	@Autowired
	private MallaService service;
	
	@RequestMapping(method = RequestMethod.GET, path = "/listar")
	public ResponseEntity<List<MallaResponseDTO>>listar(){
		return new ResponseEntity<List<MallaResponseDTO>>(service.listarMalla(),HttpStatus.OK);	
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/guardar")
	public ResponseEntity<Void> guardar(@RequestBody MallaRequestDTO malla){
		service.guardarMalla(malla);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	
	@RequestMapping(method = RequestMethod.GET, path = "/listar/{id}")
	public @ResponseBody ResponseEntity<MallaResponseDTO> mallaById(@PathVariable Integer id){
		MallaResponseDTO product = service.mallaById(id);
		if(product != null) {
			return new ResponseEntity<MallaResponseDTO>(product, HttpStatus.OK);

		}
		return new ResponseEntity<MallaResponseDTO>(HttpStatus.NOT_FOUND);

	}
	
	@RequestMapping(method = RequestMethod.DELETE, path = "/eliminar/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable Integer id){
		MallaResponseDTO malla = service.mallaById(id);
		if(malla != null) {
			service.eliminarMalla(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);

	}
	
	@RequestMapping(method = RequestMethod.PUT, path = "/editar")
	public ResponseEntity<Void> editar(@RequestBody MallaRequestDTO malla){
		MallaResponseDTO ma = service.mallaById(malla.getIdRequest());
		if(ma != null) {
			service.editarMalla(malla);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
}
