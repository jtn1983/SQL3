package ru.tenilin.sql3.controller;

import org.springframework.web.bind.annotation.*;
import ru.tenilin.sql3.repository.ProductRepository;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/fetch-product")
    @ResponseBody
    public List<String> getByName(@RequestParam String name) {
        return productRepository.getProductName(name);
    }
}
