package com.GroupProject.ecommerce.backend.controller;

import com.GroupProject.ecommerce.backend.model.Cart;
import com.GroupProject.ecommerce.backend.model.Product;
import com.GroupProject.ecommerce.backend.modelBody.LoginResponse;
import com.GroupProject.ecommerce.backend.service.CartService;
import com.GroupProject.ecommerce.backend.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Objects;

@RestController
public class CartController {

    private CartService cartService;

    private UserService userService;


    public CartController(CartService cartService, UserService userService) {
        this.cartService = cartService;
        this.userService = userService;
    }

    @PostMapping("cart/add-product")
    public ResponseEntity<Cart> addProduct(@RequestParam Long productId, @RequestParam int quantity){

        if (this.userService.getType()) {


            throw new AccessDeniedException("Access denied: You are not an user");



        }else {

            Cart cart = this.cartService.addProduct(productId, quantity);

            //return cart;
            return new ResponseEntity<>(cart, HttpStatus.CREATED);
        }

    }


    @GetMapping("cart/get-cart")
    public ResponseEntity<List<Cart>> getCart(){

        if (this.userService.getType()) {


            throw new AccessDeniedException("Access denied: You are not an user");



        }else {

            //return this.cartService.getCart();
            return new ResponseEntity<>(this.cartService.getCart(), HttpStatus.OK);
        }


    }

}
