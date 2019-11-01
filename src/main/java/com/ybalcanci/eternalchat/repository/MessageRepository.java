package com.ybalcanci.eternalchat.repository;

import com.ybalcanci.eternalchat.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
	List<Message> findAllByOrderBySentDateAsc();
	List<Message> findTop20ByOrderBySentDateAsc();
}
