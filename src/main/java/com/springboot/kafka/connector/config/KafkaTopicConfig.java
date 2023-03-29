package com.springboot.kafka.connector.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {
	
	@Bean
	public NewTopic springkafkaTopic() {
		return TopicBuilder.name("SpringKafka").build();
	}
	
	@Bean
	public NewTopic springkafkaJsonTopic() {
		return TopicBuilder.name("SpringKafkaJson").build();
	}
}
