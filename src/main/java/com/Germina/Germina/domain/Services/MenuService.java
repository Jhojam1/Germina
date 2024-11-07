package com.Germina.Germina.domain.Services;

import com.Germina.Germina.domain.Dtos.MenuDTO;
import com.Germina.Germina.domain.Mapper.MenuMapper;
import com.Germina.Germina.persistence.entities.Menu;
import com.Germina.Germina.persistence.repositories.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MenuService {

    @Autowired
    private MenuRepository menuRepository;

    public List<MenuDTO> getAll() {
        return menuRepository.findAll().stream().map(MenuMapper::toDto).collect(Collectors.toList());
    }

    public MenuDTO save(MenuDTO menuDTO) {
        menuRepository.save(MenuMapper.toEntity(menuDTO));
        return menuDTO;
    }

    public MenuDTO upda(MenuDTO menuDTO) {
        Optional<Menu> existingMenuOptional = menuRepository.findById(menuDTO.getId());
        if (existingMenuOptional.isPresent()) {
            Menu existingMenu = existingMenuOptional.get();
            existingMenu.setDishes(menuDTO.getDishes());
            menuRepository.save(existingMenu);
            return menuDTO;
        } else {
            menuRepository.save(MenuMapper.toEntity(menuDTO));
            return menuDTO;
        }
    }

}
