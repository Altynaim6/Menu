package com.example.demo.dto.Menu;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MenuResponse {
    private Long id;
    private String movie_name;
    private String type;
    private String description;
    private Integer rating;
    private String created_date;

}
