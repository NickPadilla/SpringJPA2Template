package com.monstersoftwarellc.springjpatemplate.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2012-01-27T11:30:08.375-0700")
@StaticMetamodel(Account.class)
public class Account_ {
	public static volatile SingularAttribute<Account, Integer> id;
	public static volatile SingularAttribute<Account, Person> person;
	public static volatile SingularAttribute<Account, AccountLogin> login;
	public static volatile SingularAttribute<Account, Integer> version;
}
