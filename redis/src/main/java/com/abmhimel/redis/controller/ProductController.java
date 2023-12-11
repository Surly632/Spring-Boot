package com.abmhimel.redis.controller;


import com.abmhimel.redis.entity.Product;
import com.abmhimel.redis.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/redis/product")
public class ProductController {
    @Autowired
    private ProductRepository repo;

    @PostMapping("/save")
    public ResponseEntity<String> saveProduct(@RequestBody Product p) {
        return repo.save(p);
    }
    @PatchMapping("/update")
    public ResponseEntity<String> update(@RequestBody Product p) {
        return  repo.update(p);
    }
    @PostMapping("/saveAll")
    public ResponseEntity<String> saveAll(@RequestBody List<Product> p) {
        return repo.saveAll(p);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteProduct(@RequestParam(name="id") Integer id) {
        return repo.delete(id);
    }

    @GetMapping("/find")
    public ResponseEntity<Product> findProduct(@RequestParam(name="id") Integer id) {
        return repo.findById(id);
    }

}
