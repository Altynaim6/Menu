package com.example.demo.service;

import com.example.demo.dto.Menu.MenuRequest;
import com.example.demo.dto.Menu.MenuResponse;

import java.util.List;

public interface MenuService {
    MenuResponse getById(Long id);

    void addMenu(MenuRequest menuRequest);

    List<MenuResponse> getAll();

    void deleteById(Long id);

    void updateById(Long id, MenuRequest menuRequest);
}