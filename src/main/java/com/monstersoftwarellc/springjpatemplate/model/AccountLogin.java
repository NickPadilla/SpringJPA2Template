/**
 * 
 */
package com.monstersoftwarellc.springjpatemplate.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;


/**
 * @author Nick(Work)
 *
 */
@Entity
public class AccountLogin  {

	@Id
	@GeneratedValue
	private Integer id;
	@NotBlank(message="{NotEmpty.account.username}")
	private String username;
	@NotBlank(message="{NotEmpty.account.password}")
    @Size(min=7, message="{Size.account.password}")
	private String password;
	@NotBlank(message="{NotEmpty.account.password}")
    @Size(min=7, message="{Size.account.password}")
	private String passwordVerify;
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastLoggedIn;
	private String lastLoggedInLocation;
	private int numberOfFailedLoginAttempts;	
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
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the passwordVerify
	 */
	public String getPasswordVerify() {
		return passwordVerify;
	}

	/**
	 * @param passwordVerify the passwordVerify to set
	 */
	public void setPasswordVerify(String passwordVerify) {
		this.passwordVerify = passwordVerify;
	}

	/**
	 * @return the lastLoggedIn
	 */
	public Date getLastLoggedIn() {
		return lastLoggedIn;
	}

	/**
	 * @param lastLoggedIn the lastLoggedIn to set
	 */
	public void setLastLoggedIn(Date lastLoggedIn) {
		this.lastLoggedIn = lastLoggedIn;
	}

	/**
	 * @return the lastLoggedInLocation
	 */
	public String getLastLoggedInLocation() {
		return lastLoggedInLocation;
	}

	/**
	 * @param lastLoggedInLocation the lastLoggedInLocation to set
	 */
	public void setLastLoggedInLocation(String lastLoggedInLocation) {
		this.lastLoggedInLocation = lastLoggedInLocation;
	}

	/**
	 * @return the numberOfFailedLoginAttempts
	 */
	public int getNumberOfFailedLoginAttempts() {
		return numberOfFailedLoginAttempts;
	}

	/**
	 * @param numberOfFailedLoginAttempts the numberOfFailedLoginAttempts to set
	 */
	public void setNumberOfFailedLoginAttempts(int numberOfFailedLoginAttempts) {
		this.numberOfFailedLoginAttempts = numberOfFailedLoginAttempts;
	}

	/**
	 * @return the version
	 */
	public int getVersion() {
		return version;
	}

	/**
	 * @param version the version to set
	 */
	public void setVersion(int version) {
		this.version = version;
	}
}
