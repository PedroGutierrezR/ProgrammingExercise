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

// Clase que recibe las peticiones desde el cliente.
@RestController
@RequestMapping("/data")
public class ConsumeApiController {

	@Autowired
	private ConsumeApiDelegate consumeApiDelegate;
	
	// Único método que recibe y retorna un Json por método POST. @RequestBody recibe los datos desde app.js
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response> getData(@RequestBody Request request){
		return new ResponseEntity<Response>(consumeApiDelegate.getResponse(request), HttpStatus.OK);
	}
	
}
