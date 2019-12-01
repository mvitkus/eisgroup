<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<title>LB project</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
	$(function() {
		$('#d1 , #d2').datepicker({
			dateFormat : "yy-mm-dd"
		});
	});
</script>
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<script src="../../webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>

</head>
<body>
	<form action="getlist">
		<div class="input-group input-group-sm mb-3">
			<select name="currency" class="form-control"
				aria-label="Sizing example input"
				aria-describedby="inputGroup-sizing-sm">
				<c:forEach items="${valiutos.item}" var="valiutos">
					<option>${valiutos.valiutos_kodas}</option>
				</c:forEach>
			</select>
			<div class="input-group-prepend">
				<span class="input-group-text" id="inputGroup-sizing-sm">Pradžios
					data</span>
			</div>
			<input type="text" name="startdate" class="form-control"
				aria-label="Sizing example input"
				aria-describedby="inputGroup-sizing-sm" id="d1">
			<div class="input-group-prepend">
				<span class="input-group-text" id="inputGroup-sizing-sm">Pabaigos
					data</span>
			</div>
			<input type="text" name="enddate" class="form-control"
				aria-label="Sizing example input"
				aria-describedby="inputGroup-sizing-sm" id="d2">
			<button type="submit" class="btn btn-secondary btn-sm">Generuoti</button>
		</div>
	</form>

	<div class="alert alert-secondary" role="alert">
		Periodo pradžios santykis: ${pirmas} <br> Periodo pabaigos
		santykis: ${paskutinis
		}<br> Santykio pokytis nuo periodo
		pradžios iki pabaigos: ${skaicius }

	</div>
	<table class="table">
		<thead class="thead-dark">
			<tr>
				<th scope="col">Pavadinimas</th>
				<th scope="col">Valiutos kodas</th>
				<th scope="col">Data</th>
				<th scope="col">Santykis</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${items.item }" var="itemai">
				<tr>

					<td>${itemai.pavadinimas}</td>
					<td>${itemai.valiutos_kodas}</td>
					<td>${itemai.data}</td>
					<td>${itemai.santykis}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>