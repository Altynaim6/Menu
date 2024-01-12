package com.example.demo.mapper.impl;

import com.example.demo.dto.Menu.MenuResponse;
import com.example.demo.entites.Menu;
import com.example.demo.mapper.MenuMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MenuMapperImpl implements MenuMapper {
    @Override
    public MenuResponse toDto(Menu menu) {
        MenuResponse menuResponse = new MenuResponse();
        menuResponse.setId(menu.getId());
        menuResponse.setMovie_name(menu.getMovie_name());
        menuResponse.setDescription(menu.getDescription());
        menuResponse.setCreated_date(menu.getCreated_date());
        menuResponse.setRating(menu.getRating());
        menuResponse.setType(menu.getType().name());
        return menuResponse;
    }

    @Override
    public List<MenuResponse> toDtoS(List<Menu> all) {
        List<MenuResponse> menuResponses = new ArrayList<>();
        for (Menu menu: all){
            menuResponses.add(toDto(menu));
        }
        return menuResponses;
    }

}
