<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<title>LB project</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
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
</head>
<body>
	<form action="getlist">
		<div class="input-group input-group-sm mb-3">
			<div class="input-group-prepend">
				<span class="input-group-text" id="inputGroup-sizing-sm">Valiutos
					kodas</span>
			</div>
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
	<br>

	<div class="alert alert-danger" role="alert">
		<h4 class="alert-heading">Klaida!</h4>
		<p>Šiame pasirinktame periode nėra duomenų.</p>
		<hr>
		<p class="mb-0">Galimai pasirinktas savaitgalis, švenčių diena
			arba neteisingas datos formatas.</p>
	</div>

</body>
</html>