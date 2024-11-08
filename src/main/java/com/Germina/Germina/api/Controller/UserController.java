package com.Germina.Germina.api.Controller;

import com.Germina.Germina.domain.Dtos.DishDTO;
import com.Germina.Germina.domain.Dtos.UserDTO;
import com.Germina.Germina.domain.Services.UserService;
import com.Germina.Germina.domain.common.Routes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = Routes.API + Routes.User.User)
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = Routes.User.saveUser )
    public UserDTO save(@RequestBody UserDTO userDTO) {
        return userService.save(userDTO);
    }

    @GetMapping(value = Routes.User.getUser)
    public List<UserDTO> get() {
        return userService.getAll();
    }

    @PutMapping(Routes.User.updateUser + "/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody UserDTO userDTO) {
        Optional<UserDTO> userDTOOptional = userService.findById(id);
        if (userDTOOptional.isPresent()) {
            UserDTO existingUser = userDTOOptional.get();
            existingUser.setState(userDTO.getState());
            existingUser.setFullName(userDTO.getFullName());
            UserDTO updatedRequestDTO = userService.save(existingUser); // Guardar los cambios en la solicitud existente
            return ResponseEntity.ok(updatedRequestDTO);
        }
        return ResponseEntity.notFound().build();
    }
}
