package com.garosoft.app.ws.ui.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.garosoft.app.ws.impl.AlumnoServiceImpl;
import com.garosoft.app.ws.service.AlumnoService;
import com.garosoft.app.ws.shared.dto.AlumnoDto;
import com.garosoft.app.ws.ui.model.request.AlumnoModel;
import com.garosoft.app.ws.ui.model.response.AlumnoRest;

@RestController //Permite que la clase actue como servlet
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("alumnos")// http://localhost:8080/alumnos
// Very simple RESTful web service- difines CRUD operations
public class AlumnoController {
	@Autowired//crea link(intancia) entre el servicio y el rest
	AlumnoService alumnoService;
	
	@GetMapping
	public String getAlumno() {
		return "Obtener alumnno";
	}
	
	
	@PostMapping
	public AlumnoRest createAlumno(@RequestBody AlumnoModel alumno) {
		AlumnoRest returnValue = new AlumnoRest();
		AlumnoDto alumnoDto=new AlumnoDto();
		
		BeanUtils.copyProperties(alumno, alumnoDto);
		
		AlumnoDto createdAlumno = alumnoService.createAlumno(alumnoDto);
		BeanUtils.copyProperties(createdAlumno, returnValue);
		
		return returnValue; 
	}
	
	@PutMapping
	public String updateAlumno() {
		return "Actualizar alumno";
	}
	
	@DeleteMapping
	public String deletUser() {
		return "Remover alumno";
	}
	

}
