package com.Germina.Germina.persistence.repositories;

import com.Germina.Germina.persistence.entities.Dish;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DishRepository extends JpaRepository<Dish, Long> {
}
