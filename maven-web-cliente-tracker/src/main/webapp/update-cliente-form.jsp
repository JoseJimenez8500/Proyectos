<!DOCTYPE html>
<html>

<head>
	<title>Update Cliente</title>

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
		<h3>Update Cliente</h3>
		
		<form action="ClienteControllerServlet" method="GET">
		
			<input type="hidden" name="command" value="UPDATE" />

			<input type="hidden" name="clienteId" value="${THE_CLIENTE.id}" />
			
			<table>
				<tbody>
					<tr>
						<td><label>Nombre:</label></td>
						<td><input type="text" name="nombre" 
								   value="${THE_CLIENTE.nombre}" /></td>
					</tr>

					<tr>
						<td><label>Apellido:</label></td>
						<td><input type="text" name="apellido" 
								   value="${THE_CLIENTE.apellido}" /></td>
					</tr>

					<tr>
						<td><label>Telefono:</label></td>
						<td><input type="text" name="telefono" 
								   value="${THE_CLIENTE.telefono}" /></td>
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
			<a href="ClienteControllerServlet">Back to List</a>
		</p>
	</div>
</body>

</html>











