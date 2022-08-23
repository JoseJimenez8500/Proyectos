package com.luv2code.springboot.cruddemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springboot.cruddemo.entity.Cliente;

import com.luv2code.springboot.cruddemo.service.ClienteService;

@RestController
@RequestMapping("/api")
public class ClienteRestController {

	private ClienteService clienteService;
	
	@Autowired
	public ClienteRestController(ClienteService theescuelaService) {
		clienteService = theescuelaService;
	}
	
	//se define el path para cada accion 
	@GetMapping("/clientes")//path para seleccionar todos los registros
	public List<Cliente> findAll() {
		return clienteService.findAll();
	}
	
	@GetMapping("/clientes/{clienteId}")//path para seleccionar un solo registro
	public Cliente getCliente(@PathVariable int clienteId) {
		
		Cliente theCliente = clienteService.findById(clienteId);
		
		if (theCliente == null) {
			throw new RuntimeException("Id del cliente no encontrado - " + clienteId);
		}
		
		return theCliente;
	}
	
	@PostMapping("/clientes")//path para añadir un registro
	public Cliente addCliente(@RequestBody Cliente theCliente) {
		
		theCliente.setId(0);
		
		clienteService.save(theCliente);
		
		return theCliente;
	}

	
	@PutMapping("/escuelas")//path para actualizar
	public Cliente updateEscuela(@RequestBody Cliente theCliente) {
		
		clienteService.save(theCliente);
		
		return theCliente;
	}

	
	@DeleteMapping("/clientes/{clienteId}")
	public String deleteEscuela(@PathVariable int clienteId) {
		
		Cliente tempEscuela = clienteService.findById(clienteId);
		
		if (tempEscuela == null) {
			throw new RuntimeException("Id del cliente no encontrado - " + clienteId);
		}
		
		clienteService.deleteById(clienteId);
		
		return "Id del cliente eliminado - " + clienteId;
	}
	
}










