package com.Germina.Germina.domain.Mapper;

import com.Germina.Germina.domain.Dtos.OrderDTO;
import com.Germina.Germina.persistence.entities.Order;

public class OrderMapper {

    public static Order toEntity(OrderDTO orderDTO) {
        Order order = new Order();
        order.setId(orderDTO.getId());
        order.setUser(orderDTO.getUser());
        order.setMenu(orderDTO.getMenu());
        order.setFechaPedido(orderDTO.getFechaPedido());
        return order;
    }

    public static OrderDTO toDto(Order order) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setId(order.getId());
        orderDTO.setUser(order.getUser());
        orderDTO.setMenu(order.getMenu());
        orderDTO.setFechaPedido(order.getFechaPedido());
        return orderDTO;
    }
}
