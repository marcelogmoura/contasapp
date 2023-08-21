<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>/login</title>
<link rel="stylesheet" href="resources/css/bootstrap.min.css" type="text/css" />

</head>
<body>


	<div
		class="container d-flex justify-content-center align-items-center vh-100">
		<div class="card p-4">

			<h2 class="text-center">/acesso ao sistema</h2>

			<p class="text-center">Preencha os dados abaixo.</p>



			<form>
				<div class="mb-2">
					<label for="email" class="form-label"> Email:</label> <input
						type="email" class="form-control" id="email"
						placeholder="seu@email">
				</div>

				<div class="mb-2">
					<label for="senha" class="form-label"> Senha:</label> <input
						type="password" class="form-control" id="senha"
						placeholder=" * * * * * ">
				</div>

				<div class="mb-3 text-end">
					<a href="/contasapp/recuperar-senha"> Esqueci minha senha!
					</a>
				</div>

				<div class="d-grid">
					<button type="submit" class="btn btn-dark">Entrar</button>
				</div>

				<div class="d-grid mt-2">
					<a href="/contasapp/criar-conta" class="btn btn-light">
						Não possui conta? Cadastre-se aqui! </a>
				</div>
			</form>
		</div>
	</div>

	<script src="resources/js/bootstrap.bundle.min.js"></script>


</body>
</html>