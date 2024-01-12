package com.example.demo.dto.Menu;

import com.example.demo.enums.Type;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MenuRequest {
    private Long id;
    private String movie_name;
    private String type;
    private String description;
    private Integer rating;
    private String created_date;

}
