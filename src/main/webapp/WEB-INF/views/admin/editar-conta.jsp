<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>/editar conta</title>


<link rel="stylesheet" href="../resources/css/bootstrap.min.css" type="text/css" />


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
				<h4>Edição de conta</h4>
				<p>Altere os dados da conta selecionada.</p>
				<hr />

				<form id="formEdicao" action="editar-conta-post" method="post">
				
				<input type="hidden" name="id" value="${id}">

					<div class="row mb-2">
						<div class="col-md-6">
							<label>Nome da conta:</label> <input type="text" id="nome"
								name="nome" class="form-control" value="${nome}"/>
						</div>
						<div class="col-md-3">
							<label>Data da conta:</label> <input type="date" id="data"
								name="data" class="form-control" value="${data}"/>
						</div>
						<div class="col-md-3">
							<label>Valor da conta:</label> <input type="text" id="valor"
								name="valor" class="form-control" value="${valor}"/>
						</div>
					</div>

					<div class="row mb-2">
						<div class="col-md-9">
							<label>Descrição da conta:</label>
							<textarea id="descricao" name="descricao" class="form-control" >"${descricao}"</textarea>
						</div>
						<div class="col-md-3">
							<label>Tipo da conta:</label> <select id="tipo" name="tipo"
								class="form-select" ">
								<option value="">Selecione uma opção</option>
								<option value="1"${tipo == 1 ? "selected" : ""}>Conta a receber</option>
								<option value="2"${tipo == 2 ? "selected" : ""}>Conta a pagar</option>
							</select>
						</div>
					</div>

					<div class="row mb-2">
						<div class="col-md-12">
							<input type="submit" value="Salvar Alterações"
								class="btn btn-success" /> <a
								href="/contasapp/admin/consultar-conta"
								class="btn btn-secondary"> Ir para a consulta </a>
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
			$("#formEdicao").validate({
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


