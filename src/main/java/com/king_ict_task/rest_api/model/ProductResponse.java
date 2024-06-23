package com.king_ict_task.rest_api.model;


import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Data
public class ProductResponse {

    private List<Product> products;

    public List<Product> findProductsByCategoryAndPriceRange(String category,
                                                                      int min,
                                                                      int max){
        var filteredProducts = new ArrayList<Product>();
        for(var product : products){
            if((product.getCategory().equals(category)) && (product.getPrice() >= min) &&(product.getPrice() <= max))
                filteredProducts.add(product);
        }

        return filteredProducts;
    }

    public List<Product> findProductsByTitle(String input){
        var filteredProducts = new ArrayList<Product>();
        for(var product : products){
            if(product.getTitle().toLowerCase().contains(input.toLowerCase()))
                filteredProducts.add(product);
        }

        return filteredProducts;
    }

}
