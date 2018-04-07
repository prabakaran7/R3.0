package com.praba.myproject.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.praba.myproject.model.Login;
import com.praba.myproject.model.UserData;
import com.praba.myproject.repository.LoginRepository;

@Service
public class LoginService {

	@Autowired
	private LoginRepository repository;
	public Login doLogin(String userId, String pwd) {
		Login login = new Login();
		Optional<UserData> userData = repository.findByUserIdAndPassword(userId, pwd);
		if(userData.isPresent()) {
			login.setUserId(userData.get().getUserId());
			login.setRole(userData.get().getRole().getRole());
			login.setSuccess(true);
		}
		return login;
		
	}
}
