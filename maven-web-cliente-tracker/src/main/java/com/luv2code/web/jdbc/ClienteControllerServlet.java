package com.luv2code.web.jdbc;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;


@WebServlet("/ClienteControllerServlet")
public class ClienteControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ClienteDbUtil clienteDbUtil;
	
	@Resource(name="jdbc/web_student_tracker")
	private DataSource dataSource;
	
	@Override
	public void init() throws ServletException {
		super.init();
				
		try {
			clienteDbUtil = new ClienteDbUtil(dataSource);
		}
		catch (Exception exc) {
			throw new ServletException(exc);
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			
			String theCommand = request.getParameter("command");
			
			
			if (theCommand == null) {
				theCommand = "LIST";
			}
			
			
			switch (theCommand) {
			
			case "LIST":
				listClientes(request, response);
				break;
				
			case "ADD":
				addCliente(request, response);
				break;
				
			case "LOAD":
				loadCliente(request, response);
				break;
				
			case "UPDATE":
				updateCliente(request, response);
				break;
			
			case "DELETE":
				deleteCliente(request, response);
				break;
				
			default:
				listClientes(request, response);
			}
				
		}
		catch (Exception exc) {
			throw new ServletException(exc);
		}
		
	}

	private void deleteCliente(HttpServletRequest request, HttpServletResponse response)
		throws Exception {

		
		String theClienteId = request.getParameter("clienteId");
		
		
		clienteDbUtil.deleteCliente(theClienteId);
		
		
		listClientes(request, response);
	}

	private void updateCliente(HttpServletRequest request, HttpServletResponse response)
		throws Exception {

		// read client info from form data
		int id = Integer.parseInt(request.getParameter("clienteId"));
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String telefono = request.getParameter("telefono");
		
		// create a new cliente object
		Cliente theCliente = new Cliente(id, nombre, apellido, telefono);
		
		// perform update on database
		clienteDbUtil.updateCliente(theCliente);
		
		// send them back to the "list clientes" page
		listClientes(request, response);
		
	}

	private void loadCliente(HttpServletRequest request, HttpServletResponse response) 
		throws Exception {

		// read cliente id from form data
		String theClienteId = request.getParameter("clienteId");
		
		// get cliente from database (db util)
		Cliente theCliente = clienteDbUtil.getCliente(theClienteId);
		
		// place student in the request attribute
		request.setAttribute("THE_CLIENTE", theCliente);
		
		// send to jsp page: update-cliente-form.jsp
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("/update-cliente-form.jsp");
		dispatcher.forward(request, response);		
	}

	private void addCliente(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// read student info from form data
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String telefono = request.getParameter("telefono");		
		
		// create a new cliente object
		Cliente theCliente = new Cliente(nombre, apellido, telefono);
		
		// add the cliente to the database
		clienteDbUtil.addCliente(theCliente);
				
		// send back to main page (the student list)
		listClientes(request, response);
	}

	private void listClientes(HttpServletRequest request, HttpServletResponse response) 
		throws Exception {

		// get clientes from db util
		List<Cliente> clientes = clienteDbUtil.getClientes();
		
		// add clientes to the request
		request.setAttribute("CLIENTE_LIST", clientes);
				
		// send to JSP page (view)
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list-clientes.jsp");
		dispatcher.forward(request, response);
	}

}













