<%@ page import="java.util.*, com.luv2code.web.jdbc.*" %>
<!DOCTYPE html>
<html>

<head>
	<title>Student Tracker App</title>
	
	<link type="text/css" rel="stylesheet" href="css/style.css">
</head>

<%
// get the clientes from the request object (sent by servlet)
	List<Cliente> theClientes = 
			(List<Cliente>) request.getAttribute("CLIENTE_LIST");
%>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>FooBar University</h2>
		</div>
	</div>

	<div id="container">
	
		<div id="content">
		
			<table>
			
				<tr>
					<th>Nombre</th>
					<th>Apellido</th>
					<th>Telefono</th>
				</tr>
				
				<%
								for (Cliente tempCliente : theClientes) {
								%>
				
					<tr>
						<td> <%= tempCliente.getNombre() %> </td>
						<td> <%= tempCliente.getApellido() %> </td>
						<td> <%= tempCliente.getTelefono() %> </td>
					</tr>
				
				<% } %>
				
			</table>
		
		</div>
	
	</div>
</body>


</html>








