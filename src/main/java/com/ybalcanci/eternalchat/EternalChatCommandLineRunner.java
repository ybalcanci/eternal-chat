package com.ybalcanci.eternalchat;

import com.ybalcanci.eternalchat.model.Message;
import com.ybalcanci.eternalchat.model.User;
import com.ybalcanci.eternalchat.repository.MessageRepository;
import com.ybalcanci.eternalchat.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component
public class EternalChatCommandLineRunner implements CommandLineRunner {

	private final MessageRepository messageRepository;
	private final UserRepository userRepository;

	public EternalChatCommandLineRunner(MessageRepository messageRepository, UserRepository userRepository) {
		this.messageRepository = messageRepository;
		this.userRepository = userRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		User user = new User("ybal");
		Stream.of("sa napyon", "as iyi sen").forEach(text ->{
			Message message = new Message(text);
			message.setSender(user);
			user.getMessages().add(message);
			userRepository.save(user);
			messageRepository.save(message);
		});
		messageRepository.findAll().forEach(System.out::println);
	}
}
