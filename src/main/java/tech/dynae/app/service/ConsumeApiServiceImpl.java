package tech.dynae.app.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import tech.dynae.app.service.helpers.ReturnMinAndMaxMagnitudeHelper;
import tech.dynae.app.service.helpers.ReturnSecondsHelper;
import tech.dynae.app.service.model.ResponseFromApi;
import tech.dynae.app.service.request.Request;
import tech.dynae.app.service.response.Response;

// En esta clase está toda la lógica de negocio.
@Service("consumeApiService")
public class ConsumeApiServiceImpl implements ConsumeApiService {

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public Response getResponse(Request request) {
		
		// instancia de la clase Response donde se hace un "set" a cada campo.
		Response response = new Response();
		
		// Url donde se concatenan los datos que vienen del request (viene como parámetro getResponse(Request request)). 
		String url = "http://data-env.eba-pwemrg4q.us-east-1.elasticbeanstalk.com/data/sensorElement/783/measurement?from="
				+ request.getDateInicial() + "T" + request.getTimeInicial() + ".000Z&to=" + request.getDateFinal() + "T"
				+ request.getTimeFinal() + ".000Z&timeUnit=SEC";

		// Utilizando restTemplate se traen los datos de la Api y se guardar en un array.
		ResponseFromApi[] responseList = restTemplate.getForObject(url, ResponseFromApi[].class);

		// Pueden venir un array vacío, por lo que agregué este "if".
		if(Arrays.asList(responseList).size() == 0) {
			response.setMessage("Lo sentimos, no hay información para mostrar");
			return response;
		}
		
		// se hace un "set" a cada campo y se utilizan clases con métodos estáticos (clases utilitarias).
		response.setMinMagnitude(ReturnMinAndMaxMagnitudeHelper.getMinMagnitude(Arrays.asList(responseList)));
		response.setMaxMagnitude(ReturnMinAndMaxMagnitudeHelper.getMaxMagnitude(Arrays.asList(responseList)));
		response.setSeconds(ReturnSecondsHelper.getSeconds(Arrays.asList(responseList), request.getMagnitude()));
		response.setMessage("Servicio finalizado correctamente");

		return response;
	}

}
