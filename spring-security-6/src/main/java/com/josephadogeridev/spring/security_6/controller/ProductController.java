package com.josephadogeridev.spring.security_6.controller;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {


    private record Product(
            Integer productId,
            String productName,
            double price
    ){ }

    List<Product> products = new ArrayList<>(
            List.of(
                new Product(1,"iPhone",250.99),
                new Product(2,"samsung",700.99)
            )
    );

    @GetMapping("/{productId}")
    public Product getProduct(int productId) {

        Product productFound = null;
        for (Product product : products) {
            if(product.productId.equals(productId)) {
                productFound = product;
                break;
            }
        }
        return productFound;
    }

    @GetMapping
    public List<Product> getProducts() {

        return products;
    }

    @PostMapping
    public Product saveProduct(@RequestBody Product product) {
        products.add(product);
        return product;
    }

}
