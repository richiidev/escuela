package com.richiidev.escuela.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.richiidev.escuela.model.Alumno;
import com.richiidev.escuela.repository.AlumnoRepo;

@Service
public class AlumnoService {

	@Autowired
	AlumnoRepo repo;
	
	public List<Alumno> getAllAlumnos(){
		return this.repo.findAll();
	}
	
	public List<Alumno> getAlumnoById(int id){
		return this.repo.findById(id);
	}
	
	public List<Alumno> getAlumnoByNumeroControl(String numeroControl){
		return this.repo.findByNumeroControl(numeroControl);
	}
	
	public void deleteById(int id) {
		this.repo.deleteById(id);
	}
	
	public void saveAlumno(Alumno alumno) {
		this.repo.save(alumno);
	}
	
	public void updateAlumno(Alumno alumno) {
		this.repo.save(alumno);
	}
}
