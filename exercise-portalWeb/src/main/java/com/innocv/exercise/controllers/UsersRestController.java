package com.innocv.exercise.controllers;

import java.util.List;
import java.util.stream.Collectors;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.innocv.exercise.controllers.beans.ValidationMessageBean;
import com.innocv.exercise.controllers.constants.RestMappingConstants;
import com.innocv.exercise.core.beans.UserBean;
import com.innocv.exercise.core.service.UserService;
import com.innocv.exercise.core.service.validation.UserValidator;

@Validated
@RestController
@RequestMapping(RestMappingConstants.REST_MAPPING_USERS)
public class UsersRestController {

	@Autowired
	private UserValidator userValidator;
	
	@Autowired
	private UserService userService;
	
	/**
	 * <p>Get a complete list of user existing in system</p>
	 * @return list of users
	 */
	@RequestMapping(value="/getAll",method = RequestMethod.GET)
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity<List<UserBean>> getAll(){
		ResponseEntity<List<UserBean>> responseEntity = 
				new ResponseEntity<List<UserBean>>(userService.getAllUsers(), HttpStatus.OK);
		return responseEntity;
	}
	
	@RequestMapping(value="/get/{id}",method = RequestMethod.GET)
	public ResponseEntity<?> get(@PathVariable int id){
		UserBean user = userService.getUser(id);
		if(user != null){
			return new ResponseEntity<UserBean>(user, HttpStatus.OK);
		}else{
			return new ResponseEntity<String>("The user with id " + id + " doesn't exist", HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value="/create",method = RequestMethod.POST)
	public ResponseEntity<?> create(@RequestBody UserBean user, BindingResult bindingResults){
		userValidator.validate(user, bindingResults);
		if (bindingResults.hasErrors()) {
			ValidationMessageBean validationMessage = new ValidationMessageBean();
			validationMessage.setError(
					bindingResults.getFieldErrors().stream().collect(
							Collectors.toMap(FieldError::getField, FieldError::getCode)));
			return new ResponseEntity<ValidationMessageBean>(validationMessage, HttpStatus.BAD_REQUEST);
		}else{
			return new ResponseEntity<UserBean>(userService.createUser(user), HttpStatus.CREATED);
		}
	}
	
	@RequestMapping(value="/update",method = RequestMethod.POST)
	public ResponseEntity<?> update(@RequestBody UserBean user, BindingResult bindingResults){
		userValidator.validate(user, bindingResults);
		if (bindingResults.hasErrors()) {
			ValidationMessageBean validationMessage = new ValidationMessageBean();
			validationMessage.setError(
					bindingResults.getFieldErrors().stream().collect(
							Collectors.toMap(FieldError::getField, FieldError::getCode)));
			return new ResponseEntity<ValidationMessageBean>(validationMessage, HttpStatus.BAD_REQUEST);
		}else{
			return new ResponseEntity<UserBean>(userService.updateUser(user), HttpStatus.CREATED);
		}
	}
	
	@RequestMapping(value="/remove/{id}",method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public void remove(@PathVariable int id){
		userService.removeUser(id);
	}
}
