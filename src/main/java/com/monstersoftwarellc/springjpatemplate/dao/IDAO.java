/**
 * 
 */
package com.monstersoftwarellc.springjpatemplate.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.persistence.metamodel.SingularAttribute;

/**
 * @author nick
 *
 */
public interface IDAO<T> {
	
	/**
	 * @param instance
	 */
	public abstract void persist(T instance);
	
	/**
	 * @param instances
	 */
	public abstract void persistAll(Collection<T> instances);
	
	/**
	 * @param instance
	 */
	public abstract void delete(T instance);
	
	/**
	 * @param instance
	 * @return
	 */
	public abstract T merge(T instance);
	
	/**
	 * @param instance
	 * @return
	 */
	public abstract Collection<T> mergeAll(Collection<T> instance);
	
	/**
	 * @return
	 */
	public abstract Long getCount();
	
	/**
	 * @param record
	 * @return
	 */
	public abstract T getRecordById(Serializable record);
	
	/**
	 * @param attribute
	 * @return
	 */
	public abstract List<T> findAllOrderBy(SingularAttribute<T, ?> attribute) ;
	
}
