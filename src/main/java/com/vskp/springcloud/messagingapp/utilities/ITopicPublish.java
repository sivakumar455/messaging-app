package com.vskp.springcloud.messagingapp.utilities;

import org.springframework.messaging.SubscribableChannel;

public interface ITopicPublish {
    SubscribableChannel publish();
}
