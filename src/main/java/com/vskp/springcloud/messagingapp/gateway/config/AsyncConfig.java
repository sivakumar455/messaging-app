package com.vskp.springcloud.messagingapp.gateway.config;

import com.vskp.springcloud.messagingapp.gateway.topics.IOrderPublish;
import com.vskp.springcloud.messagingapp.gateway.topics.IOrderSubscribe;
import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableBinding({ IOrderPublish.class,
                IOrderSubscribe.class })
public class AsyncConfig {

}
