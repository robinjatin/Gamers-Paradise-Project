package com.example.springbootmongodb.repository;

import com.example.springbootmongodb.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {

    Product findByName(String name);
}