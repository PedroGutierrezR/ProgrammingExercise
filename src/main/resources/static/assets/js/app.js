const writeMinMagnitude = document.querySelector("#writeMinMagnitude");
const writeMaxMagnitude = document.querySelector("#writeMaxMagnitude");
const writeSeconds = document.querySelector("#writeSeconds");
const form = document.querySelector("#form");
const requestBtn = document.querySelector("#requestBtn");

$(document).ready(function() {

	// Llamada a función para desplegar un loading. (La función está al final)
	let loader = $("#loading-screen");
	configureLoadingScreen(loader);

	// Este evento va a escuchar el boton "Consultar" del jsp.
	$("#requestBtn").click(function() {

		// Si está todo la validacion de cada input retorna true entonces se realiza la petición
		if (isValid()) {

			console.log("All right");
			// Se agregan los valor al objeto inputData para ser enviado al backend.
			let inputData = {
				dateInicial: $("#dateInicial").val(),
				timeInicial: $("#timeInicial").val(),
				dateFinal: $("#dateFinal").val(),
				timeFinal: $("#timeFinal").val(),
				magnitude: $("#degrees").val(),
			}
			console.log(inputData);

			// Ajax que solicita la información por método POST.
			$.ajax({
				data: JSON.stringify(inputData),
				type: "POST",
				dataType: "json",
				url: "/data",
				contentType: 'application/json'
			})
				//Si todo sale bien entra a está función
				.done(function(data, textStatus, jqXHR) {
					console.log("La solicitud se ha completado correctamente.", data, textStatus, jqXHR);

					// Si por alguna razón no existen datos en las fechas solicitadas avisará mediante un mensaje que hubo un error.
					if (data.maxMagnitude == null || data.minMagnitude == null) {
						/*
						Esta instrucción viene de sweetalert. 
						Es importado de esta manera en el jsp -> <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
						*/
						swal({
							text: data.message,
							icon: "error"
						});
						//return sin valor con la finalidad de terminar en ese momento la ejecución de la función.
						return;
					}
					//Escribir datos que vienen desde la api al jsp. 
					writeMinMagnitude.innerHTML = data.minMagnitude;
					writeMaxMagnitude.innerHTML = data.maxMagnitude;
					writeSeconds.innerHTML = data.seconds;
				})
				//Si algo sale mal entra a esta función.
				.fail(function(jqXHR, textStatus, errorThrown) {
					console.log("La solicitud a fallado: ", errorThrown, textStatus, jqXHR);
				})

		} else {
			console.log("nothing happening");
		}

	});

	//Validación de cada input
	const isValid = () => {

		var dateInicial = false;
		var timeInicial = false;
		var dateFinal = false;
		var timeFinal = false;
		var dateFinal = false;
		var degrees = false;

		if ($("#dateInicial").val().length == 0) {
			$("#dateInicial").addClass("is-invalid");
			$("#dateInicial").removeClass("is-valid");
			dateInicial = false;
		} else {
			$("#dateInicial").removeClass("is-invalid");
			$("#dateInicial").addClass("is-valid");
			dateInicial = true;
		}

		if ($("#timeInicial").val().length == 0 || $("#timeInicial").val().length == 5) {
			$("#timeInicial").addClass("is-invalid");
			$("#timeInicial").removeClass("is-valid");
			timeInicial = false;
		} else {
			$("#timeInicial").removeClass("is-invalid");
			$("#timeInicial").addClass("is-valid");
			timeInicial = true;
		}
		if ($("#dateFinal").val().length == 0) {
			$("#dateFinal").addClass("is-invalid");
			$("#dateFinal").removeClass("is-valid");
			dateFinal = false;
		} else {
			$("#dateFinal").removeClass("is-invalid");
			$("#dateFinal").addClass("is-valid");
			dateFinal = true;
		}
		if ($("#timeFinal").val().length == 0 || $("#timeFinal").val().length == 5) {
			$("#timeFinal").addClass("is-invalid");
			$("#timeFinal").removeClass("is-valid");
			timeFinal = false;
		} else {
			$("#timeFinal").removeClass("is-invalid");
			$("#timeFinal").addClass("is-valid");
			timeFinal = true;
		}

		if ($("#degrees").val().length == 0) {
			$("#degrees").addClass("is-invalid");
			$("#degrees").removeClass("is-valid");
			degrees = false;
		} else {
			$("#degrees").removeClass("is-invalid");
			$("#degrees").addClass("is-valid");
			degrees = true;
		}

		if ($("#dateInicial").val() > $("#dateFinal").val()) {

			$("#dateInicial").addClass("is-invalid");
			$("#dateInicial").removeClass("is-valid");

			swal({
				text: "Fecha Inicial debe ser menor a Fecha Final",
				icon: "error"
			});

			dateInicial = false;

		} else if ($("#dateInicial").val() == $("#dateFinal").val() && $("#timeInicial").val() == $("#timeFinal").val()) {

			swal({
				text: "Al ser la misma fecha, al menos los segundos deben ser diferentes",
				icon: "error"
			});

			$("#dateInicial").removeClass("is-invalid");
			$("#dateInicial").addClass("is-valid");
			dateInicial = true;
			$("#timeInicial").addClass("is-invalid");
			$("#timeInicial").removeClass("is-valid");
			timeInicial = false;
			$("#timeFinal").addClass("is-invalid");
			$("#timeFinal").removeClass("is-valid");
			timeFinal = false;

		} else if ($("#dateInicial").val() == $("#dateFinal").val() && $("#timeInicial").val() > $("#timeFinal").val()) {
			swal({
				text: "La hora inicial debe ser menor a la final",
				icon: "error"
			});

			$("#timeInicial").addClass("is-invalid");
			$("#timeInicial").removeClass("is-valid");
			timeInicial = false;
			$("#timeFinal").addClass("is-invalid");
			$("#timeFinal").removeClass("is-valid");
			timeFinal = false;
		} else {
			$("#dateInicial").removeClass("is-invalid");
			$("#dateInicial").addClass("is-valid");
			dateInicial = true;
		}

		return dateInicial && timeInicial && dateFinal && timeFinal && degrees;
	}

});

function validar() {

	let deshabilitar = false;

	if ($("#dateInicial").val().length == 0) {
		deshabilitar = true;
	}
	if ($("#timeInicial").val().length == 0) {
		deshabilitar = true;
	}
	if ($("#dateFinal").val().length == 0) {
		deshabilitar = true;
	}
	if ($("#timeFinal").val().length == 0) {
		deshabilitar = true;
	}
	if ($("#degrees").val().length == 0) {
		deshabilitar = true;
	}
	requestBtn.disabled = deshabilitar;
}

form.addEventListener('keyup', validar);

// Función que despliega un loading mientras se espera la respuesta desde la Api.
function configureLoadingScreen(loader) {
	$(document)
		.ajaxStart(function() {
			loader.fadeIn();
		})
		.ajaxStop(function() {
			loader.fadeOut();
		})
}
