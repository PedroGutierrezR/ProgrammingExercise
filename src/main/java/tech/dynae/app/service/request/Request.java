package tech.dynae.app.service.request;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Clase usada para recibir los datos ingresados en cada input del jsp
 * @author Pedro Gutiérrez
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Request {

	private LocalDate dateInicial;
	private String timeInicial;
	private LocalDate dateFinal;
	private String timeFinal;
	private double magnitude;
	
}
