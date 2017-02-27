package com.innocv.exercise.core.dao;

import java.util.List;

import com.innocv.exercise.core.beans.UserBean;

/**
 * User bean dao interface
 * @author General
 *
 */
public interface UserDao {

	/**
	 * <p>Return a list of users existing in system</p>
	 * @return list of users
	 */
	public List<UserBean> getAllUser();
	
	/**
	 * <p>Return user with id is equal than id parameter</p>
	 * @param id
	 * @return user
	 */
	public UserBean getUser(int id);
	
	/**
	 * <p>Create in database an user</p>
	 * @return the created user
	 */
	public UserBean createUser(UserBean user);
	
	/**
	 * <p>Modifiy an user</p>
	 * @param id
	 * @return the modified user
	 */
	public UserBean updateUser(UserBean user);	
	
	/**
	 * <p>Modifiy an user</p>
	 * @param id
	 */
	public void removeUser(int id);
}
