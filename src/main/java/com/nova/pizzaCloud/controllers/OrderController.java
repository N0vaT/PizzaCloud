package com.nova.pizzaCloud.controllers;

import com.nova.pizzaCloud.models.TacoOrder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Slf4j
@RequestMapping("/orders")
@Controller
@SessionAttributes("tacoOrder")
public class OrderController {

    @GetMapping("/current")
    public String orderForm(){
        return "orderForm";
    }

    @PostMapping
    public String processOrder(TacoOrder order,
                               SessionStatus sessionStatus){
        log.info("Order submitted: {}",order);
        sessionStatus.setComplete();
        return "redirect:/";
    }
}
