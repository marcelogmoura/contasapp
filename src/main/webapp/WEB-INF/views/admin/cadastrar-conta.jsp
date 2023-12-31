<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>/cadastrar conta</title>

<link rel="stylesheet" href="../resources/css/bootstrap.min.css"
	type="text/css" />
	

	<style>
	label.error {
		color: #d9534f;
	}
	input.error {
		border: 2px solid #d9534f;
	}
	select.error {
		border: 2px solid #d9534f;
	}
	textarea.error {
		border: 2px solid #d9534f;
	}
	</style>

</head>
<body>

	<!-- componente navbar -->
	<jsp:include page="/WEB-INF/views/admin/components/navbar.jsp"></jsp:include>
	
	<!-- componente messages -->
	<jsp:include page="/WEB-INF/views/admin/components/messages.jsp"></jsp:include>

	<div class="container mt-4">
		<div class="card">
			<div class="card-body">
				<h4>Cadastro de contas</h4>
				<p>Contas a pagar ou receber.</p>
				<hr />
				
				<div class="mb-2">
					<strong>${mensagem}</strong>
				</div>
				
				<form id="formCadastro" action="cadastrar-conta-post" method="post">

					<div class="row mb-2">
						<div class="col-md-6">
							<label>Nome da conta:</label> <input type="text" id="nome"
								name="nome" class="form-control" />
						</div>
						<div class="col-md-3">
							<label>Data da conta:</label> <input type="date" id="data"
								name="data" class="form-control" />
						</div>
						<div class="col-md-3">
							<label>Valor da conta:</label> <input type="text" id="valor"
								name="valor" class="form-control" />
						</div>
					</div>

					<div class="row mb-2">
						<div class="col-md-9">
							<label>Descrição da conta:</label>
							<textarea id="descricao" name="descricao" class="form-control"></textarea>
						</div>
						<div class="col-md-3">
							<label>Tipo de conta:</label> <select id="tipo" name="tipo"
								class="form-select">
								<option value="">Selecione uma opção</option>
								<option value="1">Conta a receber</option>
								<option value="2">Conta a pagar</option>
							</select>
						</div>
					</div>

					<div class="row mb-2">
						<div class="col-md-12">
							<input type="submit" value="Cadastrar" class="btn btn-success" />
							<a href="/contasapp/admin/consultar-conta" class="btn btn-dark">
								Ir para a consulta </a>
						</div>
					</div>

				</form>

			</div>
		</div>
	</div>


	<script src="../resources/js/bootstrap.bundle.min.js"></script>
	<script src="../resources/js/jquery-3.7.0.min.js"></script>
	<script src="../resources/js/jquery.validate.min.js"></script>
	<script src="../resources/js/additional-methods.min.js"></script>
	<script src="../resources/js/messages_pt_BR.min.js"></script>

<script>
		$(document).ready(function() {
			$("#formCadastro").validate({
				rules : {
					"nome" : {
						required : true,
						minlength : 3,
						maxlength : 100
					},
					"data" : {
						required : true
					},
					"valor" : {
						required : true
					},
					"descricao" : {
						required : true,
						minlength : 3,
						maxlength : 250
					},
					"tipo" : {
						required : true
					}
				}
			});
		})
	</script>

	

</body>
</html>