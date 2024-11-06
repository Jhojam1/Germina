package com.Germina.Germina.persistence.repositories;

import com.Germina.Germina.persistence.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
