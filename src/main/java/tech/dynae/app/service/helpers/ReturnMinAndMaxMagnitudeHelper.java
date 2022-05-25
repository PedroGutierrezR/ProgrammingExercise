package tech.dynae.app.service.helpers;

import java.util.Collections;
import java.util.List;
import tech.dynae.app.service.model.ResponseFromApi;

public final class ReturnMinAndMaxMagnitudeHelper {

	public static Double getMinMagnitude(List<ResponseFromApi> responseList) {
		// Se ordena la lista por temperatura y se retorna la temperatura mínima
		Collections.sort(responseList, (o1, o2) -> o1.getMagnitude().compareTo(o2.getMagnitude()));
		return responseList.get(0).getMagnitude();
	}

	public static Double getMaxMagnitude(List<ResponseFromApi> responseList) {
		// Se ordena la lista por temperatura y se retorna la temperatura máxima
		Collections.sort(responseList, (o1, o2) -> o1.getMagnitude().compareTo(o2.getMagnitude()));
		return responseList.get(responseList.size() - 1).getMagnitude();
	}

}
