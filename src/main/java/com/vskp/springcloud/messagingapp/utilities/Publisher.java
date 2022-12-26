package com.vskp.springcloud.messagingapp.utilities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class Publisher implements IPublisher{

    @Autowired
    ApplicationContext applicationContext;

    @Override
    public void publish(Class<? extends ITopicPublish> channel, Object payload) {
        ITopicPublish topic = ( ITopicPublish )this.applicationContext.getBean( channel );
        Message<Object> msg = this.buildMessage(payload);
        topic.publish().send(msg);
    }

    public <T> Message<T> buildMessage( Object payload ){
        return new GenericMessage( payload, new HashMap<>() );
    }

}
