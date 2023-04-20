package com.k2s3.service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {
	private final Logger logger = LoggerFactory.getLogger(KafkaConsumerService.class);
	public LocalDateTime localDateTime = LocalDateTime.now();
	public String FileDate = localDateTime.toString();

	@KafkaListener(topics = "test", groupId = "group_id")
	public void consume(String message) throws IOException {

		logger.info(String.format("Message recieved -> %s", message));
		

		// Writes Kafka data to text file for S3
		File myFile = new File("toS3.txt");
		FileWriter s3File = new FileWriter("toS3.txt");
		s3File.write(message);
		s3File.close();
	}
}