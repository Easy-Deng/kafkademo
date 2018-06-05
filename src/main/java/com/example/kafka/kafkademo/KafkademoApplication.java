package com.example.kafka.kafkademo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
@EnableAutoConfiguration
@SpringBootApplication
public class KafkademoApplication {


	@Autowired
	private KafkaTemplate kafkaTemplate;

	@RequestMapping(value = "/send")
	@ResponseBody
	public void send(){
		Date date = new Date();
		System.out.println("发送的数据是:"+date.toString());
		kafkaTemplate.send("kafka_test", date.toString());
	}

	public static void main(String[] args) {
		SpringApplication.run(KafkademoApplication.class, args);
	}
}
