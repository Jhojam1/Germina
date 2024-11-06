package com.Germina.Germina.domain.Mapper;

import com.Germina.Germina.domain.Dtos.UserDTO;
import com.Germina.Germina.persistence.entities.User;

public class UserMapper {

    public static User toEntity(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setFullName(userDTO.getFullName());
        user.setNumberIdentification(userDTO.getNumberIdentification());
        user.setMail(userDTO.getMail());
        user.setState(userDTO.getState());
        return user;
    }

    public static UserDTO toDto(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setFullName(user.getFullName());
        userDTO.setNumberIdentification(user.getNumberIdentification());
        userDTO.setMail(user.getMail());
        userDTO.setState(user.getState());
        return userDTO;
    }
}
