package com.garosoft.app.ws.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.garosoft.app.ws.shared.dto.AlumnoDto;

public interface AlumnoService extends UserDetailsService {
	
	AlumnoDto createAlumno(AlumnoDto alumno);
	AlumnoDto getAlumno(String email);

}
