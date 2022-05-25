package tech.dynae.app.service.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Clase usada para recibir la respuesta de la Api. 
 * Solo se consideró los datos relevantes para realizar calculos: magnitude y timestamp.
 * @author Pedro Gutiérrez
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseFromApi {

	private Double magnitude;
	private Date timestamp;
	
}
