package com.Germina.Germina.api.Controller;

import com.Germina.Germina.domain.Dtos.OrderDTO;
import com.Germina.Germina.domain.Services.OrderService;
import com.Germina.Germina.domain.common.Routes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = Routes.API + Routes.Order.Order )
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping(value = Routes.Order.saveOrder )
    public OrderDTO save(@RequestBody OrderDTO orderDTO) {
        return orderService.save(orderDTO);
    }

    @GetMapping(value = Routes.Order.getOrder)
    public List<OrderDTO> get() {
        return orderService.getAll();
    }
}
