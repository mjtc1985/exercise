package com.innocv.exercise;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.innocv.exercise.controllers.beans.ExceptionMessageBean;

@ControllerAdvice 
public class ExceptionHandlingController extends ResponseEntityExceptionHandler {
		
	@ExceptionHandler(Exception.class)
	@ResponseBody 
	public ResponseEntity<ExceptionMessageBean> handleError(HttpServletRequest req, Exception ex) {
		//TODO Don`t return exception message, replace it with a generic message and add message to server log
		return new ResponseEntity<ExceptionMessageBean>(new ExceptionMessageBean(req.getRequestURL().toString(), ex.getMessage()), HttpStatus.OK);
	}
}
