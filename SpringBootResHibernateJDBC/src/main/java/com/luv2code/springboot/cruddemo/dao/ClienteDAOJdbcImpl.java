package com.luv2code.springboot.cruddemo.dao;

import java.sql.*;
import java.util.*;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springboot.cruddemo.entity.Cliente;

@Repository
public class ClienteDAOJdbcImpl implements ClienteDAO {

	@Autowired
	DataSource dataSource;

	@Override
	public List<Cliente> findAll() {

		System.out.println("Implementación DAO con JDBC: " + dataSource);

		List<Cliente> listaClientes = new ArrayList<>();

		try (Connection myConn = dataSource.getConnection();
				Statement myStmt = myConn.createStatement();
				ResultSet myRs = myStmt.executeQuery("select * from cliente");) {

			// process result set
			while (myRs.next()) {

				// se hace la consulta en la tabla 
				int id = myRs.getInt("id");
				String nombre = myRs.getString("nombre");
				String apellido = myRs.getString("apellido");
				String telefono = myRs.getString("telefono");

				Cliente tempCliente = new Cliente(id, nombre, apellido, telefono);

				// se guradan los registros
				listaClientes.add(tempCliente);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaClientes;
	}

	@Override
	public Cliente findById(int theId) {
		System.out.println("Implementación DAO con JDBC: " + dataSource);

		Cliente theCliente = null;
		try (
				// Se crea la conexion a la tabla 
				Connection myConn = dataSource.getConnection();
				// se crea el query para insertar 
				PreparedStatement myStmt = myConn.prepareStatement("select * from cliente where id=?");

		) {
			myStmt.setInt(1, theId);
			
			try(ResultSet myRs = myStmt.executeQuery()){
				
				// se hace una sola consulta a traves del id
				if (myRs.next()) {
					String nombre = myRs.getString("nombre");
					String apellido = myRs.getString("apellido");
					String telefono = myRs.getString("telefono");
					theCliente = new Cliente(theId, nombre, apellido, telefono);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return theCliente;

	}

	@Override
	public void save(Cliente theCliente) {
		System.out.println("Implementación DAO con JDBC: " + dataSource);
		
		if (theCliente.getId()==0) {
		try (
				Connection myConn = dataSource.getConnection();

				// sql para insertar
				PreparedStatement myStmt = myConn.prepareStatement(
						"insert into cliente " + "(nombre, apellido, telefono) " + "values (?, ?, ?)");) {
	
			myStmt.setString(1, theCliente.getNombre());
			myStmt.setString(2, theCliente.getApellido());
			myStmt.setString(3, theCliente.getTelefono());

			myStmt.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		}else {
			try (
	
					Connection myConn = dataSource.getConnection();

					PreparedStatement myStmt = myConn.prepareStatement("update cliente set nombre=?, apellido=?, telefono=? where id=?");) {

				myStmt.setString(1, theCliente.getNombre());
				myStmt.setString(2, theCliente.getApellido());
				myStmt.setString(3, theCliente.getTelefono());
				myStmt.setInt(4, theCliente.getId());

				myStmt.execute();
				//se ejecuta la instruccion para actualizar
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void deleteById(int theId) {
		System.out.println("Implementación DAO con JDBC: " + dataSource);

		try (

				Connection myConn = dataSource.getConnection();
	
				PreparedStatement myStmt = myConn.prepareStatement("delete from cliente where id=?")) {

			myStmt.setInt(1, theId);

			// se ejecuta la instruccion para eliminar
			myStmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
