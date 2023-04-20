// https://howtodoinjava.com/kafka/spring-boot-with-kafka/
// https://www.baeldung.com/aws-s3-java
//
// bin\windows\zookeeper-server-start.bat config\zookeeper.properties
// bin\windows\kafka-server-start.bat .\config\server.properties
// bin\windows\kafka-console-consumer.bat --bootstrap-server 0:9092 --topic test --from-beginning
// bin\windows\kafka-topics.bat --bootstrap-server=localhost:9092 --list
//

package com.k2s3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KafkaToS3Application {

	public static void main(String[] args) {
		SpringApplication.run(KafkaToS3Application.class, args);

	}

}