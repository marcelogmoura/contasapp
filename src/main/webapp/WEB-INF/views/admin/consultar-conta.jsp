<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>/consultar conta</title>

<link rel="stylesheet" href="../resources/css/bootstrap.min.css"
	type="text/css" />

</head>
<body>

	<!-- componente navbar -->
	<jsp:include page="/WEB-INF/views/admin/components/navbar.jsp"></jsp:include>



	<div class="container mt-4">
		<div class="card">
			<div class="card-body">
				<h4>/consulta de contas</h4>
				<p>Selecione o período.</p>
				<hr />

				<form id="formConsulta">
					<div class="row mb-2">
						<div class="col-md-3">
							<input type="date" id="dataInicio" name="dataInicio"
								class="form-control" />
						</div>
						<div class="col-md-3">
							<input type="date" id="dataFim" name="dataFim"
								class="form-control" />
						</div>
						<div class="col-md-6">
							<input type="submit" value="Pesquisar" class="btn btn-dark" />
						</div>
					</div>
				</form>

				<div class="mt-3 table-responsive">
					<table class="table table-sm">
						<thead>
							<tr>
								<th>Data</th>
								<th>Valor</th>
								<th>Tipo</th>
								<th>Nome da conta</th>
								<th>Operações</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>-</td>
								<td>-</td>
								<td>-</td>
								<td>-</td>
								<td><a href="#" class="btn btn-sm btn-outline-primary">
										Editar </a> <a href="#" class="btn btn-sm btn-outline-danger">
										Excluir </a></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>

	
	<script src="../resources/js/bootstrap.bundle.min.js"></script>
	<script src="../resources/js/jquery-3.7.0.min.js"></script>
	<script src="../resources/js/jquery.validate.min.js"></script>
	<script src="../resources/js/additional-methods.min.js"></script>
	<script src="../resources/js/messages_pt_BR.min.js"></script>
	
	<script>		
		$(document).ready(function(){			
			$("#formConsulta").validate({
				rules: {
					"dataInicio": {
						required: true
					},
					"dataFim": {
						required: true
					}
				}
			});
		})
	</script>
	


</body>
</html>
