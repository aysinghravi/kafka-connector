package com.springboot.kafka.connector.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.kafka.connector.kafka.JsonKafkaProducer;
import com.springboot.kafka.connector.payload.User;

@RestController 
@RequestMapping("/api/v1/kafka")
public class JsonMessageController {
	
	private  JsonKafkaProducer kafkaProducer;
	
	public JsonMessageController(JsonKafkaProducer kafkaProducer) {
		this.kafkaProducer = kafkaProducer;
	}
	
	@PostMapping("/publishjson")
	public ResponseEntity<String> publish(@RequestBody User user){
		kafkaProducer.sendMessage(user);
		return ResponseEntity.ok("Json message sent");
	}

}
