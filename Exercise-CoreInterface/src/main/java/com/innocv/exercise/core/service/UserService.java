package com.innocv.exercise.core.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.innocv.exercise.core.beans.UserBean;

/**
 * Users interface
 * @author General
 *
 */
@Service
public interface UserService {

	/**
	 * <p>Return a list of users existing in system</p>
	 * @return list of users
	 */
	public List<UserBean> getAllUsers();
	
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
