package com.springboot.kafka.connector.kafka;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.springboot.kafka.connector.payload.User;

@Service
public class JsonKafkaProducer {
	private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaProducer.class);
	@Autowired
	private KafkaTemplate<String,User> kafkaTemplate;
	
	public void sendMessage(User data) {
 LOGGER.info(String.format("Message sent -> %s", data.toString()));
 ProducerRecord<String, User> record = new ProducerRecord<>("SpringKafkaJson",data);
 kafkaTemplate.send(record);
	}
}