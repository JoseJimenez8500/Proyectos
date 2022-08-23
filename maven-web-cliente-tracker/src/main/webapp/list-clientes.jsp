<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

<head>
	<title>Cliente Tracker App</title>
	
	<link type="text/css" rel="stylesheet" href="css/style.css">
</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>Clientes</h2>
		</div>
	</div>

	<div id="container">
	
		<div id="content">
		
			
			<input type="button" value="Add Cliente" 
				   onclick="window.location.href='add-cliente-form.jsp'; return false;"
				   class="add-cliente-button"
			/>
			
			<table>
			
				<tr>
					<th>Nombre</th>
					<th>Apellido</th>
					<th>Telefono</th>
					<th>Action</th>
				</tr>
				
				<c:forEach var="tempCliente" items="${CLIENTE_LIST}">
					
					<!-- set up a link for each cliente -->
					<c:url var="tempLink" value="ClienteControllerServlet">
						<c:param name="command" value="LOAD" />
						<c:param name="clienteId" value="${tempCliente.id}" />
					</c:url>

					<!--  set up a link to delete a cliente -->
					<c:url var="deleteLink" value="ClienteControllerServlet">
						<c:param name="command" value="DELETE" />
						<c:param name="clienteId" value="${tempCliente.id}" />
					</c:url>
																		
					<tr>
						<td> ${tempCliente.nombre} </td>
						<td> ${tempCliente.apellido} </td>
						<td> ${tempCliente.telefono} </td>
						<td> 
							<a href="${tempLink}">Update</a> 
							 | 
							<a href="${deleteLink}"
							onclick="if (!(confirm('Estas seguro de eliminar este cliente?'))) return false">
							Delete</a>	
						</td>
					</tr>
				
				</c:forEach>
				
			</table>
		
		</div>
	
	</div>
</body>


</html>








