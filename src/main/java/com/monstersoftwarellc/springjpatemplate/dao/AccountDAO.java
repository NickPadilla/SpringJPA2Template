/**
 * 
 */
package com.monstersoftwarellc.springjpatemplate.dao;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.monstersoftwarellc.springjpatemplate.model.Account;

/**
 * @author Nick(Work)
 *
 */
@Repository
public class AccountDAO extends AbstractDAO<Account> implements IAccountDAO {

	private static Logger LOG = Logger.getLogger(AccountDAO.class);
	
	/**
	 * @param daoImplClass
	 */
	public AccountDAO() {
		super(Account.class);
	}

	/* (non-Javadoc)
	 * @see com.monstersoftwarellc.springjpatemplate.dao.AbstractDAO#getLog()
	 */
	@Override
	protected Logger getLog() {
		return LOG;
	}
	
}
