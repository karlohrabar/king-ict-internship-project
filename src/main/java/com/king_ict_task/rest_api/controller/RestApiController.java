package com.king_ict_task.rest_api.controller;


import com.king_ict_task.rest_api.model.Product;
import com.king_ict_task.rest_api.model.ProductResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@RestController
@RequestMapping("/api")
public class RestApiController {

    @GetMapping("/hello")
    public ResponseEntity<?> showHelloWorld() {
        return new ResponseEntity<String>("Hello world", HttpStatus.OK);
    }

    @GetMapping("/products")
    public ResponseEntity<?> getAllProducts() {
        var restTemplate = new RestTemplate();
        try {
            var response = restTemplate.getForObject("https://dummyjson.com/products", ProductResponse.class);
            assert response != null;
            return new ResponseEntity<List<Product>>(response.getProducts(), HttpStatus.OK);
        }

        catch(Exception e){
            return new ResponseEntity<String>("No products found!", HttpStatus.NOT_FOUND);
        }


    }

    @GetMapping("/product/{id}")
    public ResponseEntity<?> getProductByID(@PathVariable Integer id) {
        var restTemplate = new RestTemplate();
        try {
            var product = restTemplate.getForObject("https://dummyjson.com/products/" + id, Product.class);
            return new ResponseEntity<>(product, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Product not found!", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/product/random")
    public ResponseEntity<?> getRandomProduct(){
        Random random = new Random();
        int min = 1;
        int max = 30;
        int id = random.nextInt((max - min) + 1) + min;

        return getProductByID(id);

    }

    @GetMapping("/product/{category}/{min}/{max}")
    public ResponseEntity<?> findProductsByCategoryAndPriceRange(@PathVariable String category,
                                                                 @PathVariable int min,
                                                                 @PathVariable int max){
        var restTemplate = new RestTemplate();
        try {
            var response = restTemplate.getForObject("https://dummyjson.com/products", ProductResponse.class);
            assert response != null;
            var products = response.findProductsByCategoryAndPriceRange(category, min, max);
            if(products.isEmpty())
                return new ResponseEntity<>("No products found with these parameters!",HttpStatus.NOT_FOUND);
            return new ResponseEntity<>(products,HttpStatus.OK);
        }

        catch(Exception e){
            return new ResponseEntity<String>("No products found!", HttpStatus.NOT_FOUND);
        }

    }


}
