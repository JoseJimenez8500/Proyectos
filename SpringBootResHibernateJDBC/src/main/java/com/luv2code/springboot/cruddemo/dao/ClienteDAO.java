package com.luv2code.springboot.cruddemo.dao;

import java.util.List;


import com.luv2code.springboot.cruddemo.entity.Cliente;

//Capa de persistencia
public interface ClienteDAO {   

	List<Cliente> findAll();
	
	Cliente findById(int theId);
	
	void save(Cliente cliente);
	
	void deleteById(int theId);
	
}
