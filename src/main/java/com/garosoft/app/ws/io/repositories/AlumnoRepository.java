package com.garosoft.app.ws.io.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.garosoft.app.ws.io.entity.AlumnoEntity;

@Repository
public interface AlumnoRepository extends JpaRepository<AlumnoEntity, Integer> {	
	AlumnoEntity findByEmail(String email);
	
}
