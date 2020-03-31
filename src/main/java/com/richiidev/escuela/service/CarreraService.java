package com.richiidev.escuela.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.richiidev.escuela.model.Carrera;
import com.richiidev.escuela.repository.CarreraRepo;

@Service
public class CarreraService {

	@Autowired
	CarreraRepo repo;
	
	public List<Carrera> getAllCarreras(){
		return this.repo.findAll();
	}
	
	public List<Carrera> getCarreraById(int id){
		return this.repo.findById(id);
	}
	
	public List<Carrera> getByClave(String clave){
		return this.repo.findByClave(clave);
	}
	
	public void saveCarrera(Carrera carrera) {
		this.repo.save(carrera);
	}
	
	public void updateCarrera(Carrera carrera) {
		this.repo.save(carrera);
	}
	
	public void deleteById(int id) {
		this.repo.deleteById(id);
	}
}
