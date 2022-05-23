package tech.dynae.app.ws.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tech.dynae.app.delegate.ConsumeApiDelegate;
import tech.dynae.app.service.response.Response;

@RestController
@RequestMapping("/data")
public class ConsumeApiController {

	@Autowired
	private ConsumeApiDelegate consumeApiDelegate;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Response>> getData(){
		return new ResponseEntity<List<Response>>(consumeApiDelegate.getResponse(), HttpStatus.OK);
	}
	
}
