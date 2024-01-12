package com.example.demo.entites;


import com.example.demo.enums.Type;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "menu_table")
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String movie_name;
    private String created_date;
    @Enumerated(EnumType.STRING)
    private Type type;
    private Integer rating;
    private String description;

    @OneToMany(cascade = CascadeType.ALL)
    private List<User> users;
}

