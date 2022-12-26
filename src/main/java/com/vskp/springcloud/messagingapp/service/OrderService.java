package com.vskp.springcloud.messagingapp.service;

import com.vskp.springcloud.messagingapp.gateway.topics.IOrderPublish;
import com.vskp.springcloud.messagingapp.model.Order;
import com.vskp.springcloud.messagingapp.utilities.IPublisher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderService {

    @Autowired
    IPublisher publisher;


    Logger logger = LoggerFactory.getLogger(OrderService.class);

    public void sendOrder( Order order ){

        Order order1 = new Order();
        if( order == null ){
            order1.setId("123");
            order1.setName("IPhone");
            order1.setPrice("50000");
        }

        logger.info( "Order details before publishing: {} ", order1 );
        publisher.publish( IOrderPublish.class, order1 );
        logger.info( "Order published successfully ");

    }
}
