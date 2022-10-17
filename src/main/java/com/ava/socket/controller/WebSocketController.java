package com.ava.socket.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

import com.ava.socket.model.Message;
import com.ava.socket.model.MessageResponse;
@Controller
public class WebSocketController {
	@MessageMapping("/message")
	@SendTo("/topic/messages")
	public MessageResponse getMessage(Message message) throws InterruptedException {
		Thread.sleep(1000);
		return new MessageResponse(HtmlUtils.htmlEscape(message.getMessageContent()));
	}

}
