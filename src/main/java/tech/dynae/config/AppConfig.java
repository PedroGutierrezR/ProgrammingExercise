package tech.dynae.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Clase de configuración.
 * @author Pedro Gutiérrez
 */ 
@Configuration
@ComponentScan("tech.dynae.app.*")
public class AppConfig {

	/**
	 * @return Devuelve un instancia de la clase RestTemplate.
	 */
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
}

