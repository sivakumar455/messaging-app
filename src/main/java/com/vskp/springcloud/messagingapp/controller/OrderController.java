package com.vskp.springcloud.messagingapp.controller;

import com.vskp.springcloud.messagingapp.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping("/order")
    public void sendOrder(){
        orderService.sendOrder(null);
    }
}
