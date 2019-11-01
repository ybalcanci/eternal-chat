package com.ybalcanci.eternalchat.controller;

import com.ybalcanci.eternalchat.model.Message;
import com.ybalcanci.eternalchat.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MainController {

	@Autowired
	private MessageRepository messageRepository;

	@GetMapping("/")
	public String home(){
		return "<h1>Welcome!</h1>";
	}

	@GetMapping("/messages")
	public List<Message> messages(){
		return messageRepository.findAll();
	}
}
