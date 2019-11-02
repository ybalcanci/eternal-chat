package com.ybalcanci.eternalchat.controller;

import com.ybalcanci.eternalchat.model.Message;
import com.ybalcanci.eternalchat.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:5000"})
public class MainController {

	@Autowired
	private MessageRepository messageRepository;

	@PostMapping
	public Message newMessage(@RequestBody Message newEmployee) {
		System.out.println("New Post Request: " + newEmployee);
		return messageRepository.save(newEmployee);
	}

	@GetMapping
	public List<Message> messages(){
		return messageRepository.findAll();
	}
}
