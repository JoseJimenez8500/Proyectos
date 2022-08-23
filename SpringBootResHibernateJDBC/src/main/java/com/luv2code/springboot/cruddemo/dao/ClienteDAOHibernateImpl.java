package com.luv2code.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springboot.cruddemo.entity.Cliente;

@Repository
public class ClienteDAOHibernateImpl implements ClienteDAO {

	
	private EntityManager entityManager;
		
	// se configura la inyeccion de dependencias por spring boot
	@Autowired  
	public ClienteDAOHibernateImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	
	@Override
	public List<Cliente> findAll() {

		Session currentSession = entityManager.unwrap(Session.class);
		
		// Se ejecuta una consulta apartir del entity en este caso ClienteDAO
		Query<Cliente> theQuery =
				currentSession.createQuery("from Cliente", Cliente.class); 
		
		// Se alamacenan los registros
		List<Cliente> escuela = theQuery.getResultList();
		
		// se devuelve el resultado		
		return escuela;
	}


	@Override
	public Cliente findById(int theId) {

		Session currentSession = entityManager.unwrap(Session.class);
		
		// obtener un registro a partir del id
		Cliente cliente =
				currentSession.get(Cliente.class, theId);

		return cliente;
	}


	@Override
	public void save(Cliente cliente) {
		
		//se actualiza o se inserta segun sea el caso
		Session currentSession = entityManager.unwrap(Session.class);
		
		currentSession.saveOrUpdate(cliente);
	}


	@Override
	public void deleteById(int theId) {

		Session currentSession = entityManager.unwrap(Session.class);
				
		// se elimina un registro a partir de un id usando el entity
		Query theQuery = 
				currentSession.createQuery(
						"delete from Cliente where id=:clienteId");
		theQuery.setParameter("clienteId", theId);
		
		theQuery.executeUpdate();
	}




}







