package com.king_ict_task.rest_api.model;


import lombok.Data;

import java.util.List;

@Data
public class Product {
    private int id;
    private String title;
    private String description;
    private List<String> images;
    private float price;
    private String category;
}
