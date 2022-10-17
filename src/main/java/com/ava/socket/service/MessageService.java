package com.ava.socket.service;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import com.ava.socket.model.MessageResponse;

@Service
public class MessageService {
	private final SimpMessagingTemplate messagingTemplate;

	public MessageService(SimpMessagingTemplate messagingTemplate) {
		super();
		this.messagingTemplate = messagingTemplate;
	}

	public void notifyFrontend(String message) {

		MessageResponse response = new MessageResponse(message);
		messagingTemplate.convertAndSend("/topic/messages", response);
	}
}
