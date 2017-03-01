package com.innocv.exercise.core.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.innocv.exercise.core.beans.UserBean;

@Component
public class UserRowMapper implements RowMapper<UserBean>{
	
	@Override
	public UserBean mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		UserBean user = new UserBean();
		
		user.setId(resultSet.getInt("id"));
		user.setName(resultSet.getString("name"));
		user.setBirthDate(resultSet.getDate("birthday"));
		
		return user;
	}

}
