/**
 * 
 */
package com.monstersoftwarellc.springjpatemplate.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.SingularAttribute;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author nick
 *
 */
@Repository
public abstract class AbstractDAO<T> implements IDAO<T> {

	@PersistenceContext
	protected EntityManager entityManager;

	private final Class<T> daoImplClass;


	/**
	 * Used to store class type for generic type.
	 * @param returnedClass the Class of the concrete Type.
	 */
	protected AbstractDAO(Class<T> daoImplClass) {
		this.daoImplClass = daoImplClass;
	}

	/**
	 * Should return the Log object to be used during execution. 
	 * For performance reasons this should reference a static Log of the implementing class. 
	 * @return
	 */
	protected abstract Logger getLog();


	protected Class<T> getDaoImplClass() {
		return daoImplClass;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	/* (non-Javadoc)
	 * @see com.monstersoftwarellc.goldrush.dao.IDAO#persist(java.lang.Object)
	 */
	@Override
	@Transactional
	public void persist(T instance) {
		if(getLog().isDebugEnabled()){
			getLog().debug("persisting "+daoImplClass.getName()+"'s");
		}
		try{
			entityManager.persist(instance);
			entityManager.flush();
			getLog().debug("persist successful");
		}catch (RuntimeException re) {
			getLog().error("persist failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.monstersoftwarellc.goldrush.dao.IDAO#persistAll(java.util.Collection)
	 */
	@Override
	@Transactional
	public void persistAll(Collection<T> instances) {
		if(getLog().isDebugEnabled()){
			getLog().debug("persisting "+daoImplClass.getName()+"'s");
		}
		try{
			for(T instance : instances){
				entityManager.persist(instance);
			}
			entityManager.flush();
			getLog().debug("persist successful");
		}catch (RuntimeException re) {
			getLog().error("persist failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.monstersoftwarellc.goldrush.dao.IDAO#delete(java.lang.Object)
	 */
	@Override
	@Transactional
	public void delete(T instance) {
		if(getLog().isDebugEnabled()){
			getLog().debug("deleting "+daoImplClass.getName()+"'s");
		}
		try{
			entityManager.remove(instance);
			entityManager.flush();
			getLog().debug("delete successful");
		}catch (RuntimeException re) {
			getLog().error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.monstersoftwarellc.goldrush.dao.IDAO#merge(java.lang.Object)
	 */
	@Override
	@Transactional
	public T merge(T instance) {
		if(getLog().isDebugEnabled()){
			getLog().debug("merging "+daoImplClass.getName()+"'s");
		}
		try{
			T object = entityManager.merge(instance);
			entityManager.flush();
			getLog().debug("merge successful, result size: " + object.toString());
			return object;
		}catch (RuntimeException re) {
			getLog().error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.monstersoftwarellc.goldrush.dao.IDAO#mergeAll(java.util.Collection)
	 */
	@Override
	@Transactional
	public Collection<T> mergeAll(Collection<T> instances) {
		if(getLog().isDebugEnabled()){
			getLog().debug("merging "+daoImplClass.getName()+"'s");
		}
		try{
			List<T> newList = new ArrayList<T>();
			for(T instance : instances){
				newList.add(entityManager.merge(instance));
			}
			entityManager.flush();
			getLog().debug("merge successful, result size: " + newList.toString());
			return newList;
		}catch (RuntimeException re) {
			getLog().error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.monstersoftwarellc.goldrush.dao.IDAO#getCount()
	 */
	@Override
	public Long getCount() {
		if(getLog().isDebugEnabled()){
			getLog().debug("findAllOrderBy "+daoImplClass.getName()+"'s");
		}
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<T> query = builder.createQuery(daoImplClass);
		Long records = (long) entityManager.createQuery(query).getResultList().size();
		getLog().debug("findAllOrderBy successful, result size: " + records);
		return records;
	}

	/* (non-Javadoc)
	 * @see com.monstersoftwarellc.goldrush.dao.IDAO#getRecordById(java.io.Serializable)
	 */
	@Override
	public T getRecordById(Serializable id) {
		if(getLog().isDebugEnabled()){
			getLog().debug("findAllOrderBy "+daoImplClass.getName()+"'s");
		}
		T record = entityManager.find(daoImplClass, id);
		getLog().debug("getRecordById successful, record: " + record);
		return record;
	}
	
	/* (non-Javadoc)
	 * @see com.monstersoftwarellc.springjpatemplate.dao.IDAO#findAllOrderBy(javax.persistence.metamodel.SingularAttribute)
	 */
	@Override
	public List<T> findAllOrderBy(SingularAttribute<T, ?> attribute) {
		if(getLog().isDebugEnabled()){
			getLog().debug("findAllOrderBy "+getDaoImplClass()+"'s");
		}
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<T> query = builder.createQuery(daoImplClass);
		Root<T> root = query.from(daoImplClass); 
		query.orderBy(builder.asc(root.get(attribute)));
		List<T> records = entityManager.createQuery(query).getResultList();
		getLog().debug("findAllOrderBy successful, result size: " + records.size());
		return records;
	}

}