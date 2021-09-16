<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>login</title>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>
<link rel="stylesheet" href="assets/css/css.css" />
</head>
<body>
	<div class="container">

		<div class="row">
			<h1>Login Usuario</h1>
			<form action="/login" method="post">

				<div class=" col-xl-4 col-lg-3 col-md-4 col-sm-6" id="formulario">
					<div class="form-group">
						<label for="Usuario">Usuario</label> <input type="text"
							class="form-control" name="nombreUsuario" id="Usuario">
					</div>

					<div class="form-group">
						<label for="pwd">Password:</label> <input type="password"
							class="form-control" name="password" id="pwd">
					</div>
					<div style="color: red">${error}</div>
					<br>
					<button type="submit" class="btn btn-primary">Ingresar</button>
					<br><br>
				

				</div>
				
			</form>
		</div>
	</div>
	<br>

</body>
</html>