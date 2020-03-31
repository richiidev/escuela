package com.richiidev.escuela.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.richiidev.escuela.model.Alumno;
import com.richiidev.escuela.pojo.Response;
import com.richiidev.escuela.service.AlumnoService;

import io.swagger.annotations.Api;

@CrossOrigin
@RestController
@Api(tags = "Alumno APIs")
public class AlumnoController {

	@Autowired
	AlumnoService service;
	
	// Api para obtener alumnos
	@GetMapping("/alumnos")
	public ResponseEntity<Response> getAllAlumnos() {
		try {
			Object response = service.getAllAlumnos();
			return new ResponseEntity<Response>(new Response(true, "Success", response), HttpStatus.OK);
		} catch (Exception e) {

			return new ResponseEntity<Response>(new Response(false, "Error " + e.getMessage(), null), HttpStatus.OK);
		}
	}
	
	// Api para obtener alumno por id 
	@GetMapping("/alumnos/id")
	public ResponseEntity<Response> getByAlumno(@RequestParam int id) {
		try {
			Object response = service.getAlumnoById(id);
			return new ResponseEntity<Response>(new Response(true, "Success", response), HttpStatus.OK);
		} catch (Exception e) {

			return new ResponseEntity<Response>(new Response(false, "Error " + e.getMessage(), null), HttpStatus.OK);
		}
	}
	
	// Api para obtener el objeto alumno por numero de control
	@GetMapping("/alumnos/numeroControl")
	public ResponseEntity<Response> getByAlumno(@RequestParam String numeroControl) {
		try {
			Object response = service.getAlumnoByNumeroControl(numeroControl);
			return new ResponseEntity<Response>(new Response(true, "Success", response), HttpStatus.OK);
		} catch (Exception e) {

			return new ResponseEntity<Response>(new Response(false, "Error " + e.getMessage(), null), HttpStatus.OK);
		}
	}
	
	
	// api para eliminar
		@DeleteMapping("/alumnos/id")
		public ResponseEntity<Response> deleteAlumno(@RequestParam("id") int id) {
			try {
				Object response = service.getAlumnoById(id);
				service.deleteById(id);
				return new ResponseEntity<Response>(new Response(true, "Success Eliminado", response), HttpStatus.OK);
			} catch (Exception e) {

				return new ResponseEntity<Response>(new Response(false, "Error " + e.getMessage(), null), HttpStatus.OK);
			}
		}
		
		// api post agregar
		@PostMapping("/alumnos")
		public ResponseEntity<Response> addAlumnos(@RequestBody Alumno alumno) {
			try {
				this.service.saveAlumno(alumno);;
				Response response = new Response(true, "Success!", alumno);
				return new ResponseEntity<Response>(response, HttpStatus.OK);

			} catch (Exception e) {
				Response response = new Response(false, "Error!, ..." + e.getMessage(), null);
				return new ResponseEntity<Response>(response, HttpStatus.OK);
			}
		}

		// api para modificar
		@PutMapping("/alumnos")
		public ResponseEntity<Response> updateAlumnos(@RequestBody Alumno alumno) {
			try {
				this.service.updateAlumno(alumno);
				Response response = new Response(true, "Success!", alumno);
				return new ResponseEntity<Response>(response, HttpStatus.OK);

			} catch (Exception e) {
				Response response = new Response(false, "Error!, ..." + e.getMessage(), null);
				return new ResponseEntity<Response>(response, HttpStatus.OK);
			}
		}

}
