package tech.dynae.app.service;

import tech.dynae.app.service.request.Request;
import tech.dynae.app.service.response.Response;

public interface ConsumeApiService {

	Response getResponse(Request request);
	
}
