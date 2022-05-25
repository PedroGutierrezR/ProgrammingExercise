package tech.dynae.service.impl;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tech.dynae.app.service.ConsumeApiService;
import tech.dynae.app.service.helpers.ReturnMinAndMaxMagnitudeHelper;
import tech.dynae.app.service.helpers.ReturnSecondsHelper;
import tech.dynae.app.service.model.ResponseFromApi;
import tech.dynae.app.service.request.Request;
import tech.dynae.app.service.response.Response;

@SpringBootTest
public class ConsumeApiServiceImplTest {

	@Autowired
	private ConsumeApiService underTest;
	
	@Test
	void itShouldReturnAResponseObject() {
		// Given
		Request request = new Request();
		request.setDateInicial(LocalDate.of(2022,04,22));
		request.setDateFinal(LocalDate.of(2022,04,23));
		request.setTimeInicial("04:00:00");
		request.setTimeFinal("03:59:59");
		request.setMagnitude(10);
		
		// When
		Response response = underTest.getResponse(request);
		
		// Then
		assertThat(response.getClass()).isEqualTo(Response.class);
	}
	
	@Test
	void itShouldReturnANumber() {
		// Given
		Date date1 = new GregorianCalendar(2022, 04, 22, 4, 0, 0).getTime();
		Date date2 = new GregorianCalendar(2022, 04, 23, 3, 59, 59).getTime();
		
		ResponseFromApi responseFromApi = new ResponseFromApi();
		responseFromApi.setTimestamp(date1);
		responseFromApi.setMagnitude(10.0);
		ResponseFromApi responseFromApi2 = new ResponseFromApi();
		responseFromApi2.setTimestamp(date2);
		
		responseFromApi2.setMagnitude(17.0);
		List<ResponseFromApi> dummyResponseFromApi = new ArrayList<ResponseFromApi>();
		dummyResponseFromApi.add(responseFromApi);
		dummyResponseFromApi.add(responseFromApi2);
		
		// When 
		Double maxResult = ReturnMinAndMaxMagnitudeHelper.getMaxMagnitude(dummyResponseFromApi);
		Double minResult = ReturnMinAndMaxMagnitudeHelper.getMinMagnitude(dummyResponseFromApi);
		long seconds = ReturnSecondsHelper.getSeconds(dummyResponseFromApi, 9);
		
		// Then
		assertThat(maxResult).isEqualTo(17.0);
		assertThat(minResult).isEqualTo(10.0);
		assertThat(seconds).isEqualTo(86399);
		
	}
	
}
