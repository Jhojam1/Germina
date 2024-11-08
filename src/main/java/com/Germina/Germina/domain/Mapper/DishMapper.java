package com.Germina.Germina.domain.Mapper;


import com.Germina.Germina.domain.Dtos.DishDTO;
import com.Germina.Germina.persistence.entities.Dish;

public class DishMapper {

    public static Dish toEntity(DishDTO dishDTO) {
        Dish dish = new Dish();
        dish.setId(dishDTO.getId());
        dish.setName(dishDTO.getName());
        dish.setDescription(dishDTO.getDescription());
        dish.setPrice(dishDTO.getPrice());
        dish.setState(dishDTO.getState());
        dish.setAmount(dishDTO.getAmount());
        dish.setMaxDailyAmount(dishDTO.getMaxDailyAmount());
        dish.setOrdersToday(dishDTO.getOrdersToday());
        dish.setLastUpdatedDate(dishDTO.getLastUpdatedDate());
        return dish;
    }

    public static DishDTO toDto(Dish dish) {
        DishDTO dishDTO = new DishDTO();
        dishDTO.setId(dish.getId());
        dishDTO.setName(dish.getName());
        dishDTO.setDescription(dish.getDescription());
        dishDTO.setPrice(dish.getPrice());
        dishDTO.setState(dish.getState());
        dishDTO.setAmount(dish.getAmount());
        dishDTO.setMaxDailyAmount(dish.getMaxDailyAmount());
        dishDTO.setOrdersToday(dish.getOrdersToday());
        dishDTO.setLastUpdatedDate(dish.getLastUpdatedDate());
        return dishDTO;
    }
}
