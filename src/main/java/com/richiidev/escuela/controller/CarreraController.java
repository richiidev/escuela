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

import com.richiidev.escuela.model.Carrera;
import com.richiidev.escuela.pojo.Response;
import com.richiidev.escuela.service.CarreraService;

import io.swagger.annotations.Api;

@CrossOrigin
@RestController
@Api(tags = "carreras APIs")
public class CarreraController {

	@Autowired 
	CarreraService service;
	
	//Api obtener todas las carreras
	@GetMapping("/carreras")
	public ResponseEntity<Response> getAllCarreras(){
		try {
			Object response = service.getAllCarreras();
			return new ResponseEntity<Response>(new Response(true,"Sucess",response), HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<Response>(new Response(false,"Error:   "+ e.getMessage(),null),HttpStatus.OK);
		}
	}
	
	//api obtener objeto por id
	@GetMapping("/carreras/id")
	public ResponseEntity<Response> getByIdCarrera(@RequestParam int id){
		try {
			Object response = service.getCarreraById(id);
			return new ResponseEntity<Response>(new Response(true,"Sucess",response),HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<Response>(new Response(false,"Error:   "+ e.getMessage(),null),HttpStatus.OK);
		}
	}
	//api obtener objeto por id
		@GetMapping("/carreras/clave")
		public ResponseEntity<Response> getByClave(@RequestParam String clave){
			try {
				Object response = service.getByClave(clave);
				return new ResponseEntity<Response>(new Response(true,"Sucess",response),HttpStatus.OK);
			} catch (Exception e) {
				// TODO: handle exception
				return new ResponseEntity<Response>(new Response(false,"Error:   "+ e.getMessage(),null),HttpStatus.OK);
			}
		}
		
		

		// api para eliminar
			@DeleteMapping("/carreras/id")
			public ResponseEntity<Response> deleteCarrera(@RequestParam int id) {
				try {
					Object response = service.getCarreraById(id);
					service.deleteById(id);
					return new ResponseEntity<Response>(new Response(true, "Success Eliminado", response), HttpStatus.OK);
				} catch (Exception e) {

					return new ResponseEntity<Response>(new Response(false, "Error " + e.getMessage(), null), HttpStatus.OK);
				}
			}
			
			// api post agregar
			@PostMapping("/carreras")
			public ResponseEntity<Response> addCarrera(@RequestBody Carrera carrera) {
				try {
					this.service.saveCarrera(carrera);
					Response response = new Response(true, "Success!", carrera);
					return new ResponseEntity<Response>(response, HttpStatus.OK);

				} catch (Exception e) {
					Response response = new Response(false, "Error!, ..." + e.getMessage(), null);
					return new ResponseEntity<Response>(response, HttpStatus.OK);
				}
			}

			// api para modificar
			@PutMapping("/carreras")
			public ResponseEntity<Response> updateAlumnos(@RequestBody Carrera carrera) {
				try {
					this.service.updateCarrera(carrera);
					Response response = new Response(true, "Success!", carrera);
					return new ResponseEntity<Response>(response, HttpStatus.OK);

				} catch (Exception e) {
					Response response = new Response(false, "Error!, ..." + e.getMessage(), null);
					return new ResponseEntity<Response>(response, HttpStatus.OK);
				}
			}
}
