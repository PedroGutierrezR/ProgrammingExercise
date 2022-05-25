package tech.dynae.app.service.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Clase usada como respuesta al cliente.
 * @author Pedro Gutiérrez
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Response {
	
	private Double minMagnitude;
	private Double maxMagnitude;
	private long seconds;
	private String message;
	
}
