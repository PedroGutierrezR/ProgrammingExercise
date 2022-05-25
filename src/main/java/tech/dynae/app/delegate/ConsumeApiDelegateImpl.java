package tech.dynae.app.delegate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import tech.dynae.app.service.ConsumeApiService;
import tech.dynae.app.service.request.Request;
import tech.dynae.app.service.response.Response;

/**
 * Esta clase solo tiene la responsabilidad de llamar al servicio apropiado.
 * @author Pedro Gutiérrez
 */ 
@Component("consumeApiDelegate")
public class ConsumeApiDelegateImpl implements ConsumeApiDelegate {

	@Autowired
	private ConsumeApiService consumeApiService;
	
	/**
	 * @param request. Este parámetro contiene los valores ingresados por el usuario en los input del jsp. 
	 * @return Devuelve un objeto Response el cual finalmente es enviado al cliente.
	 */
	@Override
	public Response getResponse(Request request) {
		return consumeApiService.getResponse(request);
	}

}
