package com.Germina.Germina.domain.Mapper;

import com.Germina.Germina.domain.Dtos.MenuDTO;
import com.Germina.Germina.persistence.entities.Menu;

public class MenuMapper {
    public static Menu toEntity(MenuDTO menuDTO) {
        Menu menu = new Menu();
        menu.setId(menuDTO.getId());
        menu.setDishes(menuDTO.getDishes());
        return menu;
    }

    public static MenuDTO toDto(Menu menu) {
        MenuDTO menuDTO = new MenuDTO();
        menuDTO.setId(menu.getId());
        menuDTO.setDishes(menu.getDishes());
        return menuDTO;
    }
}
