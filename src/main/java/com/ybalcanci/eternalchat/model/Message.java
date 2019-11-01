package com.ybalcanci.eternalchat.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.sql.Timestamp;

@Entity
@Table(name = "message")
public class Message {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="idgen")
	private Long id;

	@NotBlank
	private String text;

	@CreationTimestamp
	private Timestamp sentDate;

	@JsonIgnore // don't know what this does
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User sender;

	public Message() {
	}

	public Message(@NotBlank String text) {
		this.text = text;
	}

	public Long getId() {
		return id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public User getSender() {
		return sender;
	}

	public void setSender(User sender) {
		this.sender = sender;
	}

	@Override
	public String toString() {
		return "Message{" +
				"id=" + id +
				", text='" + text + '\'' +
				", sentDate=" + sentDate +
				", sender=" + sender +
				'}';
	}
}
