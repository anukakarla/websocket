package com.ava.socket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ava.socket.model.Message;
import com.ava.socket.service.MessageService;
@RestController
public class MessageController {
	@Autowired
	private MessageService service;
	
	@PostMapping("/sendmessage")
	public void sendMessage(@RequestBody Message message) {
		service.notifyFrontend(message.getMessageContent());
	}

}
