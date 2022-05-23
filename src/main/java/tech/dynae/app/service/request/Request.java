package tech.dynae.app.service.request;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Request {

	private double magnitude;
	private LocalDateTime startTime;
	private LocalDateTime endTime;
	
}
