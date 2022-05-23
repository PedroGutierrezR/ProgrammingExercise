$(document).ready(function() {

	$.ajax({
		type: "GET",
		dataType: "json",
		url: "/data",
		contentType: 'application/json'
	})
		.done(function(data, textStatus, jqXHR) {
			console.log("La solicitud se ha completado correctamente.", data, textStatus, jqXHR);
		})
		.fail(function(jqXHR, textStatus, errorThrown) {
			console.log("La solicitud a fallado: ", errorThrown, textStatus, jqXHR);
		})

});