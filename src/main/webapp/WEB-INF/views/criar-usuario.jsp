<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>/criar de conta de usuário</title>


<!-- Folhas de estilo CSS -->
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

			<h2 class="text-center">/criar conta de usuário</h2>
			<p class="text-center">Preencha os campos abaixo.</p>

			<h4>${mensagem}</h4>

			<form id="formCriarUsuario" method="post" action="/contasapp/criar-usuario-post">

				<div class="mb-2">
					<label for="nome" class="form-label">Nome:</label> 
						<form:input
						path="dto.nome"
						type="text" 
						class="form-control" 
						id="nome" 
						name="nome"
						placeholder="Digite seu nome" />
				</div>

				<div class="mb-2">
					<label for="email" class="form-label"> Email:
					</label> 
						<form:input
						path="dto.email"
						type="email" 
						class="form-control" 
						id="email" 
						name="email"
						placeholder="seu@email" />
				</div>

				<div class="mb-2">
					<label for="senha" class="form-label"> Senha:
						</label> 
						<form:input
						path="dto.senha"
						type="password" 
						class="form-control" 
						id="senha" 
						name="senha"
						placeholder=" * * * * *" />
				</div>

				<div class="mb-2">
					<label for="senhaConfirm" class="form-label"> Confirme a senha:
					</label> 
						<input 
						type="password" 
						class="form-control"
						id="senhaConfirm" 
						name="senhaConfirm"
						placeholder=" * * * * *" />
				</div>

				<div class="d-grid">
					<button type="submit" class="btn btn-dark">Criar usuário</button>
				</div>

				<div class="d-grid mt-2">
					<a href="/contasapp/" class="btn btn-light"> Já possui conta? Acesse aqui! 
						</a>
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
			$("#formCriarUsuario").validate({
				rules: {
					"nome": {
						required: true,
						minlength: 3,
						maxlength: 100
					},
					"email": {
						required: true,
						email : true
					},
					"senha": {
						required: true,
						pattern: /^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/
					},
					"senhaConfirm": {
						required: true,
						equalTo: "#senha"
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



