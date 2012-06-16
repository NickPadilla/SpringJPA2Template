/**
 * 
 */
package com.monstersoftwarellc.springjpatemplate.dao;

import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.monstersoftwarellc.springjpatemplate.TestApplicationContext;
import com.monstersoftwarellc.springjpatemplate.model.Account;
import com.monstersoftwarellc.springjpatemplate.model.AccountLogin;
import com.monstersoftwarellc.springjpatemplate.model.Person;

/**
 * @author nicholas
 *
 */
public class AccountDAOTest extends TestApplicationContext {

	@Autowired
	private IAccountDAO accountDAO;
	
	@Test
	@Transactional
	public void save(){
		Account account = new Account();
		AccountLogin login = new AccountLogin();
		login.setNumberOfFailedLoginAttempts(0);
		login.setLastLoggedIn(new Date());
		login.setLastLoggedInLocation("My Loc");
		login.setPassword("password");
		login.setPasswordVerify("password");
		login.setUsername("user");
		Person person = new Person();
		person.setFirstName("Nick");
		person.setLastName("Padilla");
		person.setMiddleName("P.");
		account.setLogin(login);
		account.setPerson(person);
		accountDAO.persist(account);
		Account acc = accountDAO.getRecordById(account.getId());
		assertNotNull(acc);
	}
}
