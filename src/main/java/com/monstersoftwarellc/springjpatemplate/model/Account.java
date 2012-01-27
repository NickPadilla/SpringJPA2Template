/**
 * 
 */
package com.monstersoftwarellc.springjpatemplate.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Version;
import javax.validation.Valid;

import com.monstersoftwarellc.springjpatemplate.annotations.FieldMatch;



/**
 * @author Nick(Work)
 *
 */
@Entity
public class Account  {
	
	@Id
	@GeneratedValue
	private Integer id;
	@OneToOne(fetch=FetchType.LAZY,cascade={CascadeType.PERSIST})
	@Valid
	private Person person = new Person();
	@OneToOne(fetch=FetchType.LAZY,cascade={CascadeType.PERSIST})
	@FieldMatch(fieldToMatchOn="passwordVerify", fieldsToMatch="password", message = "{FieldMatch.account.password}")
	@Valid
	private AccountLogin login = new AccountLogin();
	@Version
	private int version;

	/**
	 * @return
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return
	 */
	public Person getPerson() {
		return person;
	}

	/**
	 * @param person
	 */
	public void setPerson(Person user) {
		this.person = user;
	}

	/**
	 * @return the login
	 */
	public AccountLogin getLogin() {
		return login;
	}

	/**
	 * @param login the login to set
	 */
	public void setLogin(AccountLogin login) {
		this.login = login;
	}

	/**
	 * @return
	 */
	public int getVersion() {
		return version;
	}

	/**
	 * @param version
	 */
	public void setVersion(int version) {
		this.version = version;
	}
}
