package com.vskp.springcloud.messagingapp.gateway.topics;

import com.vskp.springcloud.messagingapp.utilities.ITopicPublish;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.SubscribableChannel;

public interface IOrderPublish extends ITopicPublish {

    String ORDER_PUBLISH = "order_publish";

    @Output(ORDER_PUBLISH)
    SubscribableChannel publish();
}
