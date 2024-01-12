package com.example.demo.service.impl;

import com.example.demo.dto.Menu.MenuRequest;
import com.example.demo.dto.Menu.MenuResponse;
import com.example.demo.entites.Menu;
import com.example.demo.enums.Type;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.NotFoundException;
import com.example.demo.mapper.MenuMapper;
import com.example.demo.repositories.MenuRepository;
import com.example.demo.service.MenuService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class MenuServiceImpl implements MenuService {
    private final MenuRepository menuRepository;
    private final MenuMapper menuMapper;

    @Override
    public MenuResponse getById(Long id) {
        Optional<Menu> menu = menuRepository.findById(id);
        if (menu.isEmpty())
            throw new NotFoundException("menu not found with id:" + id + "!", HttpStatus.BAD_REQUEST);
        return menuMapper.toDto(menu.get());
    }

    @Override
    public void addMenu(MenuRequest menuRequest) {
        Menu menu = new Menu();
        menu.setMovie_name(menuRequest.getMovie_name());
        menu.setDescription(menuRequest.getDescription());
        menu.setRating(menuRequest.getRating());
        menu.setCreated_date(LocalDateTime.now().toString());
        if (!containsType(menuRequest.getType())) {
            throw new BadRequestException("no type with name: " + menuRequest.getType() + "!");
        }
        menu.setType(Type.valueOf(menuRequest.getType()));
        menuRepository.save(menu);
    }

    @Override
    public List<MenuResponse> getAll() {
        return menuMapper.toDtoS(menuRepository.findAll());
    }

    @Override
    public void deleteById(Long id) {
        if (menuRepository.findById(id).isEmpty())
            throw new NotFoundException("the menu with id: " + id + " is empty!", HttpStatus.BAD_REQUEST);
        menuRepository.deleteById(id);
    }

    @Override
    public void updateById(Long id, MenuRequest menuRequest) {
        Optional<Menu>  menu = menuRepository.findById(id);
        if (menu.isEmpty())
            throw new NotFoundException("the menu with id: " + id + " is empty!", HttpStatus.BAD_REQUEST);
        menu.get().setMovie_name(menuRequest.getMovie_name());
        menu.get().setDescription(menuRequest.getDescription());
        menu.get().setRating(menuRequest.getRating());
        if (!containsType(menuRequest.getType()))
            throw new BadRequestException("no type with name: " + menuRequest.getType() + "!");
        menu.get().setType(Type.valueOf(menuRequest.getType()));

        menuRepository.save(menu.get());
    }

    private boolean containsType(String type) {
        for (Type type1 : Type.values()) {
            if (type1.name().equalsIgnoreCase(type))
                return true;
        }
        return false;
    }
}