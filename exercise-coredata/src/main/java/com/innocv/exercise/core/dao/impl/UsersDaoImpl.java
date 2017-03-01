package com.innocv.exercise.core.dao.impl;

import java.sql.Types;
import java.util.List;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ImportResource;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import com.innocv.exercise.core.beans.UserBean;
import com.innocv.exercise.core.dao.UserDao;

/**
 * Implementation of UserDao interface
 * @author Manuel Talavera
 *
 */
@Repository
@ImportResource("classpath:com/innocv/exercise/core/dao/sql/UserDaoQueries.xml")
public class UsersDaoImpl implements UserDao{
	
	@Autowired
	private RowMapper<UserBean> userRowMapper;
	
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	@Autowired
	@Qualifier("userDaoQueries")
	private Properties sqlQueries;
	
	@Override
	public List<UserBean> getAllUser() {
		String sql = this.sqlQueries.getProperty("user.getAllUser");
		
		return this.jdbcTemplate.query(sql, this.userRowMapper);
	}

	@Override
	public UserBean getUser(int id) {
		String sql = this.sqlQueries.getProperty("user.getUser");
		
		List<UserBean> usersList = null;
		UserBean result = null;
		
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		paramMap.addValue("id", id);

		usersList = this.jdbcTemplate.query(sql, paramMap, this.userRowMapper);
		
		if(usersList.size() > 0){
			result = usersList.get(0);
		}
		
		return result;
	}

	@Override
	public UserBean createUser(UserBean user) {
		String sql = this.sqlQueries.getProperty("user.createUser");
		
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		paramMap.addValue("name", user.getName());
		paramMap.addValue("birthday", user.getBirthDate(), Types.DATE);

		
		GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
		this.jdbcTemplate.update(sql, paramMap, keyHolder);
		
		user.setId(keyHolder.getKey().intValue());
		
		return user;
	}

	@Override
	public UserBean updateUser(UserBean user) {
		String sql = this.sqlQueries.getProperty("user.updateUser");
		
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		paramMap.addValue("id", user.getId(), Types.INTEGER);
		paramMap.addValue("name", user.getName());
		paramMap.addValue("birthday", user.getBirthDate(), Types.DATE);

		this.jdbcTemplate.update(sql, paramMap);
		
		return user;
	}

	@Override
	public void removeUser(int id) {
		String sql = this.sqlQueries.getProperty("user.removeUser");
		
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		paramMap.addValue("id", id, Types.INTEGER);

		this.jdbcTemplate.update(sql, paramMap);
	}
}
