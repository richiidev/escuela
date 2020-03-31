package com.richiidev.escuela.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.richiidev.escuela.model.Carrera;

public interface CarreraRepo extends JpaRepository<Carrera, Serializable> {

	public List<Carrera> findAll();
	public List<Carrera> findById(int id);
	public List<Carrera> findByClave(String clave);
}
