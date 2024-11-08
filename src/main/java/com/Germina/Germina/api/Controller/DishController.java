package com.Germina.Germina.api.Controller;

import com.Germina.Germina.domain.Dtos.DishDTO;
import com.Germina.Germina.domain.Dtos.TempUserDTO;
import com.Germina.Germina.domain.Services.DishService;
import com.Germina.Germina.domain.common.Routes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(Routes.API + Routes.Dish.Dish)
public class DishController {

    @Autowired
    private DishService dishService;

    @PostMapping(value = Routes.Dish.saveDish )
    public DishDTO save(@RequestBody DishDTO dishDTO) {
        return dishService.save(dishDTO);
    }

    @GetMapping(value = Routes.Dish.getDish)
    public List<DishDTO> get() {
        return dishService.getAll();
    }

    @PutMapping(Routes.Dish.updateDish)
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody DishDTO dishDTO) {
        Optional<DishDTO> dishDTOOptional = dishService.findById(id);
        if (dishDTOOptional.isPresent()) {
            DishDTO existingDish = dishDTOOptional.get();
            existingDish.setPrice(dishDTO.getPrice());
            existingDish.setName(dishDTO.getName());
            existingDish.setDescription(dishDTO.getDescription());
            existingDish.setAmount(dishDTO.getAmount());
            existingDish.setMaxDailyAmount(dishDTO.getMaxDailyAmount());
            DishDTO updatedRequestDTO = dishService.save(existingDish); // Guardar los cambios en la solicitud existente
            return ResponseEntity.ok(updatedRequestDTO);
        }
        return ResponseEntity.notFound().build();
    }
}
