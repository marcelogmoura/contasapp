<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>/recuperar senha</title>
<link rel="stylesheet" href="resources/css/bootstrap.min.css" type="text/css" />

</head>
<body>

	<div
		class="container d-flex justify-content-center align-items-center vh-100">
		<div class="card p-4">

			<h2 class="text-center">Esqueci minha senha</h2>
			<p class="text-center">Informe seus dados para recuperar a senha.</p>

			<form>

				<div class="mb-2">
					<label for="email" class="form-label"> Email:</label> <input
						type="email" class="form-control" id="email"
						placeholder="seu@email">
				</div>

				<div class="d-grid">
					<button type="submit" class="btn btn-dark">
						Recuperar Senha
					</button>
				</div>

				<div class="d-grid mt-2">
					<a href="/contasapp/" class="btn btn-light"> 
					Já possui conta? Acesse aqui! </a>
				</div>

			</form>
		</div>
	</div>

	<script src="resources/js/bootstrap.bundle.min.js"></script>

</body>
</html>