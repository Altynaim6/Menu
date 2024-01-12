package com.example.demo.mapper;

import com.example.demo.dto.Menu.MenuResponse;
import com.example.demo.entites.Menu;

import java.util.List;

public interface MenuMapper {
    MenuResponse toDto(Menu menu);

    List<MenuResponse> toDtoS(List<Menu> all);
}


