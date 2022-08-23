package com.luv2code.springboot.cruddemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springboot.cruddemo.dao.ClienteDAO;
import com.luv2code.springboot.cruddemo.entity.Cliente;


@Service
public class ClienteServiceImpl implements ClienteService {

	private ClienteDAO clienteDAO;
	
	@Autowired
	//se defien a traves de @Qualifier que se desea implementar 
	public ClienteServiceImpl(@Qualifier("clienteDAOJdbcImpl")ClienteDAO theClienteDAO) {
		clienteDAO = theClienteDAO;
	}
	
	@Override
	@Transactional
	public List<Cliente> findAll() {
		return clienteDAO.findAll();
	}

	@Override
	@Transactional
	public Cliente findById(int theId) {
		return clienteDAO.findById(theId);
	}

	@Override
	@Transactional
	public void save(Cliente theEmployee) {
		clienteDAO.save(theEmployee);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		clienteDAO.deleteById(theId);
	}

}






