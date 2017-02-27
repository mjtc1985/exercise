package com.innocv.exercise.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.innocv.exercise.core.beans.UserBean;
import com.innocv.exercise.core.dao.UserDao;
import com.innocv.exercise.core.service.UserService;
import com.innocv.exercise.core.service.validation.UserValidator;

/**
 * Implementation of UsersFacade interface
 * @author Manuel Talavera
 *
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserValidator validator;
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public List<UserBean> getAllUsers() {
		return this.userDao.getAllUser();
	}

	@Override
	public UserBean getUser(int id) {
		return this.userDao.getUser(id);
	}

	@Override
	public UserBean createUser(UserBean user) {
		return this.userDao.createUser(user);
	}

	@Override
	public UserBean updateUser(UserBean user) {
		return this.userDao.updateUser(user);
	}

	@Override
	public void removeUser(int id) {
		this.userDao.removeUser(id);
	}
}
