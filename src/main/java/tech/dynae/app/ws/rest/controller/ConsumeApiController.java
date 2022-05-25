package tech.dynae.app.ws.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tech.dynae.app.delegate.ConsumeApiDelegate;
import tech.dynae.app.service.request.Request;
import tech.dynae.app.service.response.Response;

/**
 * Clase que recibe las peticiones desde el cliente.
 * @author Pedro Gutiérrez
 */ 
@RestController
@RequestMapping("/data")
public class ConsumeApiController {

	@Autowired
	private ConsumeApiDelegate consumeApiDelegate;
	
	/**
	 * @param request. Este parámetro contiene los valores ingresados por el usuario en los input del jsp.
	 * @return Devuelve una respuesta en formato JSON con los campos que se requieren: minMagnitude, maxMagnitude, seconds y message.
	 */
	// Único método que recibe y retorna un JSON por método POST. @RequestBody recibe los datos desde app.js
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response> getData(@RequestBody Request request){
		return new ResponseEntity<Response>(consumeApiDelegate.getResponse(request), HttpStatus.OK);
	}
	
}
