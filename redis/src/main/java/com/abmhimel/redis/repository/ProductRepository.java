package com.abmhimel.redis.repository;

import com.abmhimel.redis.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class ProductRepository {

    private static final String HASH_KEY="product";

    @Autowired
    private RedisTemplate<String, Object> redis;

    public ResponseEntity<String> save(Product product) {
        redis.opsForHash().put(HASH_KEY,product.getId(),product);
        return new ResponseEntity<>("Product Saved!",HttpStatus.ACCEPTED);
    }
    public ResponseEntity<String> saveAll(List<Product> productList) {
       for(Product  p: productList)
           redis.opsForHash().put(HASH_KEY,p.getId(),p);

     return  new ResponseEntity<>("Saved",HttpStatus.OK);
    }

    public ResponseEntity<String> update(Product p) {
        var product = (Product) redis.opsForHash().get(HASH_KEY,p.getId());
        product = p;
        redis.opsForHash().put(HASH_KEY,product.getId(),product);
        return new ResponseEntity<>("Product Updated!!!",HttpStatus.OK);
    }

    public ResponseEntity<String> delete(Integer id) {
        redis.opsForHash().delete(HASH_KEY,id);
        String responseBody = "Product deleted with id: "+id;
        return new ResponseEntity<>(responseBody,HttpStatus.NO_CONTENT);
    }
    public ResponseEntity<Product> findById(Integer id) {
        Product p = (Product) redis.opsForHash().get(HASH_KEY,id);
        return new ResponseEntity<>(p,HttpStatus.OK);
    }

}
