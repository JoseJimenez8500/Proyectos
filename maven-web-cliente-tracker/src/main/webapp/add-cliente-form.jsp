<!DOCTYPE html>
<html>

<head>
	<title>Add Cliente</title>

	<link type="text/css" rel="stylesheet" href="css/style.css">
	<link type="text/css" rel="stylesheet" href="css/add-cliente-style.css">	
</head>

<body>
	<div id="wrapper">
		<div id="header">
			<h2>Clientes</h2>
		</div>
	</div>
	
	<div id="container">
		<h3>Add Cliente</h3>
		
		<form action="ClienteControllerServlet" method="GET">
		
			<input type="hidden" name="command" value="ADD" />
			
			<table>
				<tbody>
					<tr>
						<td><label>Nombre:</label></td>
						<td><input type="text" name="nombre" /></td>
					</tr>

					<tr>
						<td><label>Apellido:</label></td>
						<td><input type="text" name="apellido" /></td>
					</tr>

					<tr>
						<td><label>Telefono:</label></td>
						<td><input type="text" name="telefono" /></td>
					</tr>
					
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>
					
				</tbody>
			</table>
		</form>
		
		<div style="clear: both;"></div>
		
		<p>
			<a href="StudentControllerServlet">Back to List</a>
		</p>
	</div>
</body>

</html>











