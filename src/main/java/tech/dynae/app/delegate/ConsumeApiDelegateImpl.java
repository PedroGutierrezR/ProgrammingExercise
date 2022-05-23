package tech.dynae.app.delegate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import tech.dynae.app.service.ConsumeApiService;
import tech.dynae.app.service.response.Response;

@Component("consumeApiDelegate")
public class ConsumeApiDelegateImpl implements ConsumeApiDelegate {

	@Autowired
	private ConsumeApiService consumeApiService;
	
	@Override
	public List<Response> getResponse() {
		return consumeApiService.getResponse();
	}

}
