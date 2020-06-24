package com.bookstore.dao;

import java.util.List;

import javax.persistence.EntityManager; //EntityManager is a tool used to manade CRUD like operations in DB
import javax.persistence.Query;

public class JpaDAO<E> {
	
	protected EntityManager entityManager;

	/*Since Entity Manager instance is injected by client code such as DAO classes
	so we Generated constructor using fields option here  */
	
	public JpaDAO(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	public E create(E entity) {
		entityManager.getTransaction().begin();
		
		entityManager.persist(entity); // makes an entity persistent 
		entityManager.flush();  // runs the query on database
		entityManager.refresh(entity);//remove cache
		
		entityManager.getTransaction().commit();
		
		return entity;
	}
	
	public E update(E entity) {
		entityManager.getTransaction().begin();
		
		entity = entityManager.merge(entity);//add new object to existing info 
		entityManager.getTransaction().commit();

		return entity;
		
	}
	
	public E find(Class<E> type,Object id) {
		E entity = entityManager.find(type,id);
		if(entity!=null) {
		entityManager.refresh(entity);
		} 
		return entity;
	}
	
	public void delete(Class<E> type,Object id) {
		entityManager.getTransaction().begin();

		Object referece = entityManager.getReference(type, id); // We called reference method here because delete operatiion makes changes in database and here we want to complete in transaction
		
		entityManager.remove(referece);
		entityManager.getTransaction().commit();

	}
	
	public List<E> findWithNamedQuery(String queryName){
		Query query = entityManager.createNamedQuery(queryName);
		return query.getResultList();
	}
	
	public List<E> findWithNamedQuery(String queryName,String paramName,Object paramValue){
		Query query = entityManager.createNamedQuery(queryName);
		query.setParameter(paramName, paramValue);
		return query.getResultList();
	}
	public long countWithNamedQuery(String queryName){
		Query query = entityManager.createNamedQuery(queryName);
		return (long) query.getSingleResult();
	}
	
}
