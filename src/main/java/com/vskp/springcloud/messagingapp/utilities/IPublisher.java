package com.vskp.springcloud.messagingapp.utilities;

public interface IPublisher {

    void publish( Class<? extends ITopicPublish> channel, Object payload );

}
