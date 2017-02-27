package com.innocv.exercise.core.beans;

import java.io.Serializable;
import java.util.Date;

/**
 * User bean
 * @author General
 *
 */
public class UserBean implements Serializable {
	private static final long serialVersionUID = -5256479904364596713L;

	/**
	 * <p>Person bean database identifier</p>
	 */
	private int id;
	
	/**
	 * <p>Person firt name</p>
	 */
	private String name;
	
	/**
	 * <p>Person brithdate date</p>
	 */
	private Date birthDate;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
}
