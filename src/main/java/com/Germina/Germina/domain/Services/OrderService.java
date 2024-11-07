package com.Germina.Germina.domain.Services;

import com.Germina.Germina.domain.Dtos.OrderDTO;
import com.Germina.Germina.domain.Mapper.OrderMapper;
import com.Germina.Germina.persistence.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<OrderDTO> getAll() {
        return orderRepository.findAll().stream().map(OrderMapper::toDto).collect(Collectors.toList());
    }

    public OrderDTO save(OrderDTO orderDTO) {
        orderRepository.save(OrderMapper.toEntity(orderDTO));
        return orderDTO;
    }

}
