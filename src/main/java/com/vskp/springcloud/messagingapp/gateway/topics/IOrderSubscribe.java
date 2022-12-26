package com.vskp.springcloud.messagingapp.gateway.topics;

import org.hibernate.validator.constraints.ru.INN;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface IOrderSubscribe {

    String ORDER_SUBSCRIBE = "order_subscribe";

    @Input(ORDER_SUBSCRIBE)
    SubscribableChannel subscribe();
}
