package tech.dynae.app.service.helpers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import tech.dynae.app.service.model.ResponseFromApi;

/**
 * Clase que tiene como fin retornar la cantidad de segundos que la temperatura se mantuvo por sobre la especificada por el usuario.
 * @author Pedro Gutiérrez
 */
public final class ReturnSecondsHelper {

	/**
	 * @param responseList. Este parámetro contiene un array con toda la consulta.
	 * @param magnitude. Este parámetro contiene la temperatúra escogida por el usuario
	 * @return Devuelve la cantidad de segundos donde la temperatura se mantuvo por sobre la escogida por el usuario.
	 */
	public static long getSeconds(List<ResponseFromApi> responseList, double magnitude) {
		
		// Ordenar la lista por fechas
		Collections.sort(responseList, (o1, o2) -> o1.getTimestamp().compareTo(o2.getTimestamp()));
		List<Date> dateList = new ArrayList<Date>();
		
		// Variable usada para recorrer dateList comparando fechas y calculando los segundos.
		int i = 0;
		// Variable que va acumulando los segundos y que finalmente es retornada.
		long seconds = 0;
		
		// Se recorre la lista para evaluar si el °C es mayor que el ingresado por el usuario.
		for (ResponseFromApi responseFromApi : responseList) {
			
			//Se evalúa si es mayor
			if (responseFromApi.getMagnitude() > magnitude) {	
				// se añade a dateList
				dateList.add(responseFromApi.getTimestamp());
				if(dateList.size() > 1) {
					// Se obtiene la diferencia de la fecha en segundos y se suma a la variable seconds
					long difference_In_Time = dateList.get(i).getTime() - dateList.get(i - 1).getTime();
					long difference_In_Seconds = TimeUnit.MILLISECONDS.toSeconds(difference_In_Time);
					seconds = seconds + difference_In_Seconds;
				}
				// Aumentar en 1
				i++;
			} else {
				// calcular y vaciar array
				dateList.add(responseFromApi.getTimestamp());
				if(dateList.size() > 1) {
					long difference_In_Time = dateList.get(i).getTime() - dateList.get(i - 1).getTime();
					long difference_In_Seconds = TimeUnit.MILLISECONDS.toSeconds(difference_In_Time);
					seconds = seconds + difference_In_Seconds;
				}
				dateList.clear();
				i = 0;
			}
		}
		
		return seconds;
	}

}
