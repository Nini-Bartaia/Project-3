package com.GroupProject.ecommerce.backend.service;

import com.GroupProject.ecommerce.backend.model.Product;
import com.GroupProject.ecommerce.backend.model.User;
import com.GroupProject.ecommerce.backend.repos.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {


    private final ProductRepo productRepo;


    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public Product createProduct(Product productBody){

        return productRepo.save(productBody);


    }
    public Product getProduct(Long index){

       // return products.get(index);

        return productRepo.findById(index).orElseThrow();
    }

    public List<Product> getProducts(){

       // return products;

        return productRepo.findAll();
    }

    public void deleteProduct(Long index) {

       // products.remove(index);

        productRepo.deleteById(index);
    }


}
