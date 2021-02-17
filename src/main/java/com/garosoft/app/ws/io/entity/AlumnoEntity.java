package com.garosoft.app.ws.io.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "alumnos")
public class AlumnoEntity implements Serializable {

	private static final long serialVersionUID = -7874981523607988040L;
	private int idBoleta;
	private String nombre;
	private String ap;
	private String am;
	private String fechaNacimiento;
	private String email;
	private String password;
	private String curp;
	private String telefono;
	private String direccion;
	private String escuela;
	private String carrera;

	@Id
	@Column(name="idboleta", nullable = false, unique = true)
	public int getIdBoleta() {
		return idBoleta;
	}

	public void setIdBoleta(int IdBoleta) {
		this.idBoleta = IdBoleta;
	}

	@Column(name = "Nombre")
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "Ap")
	public String getAp() {
		return ap;
	}

	public void setAp(String ap) {
		this.ap = ap;
	}

	@Column(name = "Am")
	public String getAm() {
		return am;
	}

	public void setAm(String am) {
		this.am = am;
	}

	@Column(name = "FechaNacimiento")
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	@Column(name = "Email", unique=true)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "Password")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "Curp")
	public String getCurp() {
		return curp;
	}

	public void setCurp(String curp) {
		this.curp = curp;
	}

	@Column(name = "Telefono")
	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Column(name = "Direccion")
	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@Column(name = "Escuela")
	public String getEscuela() {
		return escuela;
	}

	public void setEscuela(String escuela) {
		this.escuela = escuela;
	}

	@Column(name = "Carrera")
	public String getCarrera() {
		return carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}

}
