<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>/login</title>
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

			<h2 class="text-center">/login</h2>

			<p class="text-center">Preencha os dados abaixo.</p>


			<h4 class="text-danger text-center">${mensagem_erro}</h4>

			<form id="formLogin" action="login-post" method="post">
			
				<div class="mb-2">
					<label for="email" class="form-label"> Email:</label> <input
						type="email" class="form-control" id="email" name="email"
						placeholder="seu@email">
				</div>

				<div class="mb-2">
					<label for="senha" class="form-label"> Senha:</label> <input
						type="password" class="form-control" id="senha" name="senha"
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
					<a href="/contasapp/criar-usuario" class="btn btn-light">
						Não possui usuário? Cadastre-se aqui! </a>
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
			$("#formLogin").validate({
				rules: {
					"email": {
						required: true,
						email : true
					},
					"senha": {
						required: true,
						pattern: /^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{3,}$/
					}
				},
				messages: {
	                	"senha": {
	                	pattern: "A senha deve conter pelo menos 3 caracteres, incluindo letras, números e pelo menos um caractere especial (@, $, !, %, *, ?, &)."
	                }
	            }
			});
		})
	</script>
	



</body>
</html>