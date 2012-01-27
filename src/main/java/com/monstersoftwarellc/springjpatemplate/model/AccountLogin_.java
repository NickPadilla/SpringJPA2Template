package com.monstersoftwarellc.springjpatemplate.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2012-01-26T16:45:21.132-0700")
@StaticMetamodel(AccountLogin.class)
public class AccountLogin_ {
	public static volatile SingularAttribute<AccountLogin, Integer> id;
	public static volatile SingularAttribute<AccountLogin, String> username;
	public static volatile SingularAttribute<AccountLogin, String> password;
	public static volatile SingularAttribute<AccountLogin, String> passwordVerify;
	public static volatile SingularAttribute<AccountLogin, Date> lastLoggedIn;
	public static volatile SingularAttribute<AccountLogin, String> lastLoggedInLocation;
	public static volatile SingularAttribute<AccountLogin, Integer> numberOfFailedLoginAttempts;
	public static volatile SingularAttribute<AccountLogin, Integer> version;
}
