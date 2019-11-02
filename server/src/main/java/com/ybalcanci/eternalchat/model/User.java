package com.ybalcanci.eternalchat.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="idgen")
	private Long id;

	@Column(unique = true, nullable = false)
	private String username;

	@JsonBackReference
	@OneToMany(mappedBy = "sender", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<Message> messages = new HashSet<>();

	public User(){

	}

	public User(String username) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public Long getId() {
		return id;
	}

	public Set<Message> getMessages() {
		return messages;
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", username='" + username + '\'' +
				'}';
	}
}
