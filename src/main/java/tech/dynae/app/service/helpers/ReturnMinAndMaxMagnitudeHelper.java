package tech.dynae.app.service.helpers;

import java.util.Collections;
import java.util.List;
import tech.dynae.app.service.model.ResponseFromApi;

/**
 * Clase que tiene como fin retornar la mínima y máxima temperatura de la consulta.
 * @author Pedro Gutiérrez
 */
public final class ReturnMinAndMaxMagnitudeHelper {

	/**
	 * @param responseList. Este parámetro contiene un array con toda la consulta
	 * @return Devuelve la mínima temperatura del array
	 */
	public static Double getMinMagnitude(List<ResponseFromApi> responseList) {
		// Se ordena la lista por temperatura y se retorna la temperatura mínima
		Collections.sort(responseList, (o1, o2) -> o1.getMagnitude().compareTo(o2.getMagnitude()));
		return responseList.get(0).getMagnitude();
	}

	/** 
	 * @param responseList. Este parámetro contiene un array con toda la consulta.
	 * @return Devuelve la máxima temperatura del array
	 */
	public static Double getMaxMagnitude(List<ResponseFromApi> responseList) {
		// Se ordena la lista por temperatura y se retorna la temperatura máxima
		Collections.sort(responseList, (o1, o2) -> o1.getMagnitude().compareTo(o2.getMagnitude()));
		return responseList.get(responseList.size() - 1).getMagnitude();
	}

}
