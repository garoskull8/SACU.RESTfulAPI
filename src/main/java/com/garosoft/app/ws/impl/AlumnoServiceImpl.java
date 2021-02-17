package com.garosoft.app.ws.impl;

import java.security.spec.AlgorithmParameterSpec;
import java.util.ArrayList;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.garosoft.app.ws.io.entity.AlumnoEntity;
import com.garosoft.app.ws.io.repositories.AlumnoRepository;
import com.garosoft.app.ws.service.AlumnoService;
import com.garosoft.app.ws.shared.dto.AlumnoDto;

@Service
public class AlumnoServiceImpl implements AlumnoService, AlgorithmParameterSpec {

	@Autowired
	AlumnoRepository alumnoRepository;
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	@Override
	public AlumnoDto createAlumno(AlumnoDto alumno) {
		if(alumnoRepository.findByEmail(alumno.getEmail()) != null) throw new RuntimeException("ya existe");
		
		AlumnoEntity alumnoEntity= new AlumnoEntity();
		BeanUtils.copyProperties(alumno, alumnoEntity);
		
	
		alumnoEntity.setPassword(bCryptPasswordEncoder.encode(alumno.getPassword()));
		AlumnoEntity detallesAlmacenados=alumnoRepository.saveAndFlush(alumnoEntity);
		
		AlumnoDto returnValue= new AlumnoDto();
		BeanUtils.copyProperties(detallesAlmacenados,returnValue);
		return returnValue;
	}
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		AlumnoEntity alumnoEntity =  alumnoRepository.findByEmail(email);
		
		if(alumnoEntity==null)throw new UsernameNotFoundException(email);
		
		return new User(alumnoEntity.getEmail(),alumnoEntity.getPassword(),new ArrayList<>());
	}
	@Override
	public AlumnoDto getAlumno(String email) {
		AlumnoEntity alumnoEntity =  alumnoRepository.findByEmail(email);
		if(alumnoEntity==null)throw new UsernameNotFoundException(email);
		AlumnoDto returnValue= new AlumnoDto();
		BeanUtils.copyProperties(alumnoEntity,returnValue);
		return returnValue;
	}

}
