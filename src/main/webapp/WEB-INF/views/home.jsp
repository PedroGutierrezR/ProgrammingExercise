<!DOCTYPE html>
<html lang="en">
<head>

<title>Programming Exercise</title>

<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<meta name="description" content="">
<meta name="keywords" content="">
<meta name="author" content="">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<!-- <script src="https://code.jquery.com/jquery-3.5.1.js"></script> -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">


<link rel="stylesheet" href="../assets/css/bootstrap.min.css">
<link rel="stylesheet" href="../assets/css/font-awesome.min.css">
<link rel="stylesheet" href="../assets/css/aos.css">

<!-- MAIN CSS -->
<link rel="stylesheet" href="../assets/css/tooplate-gymso-style.css">
<link rel="stylesheet" href="../assets/css/home.css">
<link rel="stylesheet"
	href="https://unpkg.com/bootstrap-table@1.19.1/dist/bootstrap-table.min.css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"
	integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
	crossorigin="anonymous"></script>

<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
	crossorigin="anonymous"></script>
<script
	src="https://unpkg.com/bootstrap-table@1.19.1/dist/bootstrap-table.min.js"></script>
<script
	src="https://unpkg.com/bootstrap-table@1.19.1/dist/bootstrap-table-locale-all.min.js"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
</head>
<body data-spy="scroll" data-target="#navbarNav" data-offset="50"
	id="top">
	<!-- MENU BAR -->
	<nav class="navbar navbar-expand-lg fixed-top">
		<div class="container">

			<a class="navbar-brand" href="#top">Bienvenido</a>

			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarNav" aria-controls="navbarNav"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav ml-lg-auto">

					<li class="nav-item"><a href="#requestSection"
						title="click para ver productos" class="nav-link smoothScroll"
						id="listarProductos"></a></li>
				</ul>
			</div>
		</div>
	</nav>


	<!-- HERO -->
	<section
		class="hero d-flex flex-column justify-content-center align-items-center"
		id="home">

		<div class="bg-overlay"></div>

		<div class="container">
			<div class="row">
				<div class="col-lg-8 col-md-10 mx-auto col-12">
					<div class="hero-text mt-5 text-center">
						<h1 class="text-white" data-aos="fade-up" data-aos-delay="500">Programming
							Exercise</h1>
						<h6 data-aos="fade-up" data-aos-delay="300">For Dynae.tech</h6>

						<a href="#requestSection" type="button" class="btn btn-danger mt-5 text-white" data-aos="fade-up" data-aos-delay="400">Consultar
							Api</a>

					</div>
				</div>
			</div>
		</div>
	</section>

	<!-- Form consulta Api -->
	<section class="about section" id="requestSection">
		<div class="container">
			<div class="row">
				<h2 class="mb-3 text-dark" data-aos="fade-up">Consulte a Api</h2>
			</div>
		</div>
		<div class="container my-5" data-aos="fade-up">
			<form class="needs-validation" id="form" novalidate>
				<div class=form-row>
					<div class="col-md-4">
						<div class="form-group">
							<label for="idTxtAgregarDescripcion">Ingrese Fecha
								Inicial</label>
							<div class="form-inline">
								<input type="date" id="dateInicial" class="form-control"
									required>
								<div class="valid-feedback">Correcto!</div>
								<div class="invalid-feedback">Debe ingresar una fecha
									válida</div>
							</div>
							<div class="form-inline">
								<input step="1" type="time" id="timeInicial"
									class="form-control" required>
								<div class="valid-feedback">Correcto!</div>
								<div class="invalid-feedback">Debe ingresar una hora
									válida</div>
							</div>
						</div>
					</div>
					<div class="col-md-4">
						<div class="form-group">
							<label for="idTxtAgregarDescripcion">Ingrese Fecha Final</label>
							<div class="form-inline">
								<input type="date" id="dateFinal" class="form-control" required>
								<div class="valid-feedback">Correcto!</div>
								<div class="invalid-feedback">Debe ingresar una fecha
									válida</div>
							</div>
							<div class="form-inline">
								<input step="1" type="time" id="timeFinal" class="form-control"
									required>
								<div class="valid-feedback">Correcto!</div>
								<div class="invalid-feedback">Debe ingresar una hora
									válida</div>
							</div>
						</div>
					</div>
					<div class="col-md-4">
						<div class="form-group">
							<label for="idTxtAgregarDescripcion">Ingrese °C</label>
							<div class="form-inline">
								<input type="number" id="degrees" class="form-control" required>
								<div class="valid-feedback">Correcto!</div>
								<div class="invalid-feedback">Debe ingresar un número
									válido</div>
							</div>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button disabled id="requestBtn" type="button"
						class="btn btn-danger">Consultar</button>
				</div>
			</form>
		</div>
		<div class="container" data-aos="fade-up">
			<h2 class="mb-5 text-dark">Resultado:</h2>
			<h6 class="mb-3 text-danger">
				Temperatura mínima: <span class="text-dark" id="writeMinMagnitude"></span>
			</h6>
			<h6 class="mb-3 text-danger">
				Temperatura máxima: <span class="text-dark" id="writeMaxMagnitude"></span>
			</h6>
			<h6 class="mb-3 text-danger">
				Cantidad de segundos: <span class="text-dark" id="writeSeconds"></span>
			</h6>
		</div>
	</section>

	<div id="loading-screen" style="display: none">
		<img src="../assets/images/spinning-circles.svg">
	</div>

	<!-- SCRIPTS -->
	<script src="../assets/js/aos.js"></script>
	<script src="../assets/js/smoothscroll.js"></script>
	<script src="../assets/js/custom.js"></script>
	<script src="../assets/js/app.js"></script>
</body>
</html>