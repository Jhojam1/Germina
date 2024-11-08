package com.Germina.Germina.domain.Services;

import com.Germina.Germina.domain.Dtos.DishDTO;
import com.Germina.Germina.domain.Mapper.DishMapper;
import com.Germina.Germina.persistence.entities.Dish;
import com.Germina.Germina.persistence.repositories.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DishService {

    @Autowired
    private DishRepository dishRepository;

    /**
     * Obtener todos los platos.
     */
    public List<DishDTO> getAll() {
        return dishRepository.findAll().stream()
                .map(DishMapper::toDto)
                .collect(Collectors.toList());
    }

    /**
     * Guardar o actualizar un plato.
     */
    public DishDTO save(DishDTO dishDTO) {
        Dish dish = DishMapper.toEntity(dishDTO);
        dishRepository.save(dish);
        return dishDTO;
    }

    /**
     * Actualizar las propiedades de un plato, como precio, cantidad máxima diaria, descripción.
     */
    public DishDTO updateDish(DishDTO dishDTO) {
        Optional<Dish> existingDishOptional = dishRepository.findById(dishDTO.getId());
        if (existingDishOptional.isPresent()) {
            Dish existingDish = existingDishOptional.get();
            existingDish.setName(dishDTO.getName());
            existingDish.setPrice(dishDTO.getPrice());
            existingDish.setAmount(dishDTO.getAmount());
            existingDish.setDescription(dishDTO.getDescription());
            existingDish.setMaxDailyAmount(dishDTO.getMaxDailyAmount()); // Actualizar límite diario
            dishRepository.save(existingDish);
            return dishDTO;
        } else {
            throw new IllegalArgumentException("Plato no encontrado.");
        }
    }

    /**
     * Reiniciar el contador de pedidos diarios de todos los platos al inicio de cada día.
     * No modifica el estado de los platos.
     */
    public void resetDailyOrders() {
        List<Dish> dishes = dishRepository.findAll();
        for (Dish dish : dishes) {
            if (!LocalDate.now().equals(dish.getLastUpdatedDate())) {
                dish.setOrdersToday(0L); // Reiniciar solo el contador
                dish.setLastUpdatedDate(LocalDate.now()); // Actualizar la fecha de reinicio
                dishRepository.save(dish);
            }
        }
    }

    /**
     * Cambiar el estado de disponibilidad de un plato.
     */
    public void setDishAvailability(Long dishId, String state) {
        Optional<Dish> dishOptional = dishRepository.findById(dishId);
        if (dishOptional.isPresent()) {
            Dish dish = dishOptional.get();
            dish.setState(state);
            dishRepository.save(dish);
        } else {
            throw new IllegalArgumentException("Plato no encontrado.");
        }
    }

    public Optional<DishDTO> findById(Long id) {
        return dishRepository.findById(id).map(DishMapper::toDto);
    }
}
