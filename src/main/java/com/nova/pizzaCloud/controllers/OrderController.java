package com.nova.pizzaCloud.controllers;

import com.nova.pizzaCloud.config.OrderProps;
import com.nova.pizzaCloud.models.TacoOrder;
import com.nova.pizzaCloud.models.User;
import com.nova.pizzaCloud.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;

import java.time.LocalDateTime;


@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("tacoOrder")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderProps orderProps;

    @GetMapping
    public String ordersForUser(
            @AuthenticationPrincipal User user, Model model) {
        Pageable pageable = PageRequest.of(0, orderProps.getPageSize());
        model.addAttribute("orders",
                orderRepository.findByUserOrderByPlacedAtDesc(user, pageable));
        return "orderList";
    }
    @GetMapping("/current")
    public String orderForm(){
        return "orderForm";
    }

    @PostMapping
    public String processOrder(@Valid TacoOrder order, Errors errors,
                               SessionStatus sessionStatus, @AuthenticationPrincipal User user){
        if(errors.hasErrors()){
            return "orderForm";
        }
        log.info("Order submitted: {}",order);
        order.setPlacedAt(LocalDateTime.now());
        order.setUser(user);
        orderRepository.save(order);
        sessionStatus.setComplete();
        return "redirect:/";
    }

}
