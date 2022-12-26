package com.vskp.springcloud.messagingapp;

import com.vskp.springcloud.messagingapp.gateway.topics.IOrderPublish;
import com.vskp.springcloud.messagingapp.gateway.topics.IOrderSubscribe;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.stream.test.binder.MessageCollector;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

import static org.mockito.Mockito.mock;

@SpringBootTest
class MessagingAppApplicationTests {


	@Autowired
	IOrderPublish publisher;

	@Autowired
	IOrderSubscribe subscribe;

	@Autowired
	MessageCollector messageCollector;

	@Test
	void contextLoads() {
	}


	@Test
	public void testChannels(){

		Message<?> testMsg = MessageBuilder.withPayload("TEsting")
				.setHeader(KafkaHeaders.ACKNOWLEDGMENT, mock(Acknowledgment.class))
				.build();

		subscribe.subscribe().send(testMsg);

		Message<?> msg = messageCollector.forChannel(publisher.publish()).poll();

		System.out.println(msg.getPayload());

	}

}
