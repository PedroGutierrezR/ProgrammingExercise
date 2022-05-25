package tech.dynae.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Clase controller que retorna la vista home.jsp
 * @author Pedro Gutiérrez
 */ 

@Controller
public class HomeController {
	
	/**
	 * @return Devuelve la vista.
	 */
	@GetMapping("/home")
	public String home() {
		return "home";
	}
	
}
