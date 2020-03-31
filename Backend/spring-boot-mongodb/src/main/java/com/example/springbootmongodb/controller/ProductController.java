package com.example.springbootmongodb.controller;

import com.example.springbootmongodb.model.Product;
import com.example.springbootmongodb.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin( origins = "http://localhost:4200")
public class ProductController {
    @Autowired
    private ProductService productService;


    @RequestMapping(method = RequestMethod.GET, value = "/createProduct")
    public String createProduct(@RequestParam String name, @RequestParam String description, @RequestParam int price) {
        Product p = productService.createProduct(name,description,price);
        return p.toString();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/createProduct")
    public String createProduct(@RequestBody Product product) {
        productService.createProduct(product);
        return ("Hey, " + product.getName()  + " you have registered successfully");
    }

    @RequestMapping("/getProduct")
    public Product getProduct(@RequestParam String name) {
        return productService.findByName(name);
    }

    @RequestMapping("/getAllProducts")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @RequestMapping("/updateProduct")
    public String updateProduct(@RequestParam String name, @RequestParam String description, @RequestParam int price) {
        Product p = productService.updateProduct(name,description,price);
        return p.toString();
    }

    @RequestMapping("/deleteProduct")
    public String deleteProduct(@RequestParam String name) {
        productService.deleteProduct(name);
        return "Deleted " + name;
    }

    @RequestMapping("/deleteAllProducts")
    public String deleteAllProducts() {
        productService.deleteAllProducts();
        return "Deleted All Records";
    }
}