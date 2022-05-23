package tech.dynae.app.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import tech.dynae.app.service.response.Response;

@Service("consumeApiService")

public class ConsumeApiServiceImpl implements ConsumeApiService {

	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public List<Response>  getResponse() {
		String url = "http://data-env.eba-pwemrg4q.us-east-1.elasticbeanstalk.com/data/sensorElement/783/measurement?from=2022-04-22T04:00:00.000Z&to=2022-04-23T03:59:59.000Z&timeUnit=SEC";
		Response[] responseList = restTemplate.getForObject(url, Response[].class);
		for (Response response : responseList) {
			int i = 0;
			while(i < 11) {
				System.out.println(response.getMagnitude());
				i++;
			}	
		}
		return Arrays.asList(responseList);
	}

}
