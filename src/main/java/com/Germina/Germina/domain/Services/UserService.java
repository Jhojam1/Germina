package com.Germina.Germina.domain.Services;

import com.Germina.Germina.domain.Dtos.UserDTO;
import com.Germina.Germina.domain.Mapper.UserMapper;
import com.Germina.Germina.persistence.entities.User;
import com.Germina.Germina.persistence.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserDTO> getAll() {
        return userRepository.findAll().stream().map(UserMapper::toDto).collect(Collectors.toList());
    }

    public UserDTO save(UserDTO userDTO) {
        userRepository.save(UserMapper.toEntity(userDTO));
        return userDTO;
    }

    public UserDTO upda(UserDTO userDTO) {
        Optional<User> existingUserOptional = userRepository.findById(userDTO.getId());
        if (existingUserOptional.isPresent()) {
            User existingUser = existingUserOptional.get();
            existingUser.setState(userDTO.getState());
            userRepository.save(existingUser);
            return userDTO;
        } else {
            userRepository.save(UserMapper.toEntity(userDTO));
            return userDTO;
        }
    }

}
