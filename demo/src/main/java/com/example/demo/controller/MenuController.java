package com.example.demo.controller;

import com.example.demo.dto.Menu.MenuRequest;
import com.example.demo.dto.Menu.MenuResponse;
import com.example.demo.service.MenuService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/menu")
public class MenuController {
    private final MenuService menuService;

    @GetMapping("/{id}")
    public MenuResponse getById(@PathVariable Long id){
        return menuService.getById(id);
    }

    @PostMapping("/add")
    public void addMenu(@RequestBody MenuRequest menuRequest){
        menuService.addMenu(menuRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteMenu(@PathVariable Long id){
        menuService.deleteById(id);
    }

    @PutMapping("/update/{id}")
    public void updateMenu(@PathVariable Long id, @RequestBody MenuRequest menuRequest){
        menuService.updateById(id, menuRequest);
    }




}