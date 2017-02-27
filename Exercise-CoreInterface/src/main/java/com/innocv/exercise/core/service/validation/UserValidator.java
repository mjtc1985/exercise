package com.innocv.exercise.core.service.validation;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.innocv.exercise.core.beans.UserBean;

@Component
public class UserValidator implements Validator {
	
	@Override
	public boolean supports(Class<?> clazz) {
		return UserBean.class.equals(clazz);
	}		

	@Override
	public void validate(Object target, Errors errors) {
		UserBean user = (UserBean) target;
        if (StringUtils.isEmpty(user.getName())) {
            errors.rejectValue("name", "Name is mandatory");
        }
    
        if (user.getBirthDate() == null) {
            errors.rejectValue("birthDate", "Birthday is mandatory");
        }
	}

}
