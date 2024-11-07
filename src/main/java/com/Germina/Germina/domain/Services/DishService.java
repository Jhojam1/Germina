package com.Germina.Germina.domain.Services;

import com.Germina.Germina.domain.Dtos.DishDTO;
import com.Germina.Germina.domain.Mapper.DishMapper;
import com.Germina.Germina.persistence.entities.Dish;
import com.Germina.Germina.persistence.repositories.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DishService {

    @Autowired
    private DishRepository dishRepository;

    public List<DishDTO> getAll() {
        return dishRepository.findAll().stream().map(DishMapper::toDto).collect(Collectors.toList());
    }

    public DishDTO save(DishDTO dishDTO) {
        dishRepository.save(DishMapper.toEntity(dishDTO));
        return dishDTO;
    }

    public DishDTO upda(DishDTO dishDTO) {
        Optional<Dish> existingDishOptional = dishRepository.findById(dishDTO.getId());
        if (existingDishOptional.isPresent()) {
            Dish existingDish = existingDishOptional.get();
            existingDish.setPrice(dishDTO.getPrice());
            existingDish.setAmount(dishDTO.getAmount());
            existingDish.setDescription(dishDTO.getDescription());
            dishRepository.save(existingDish);
            return dishDTO;
        } else {
            dishRepository.save(DishMapper.toEntity(dishDTO));
            return dishDTO;
        }
    }

}
