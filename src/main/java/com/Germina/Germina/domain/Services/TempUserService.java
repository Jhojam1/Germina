package com.Germina.Germina.domain.Services;

import com.Germina.Germina.domain.Dtos.TempUserDTO;
import com.Germina.Germina.domain.Mapper.TempUserMapper;
import com.Germina.Germina.persistence.entities.TempUser;
import com.Germina.Germina.persistence.repositories.TempUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TempUserService {

    @Autowired
    private TempUserRepository tempUserRepository;

    /**
     * Obtener todos los Usuarios Temporales.
     */
    public List<TempUserDTO> getAll() {
        return tempUserRepository.findAll().stream()
                .map(TempUserMapper::toDto)
                .collect(Collectors.toList());
    }

    /**
     * Guardar o actualizar un Usuario Temporal.
     */
    public TempUserDTO save(TempUserDTO tempUserDTO) {
        TempUser Tempuser = TempUserMapper.toEntity(tempUserDTO);
        tempUserRepository.save(Tempuser);
        return tempUserDTO;
    }

    /**
     * Elimina un Usuario Temporal.
     */
    public void delete(Long id) {
        if (tempUserRepository.existsById(id)) {
            tempUserRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("User not found with id: " + id);
        }
    }
}
