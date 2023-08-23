<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>/recuperar senha</title>
<link rel="stylesheet" href="resources/css/bootstrap.min.css" type="text/css" />

<!-- estilo CSS para as mensagens de erro de validação -->
<style>
	label.error { color: #d9534f; }
	input.error { border: 2px solid #d9534f; }
</style>


</head>
<body>

			<div class="row mt-5">
			<div class="col-md-4 offset-4">
		    <div class="card p-4">


			<h2 class="text-center">/esqueci minha senha</h2>
			<p class="text-center">Informe os dados para recuperar a senha.</p>

			<form id="formRecuperarSenha" action="recuperar-senha-post" method="post">

				<div class="mb-2">
					<label for="email" class="form-label"> Email:</label> <input
						type="email" class="form-control" id="email" name="email"
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
	</div>

	<script src="resources/js/bootstrap.bundle.min.js"></script>
	<script src="resources/js/jquery-3.7.0.min.js"></script>
	<script src="resources/js/jquery.validate.min.js"></script>
	<script src="resources/js/additional-methods.min.js"></script>
	<script src="resources/js/messages_pt_BR.min.js"></script>
	
	
	<script>
		$(document).ready(function(){
			$("#formRecuperarSenha").validate({
				rules: {
					"email": {
						required: true,
						email : true
					}
				}
			});
		})
	</script>
	
	

</body>
</html>


