<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>/cadastrar conta</title>

<link rel="stylesheet" href="../resources/css/bootstrap.min.css"
	type="text/css" />

</head>
<body>

	<!-- componente navbar -->
	<jsp:include page="/WEB-INF/views/admin/components/navbar.jsp"></jsp:include>

	<div class="container mt-4">
		<div class="card">
			<div class="card-body">
				<h4>Cadastro de contas</h4>
				<p>Faça o cadastro de suas contas a receber ou a pagar.</p>
				<hr />

				<form>

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
							<input type="submit" value="Realizar Cadastro"
								class="btn btn-success" /> <a
								href="/contasapp/admin/consultar-contas"
								class="btn btn-dark"> Ir para a consulta </a>
						</div>
					</div>

				</form>

			</div>
		</div>
	</div>



	<script src="../resources/js/bootstrap.bundle.min.js"></script>

</body>
</html>