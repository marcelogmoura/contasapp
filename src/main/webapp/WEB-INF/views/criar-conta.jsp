<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>/criar de conta de usuário</title>


<!-- Folhas de estilo CSS -->
<link rel="stylesheet" href="resources/css/bootstrap.min.css" type="text/css" />

</head>
<body>


	<div
		class="container d-flex justify-content-center align-items-center vh-100">
		<div class="card p-4">

			<h2 class="text-center">/criar Conta de Usuário</h2>
			<p class="text-center">Preencha os campos.</p>

			<h4>${mensagem}</h4>

			<form method="post" action="/contasapp/criar-conta-post">

				<div class="mb-2">
					<label for="nome" class="form-label"> Nome:
						</label> 
						<input
						type="text" 
						class="form-control" 
						id="nome" 
						name="nome"
						placeholder="Digite seu nome">
				</div>

				<div class="mb-2">
					<label for="email" class="form-label"> Email:
					</label> 
						<input
						type="email" 
						class="form-control" 
						id="email" 
						name="email"
						placeholder="seu@email">
				</div>

				<div class="mb-2">
					<label for="senha" class="form-label"> Senha:
						</label> 
						<input
						type="password" 
						class="form-control" 
						id="senha" 
						name="senha"
						placeholder=" * * * * *">
				</div>

				<div class="mb-2">
					<label for="senhaConfirm" class="form-label"> Confirme a senha:
					</label> 
						<input 
						type="password" 
						class="form-control"
						id="senhaConfirm" 
						name="senhaConfirm"
						placeholder=" * * * * *">
				</div>

				<div class="d-grid">
					<button type="submit" class="btn btn-dark">Criar Conta</button>
				</div>

				<div class="d-grid mt-2">
					<a href="/contasapp/" class="btn btn-light"> Já possui conta? Acesse aqui! 
						</a>
				</div>

			</form>
		</div>
	</div>

	<script src="resources/js/bootstrap.bundle.min.js"></script>

</body>
</html>



