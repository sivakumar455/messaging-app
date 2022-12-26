package com.vskp.springcloud.messagingapp.gateway.topics;

import com.vskp.springcloud.messagingapp.model.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class OrderSubscribeEvent {

    Logger logger = LoggerFactory.getLogger(OrderSubscribeEvent.class);

    @StreamListener( IOrderSubscribe.ORDER_SUBSCRIBE )
    public void orderProcessing( @Payload Message<Order> message ){

        logger.info("Event received : {}", message);
        try{
            Order order = message.getPayload();

            logger.info("Order received : {}", order);
            logger.info("Order processed successfully : {}", order);

        }catch ( Exception ex ){

            logger.error("Exception while processing order {}", ex.getMessage() );
        }finally {

            Acknowledgment ack = message.getHeaders().get(KafkaHeaders.ACKNOWLEDGMENT, Acknowledgment.class );
            if( ack != null ){
                ack.acknowledge();
            }
        }

    }
}
