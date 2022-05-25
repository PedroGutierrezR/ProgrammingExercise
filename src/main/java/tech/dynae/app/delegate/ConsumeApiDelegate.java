package tech.dynae.app.delegate;

import tech.dynae.app.service.request.Request;
import tech.dynae.app.service.response.Response;

public interface ConsumeApiDelegate {

	Response getResponse(Request request);
	
}
