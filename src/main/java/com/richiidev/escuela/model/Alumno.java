package com.richiidev.escuela.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "alumno", uniqueConstraints = {   @UniqueConstraint(columnNames = {"numeroControl"}), @UniqueConstraint(columnNames = {"correo"})})
public class Alumno {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String nombre;
	String apellidos;
	String numeroControl;
	String correo;
	@ManyToOne
	@JoinColumn(name = "idcarrera", table = "alumno")
	Carrera idcarrera;
	
}
