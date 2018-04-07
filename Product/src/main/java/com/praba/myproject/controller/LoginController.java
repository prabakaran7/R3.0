package com.praba.myproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.praba.myproject.excption.UserException;
import com.praba.myproject.model.Login;
import com.praba.myproject.service.LoginService;

@RestController
public class LoginController {

	@Autowired
	private LoginService service;

	@PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Login> login(@RequestParam("userId") String userId, @RequestParam("password") String pwd) {

		ResponseEntity<Login> result = null;
		Login login = new Login();
		try {
			if (StringUtils.isEmpty(userId) || StringUtils.isEmpty(pwd)) {
				throw new UserException("Invalid Input");
			}
			login = service.doLogin(userId, pwd);
			if (login.isSuccess()) {
				result = ResponseEntity.ok().body(login);
			} else {
				result = ResponseEntity.noContent().build();
			}
		} catch (UserException e) {
			login.setErrMessage(e.getMessage());
			result = ResponseEntity.badRequest().body(login);
		} catch (Exception e) {
			login.setErrMessage(e.getMessage());
			result = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(login);
		}

		return result;
	}
}
