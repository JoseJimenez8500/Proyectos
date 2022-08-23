package com.luv2code.springboot.cruddemo.service;

import java.util.List;


import com.luv2code.springboot.cruddemo.entity.Cliente;

public interface ClienteService {

	public List<Cliente> findAll();
	
	public Cliente findById(int theId);
	
	public void save(Cliente cliente);
	
	public void deleteById(int theId);
	
}
