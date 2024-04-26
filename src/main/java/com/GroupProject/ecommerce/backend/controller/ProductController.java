package com.GroupProject.ecommerce.backend.controller;

import com.GroupProject.ecommerce.backend.model.Product;
import com.GroupProject.ecommerce.backend.service.ProductService;
import com.GroupProject.ecommerce.backend.service.UserService;
import org.hibernate.validator.constraints.ParameterScriptAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class ProductController {

    private final AuthController authController;
    private final ProductService productService;

    private final UserService userService;

    public ProductController(AuthController authController, ProductService productService, UserService userService) {
        this.authController = authController;
        this.productService = productService;
        this.userService = userService;
    }


//    @PostMapping("/products/create")
//    public Product CreateProduct(Product product){
//
//        if (this.userService.getType()) {
//
//
//            this.productService.createProduct(product);
//
//            return product;
//
//        }else {
//
//            throw new AccessDeniedException("Access denied: You are not an admin");
//        }
//
//
//    }

    //new

    @PostMapping("/products/create")
    public ResponseEntity<Product> createProduct(@RequestBody Product product){

        Product newProduct= productService.createProduct(product);
        return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
    }

//    @GetMapping("/products/get")
//    public List<Product> CreateProduct(){
//
//        if (this.userService.getType()) {
//
//
//            return this.productService.getProducts();
//
//        }else {
//
//            throw new AccessDeniedException("Access denied: You are not an admin");
//        }
//
//
//
//
//    }

    //new
    @GetMapping("/products/getAll")
    public ResponseEntity<List<Product>> getAllProducts(){

        if (this.userService.getType()) {
            List<Product> products = productService.getProducts();
            return new ResponseEntity<>(products, HttpStatus.OK);
        }else{
            throw new AccessDeniedException("Access denied: You are not an admin");
        }
    }

//    @GetMapping("products/get-product/{productIndex}")
//    public Product getProduct(@PathVariable("productIndex") int productIndex)
//    {
//
//        if (this.userService.getType()) {
//
//
//            return productService.getProduct(productIndex);
//
//        }else {
//
//            throw new AccessDeniedException("Access denied: You are not an admin");
//        }
//
//
//
//    }

    //new
    @GetMapping("products/find/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long id ){

        if (this.userService.getType()) {
            Product product = productService.getProduct(id);
            return new ResponseEntity<>(product, HttpStatus.OK);
        }else{
            throw new AccessDeniedException("Access denied: You are not an admin");
        }
    }

//    @PutMapping("products/update-product/{productIndex}")
//    public Product updateProduct(@PathVariable("productIndex") int productIndex, Product product)
//    {
//        if (this.userService.getType()) {
//
//
//            return productService.updateProduct(productIndex, product);
//
//        }else {
//
//            throw new AccessDeniedException("Access denied: You are not an admin");
//        }
//
//
//    }

    //new

    @PutMapping("products/update-product/{productIndex}")
    public ResponseEntity<Product> updateProduct(@PathVariable("productIndex") Long productIndex, Product product){

            Product updatedProduct=productService.getProduct(productIndex);
            updatedProduct.setPrice(product.getPrice());
            updatedProduct.setName(product.getName());
            updatedProduct.setStockQuantity(product.getStockQuantity());

            productService.createProduct(updatedProduct);
            return new ResponseEntity<>(updatedProduct,HttpStatus.OK);


    }

//    @DeleteMapping("products/delete-product/{productIndex}")
//    public void deleteProduct(@PathVariable("productIndex") int index){
//
//        if (this.userService.getType()) {
//
//
//            productService.deleteProduct(index);
//
//        }else {
//
//            throw new AccessDeniedException("Access denied: You are not an admin");
//        }
//
//    }

    @DeleteMapping("products/deleteProduct/{productIndex}")
    public ResponseEntity<?> deleteProduct(@PathVariable("productIndex") Long productIndex){
        productService.deleteProduct(productIndex);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}



