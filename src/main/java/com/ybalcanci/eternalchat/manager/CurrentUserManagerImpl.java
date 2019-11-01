package com.ybalcanci.eternalchat.manager;

import com.ybalcanci.eternalchat.model.User;
import com.ybalcanci.eternalchat.repository.UserRepository;

import javax.faces.bean.SessionScoped;
import javax.inject.Named;

@SessionScoped
@Named(value = "currentUserManager")
public class CurrentUserManagerImpl implements CurrentUserManager {
	private User user;
	private String username;
	private UserRepository userRepository;

	public CurrentUserManagerImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
		this.user = null;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public User getCurrentUser() {
		return user;
	}

	@Override
	public void login() {
		user = userRepository.findByUsername(username);
		if(user == null){
			userRepository.save(new User(username));
		}
	}
}
