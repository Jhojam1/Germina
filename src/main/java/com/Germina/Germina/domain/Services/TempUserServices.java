package com.Germina.Germina.domain.Services;

import com.Germina.Germina.domain.Dtos.TempUserDTO;
import com.Germina.Germina.domain.Mapper.TempUserMapper;
import com.Germina.Germina.persistence.repositories.TempUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TempUserServices {

    @Autowired
    private TempUserRepository tempUserRepository;

    public List<TempUserDTO> getAll() {
        return tempUserRepository.findAll().stream().map(TempUserMapper::toDto).collect(Collectors.toList());
    }

    public TempUserDTO save(TempUserDTO tempUserDTO) {
        tempUserRepository.save(TempUserMapper.toEntity(tempUserDTO));
        return tempUserDTO;
    }

    public void delete(Long id) {
        if (tempUserRepository.existsById(id)) {
            tempUserRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("User not found with id: " + id);
        }
    }
}
