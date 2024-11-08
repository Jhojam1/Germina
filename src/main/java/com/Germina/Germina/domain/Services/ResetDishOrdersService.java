package com.Germina.Germina.domain.Services;

import com.Germina.Germina.persistence.entities.Dish;
import com.Germina.Germina.persistence.repositories.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ResetDishOrdersService {

    @Autowired
    private DishRepository dishRepository;


    /**
     * Método programado para reiniciar el contador de pedidos diarios a medianoche
     */
    @Scheduled(cron = "0 0 0 * * *") // Ejecuta a medianoche todos los días
    public void resetOrdersDaily() {
        // Reiniciar el contador de pedidos diarios para todos los platos
        Iterable<Dish> allDishes = dishRepository.findAll();
        for (Dish dish : allDishes) {
            // Solo reiniciar si la fecha de última actualización no es la de hoy
            if (!LocalDate.now().equals(dish.getLastUpdatedDate())) {
                dish.setOrdersToday(0L); // Reiniciar contador diario
                dish.setLastUpdatedDate(LocalDate.now()); // Actualizar fecha de última actualización
                dishRepository.save(dish); // Guardar los cambios
            }
        }
    }
}
