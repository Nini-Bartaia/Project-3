package com.GroupProject.ecommerce.backend.service;

import com.GroupProject.ecommerce.backend.model.Cart;
import com.GroupProject.ecommerce.backend.model.Product;
import com.GroupProject.ecommerce.backend.repos.CartRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class CartService {


    private final CartRepo cartRepo;

    private ProductService productService;
    private UserService userService;

    public CartService(ProductService productService, CartRepo cartRepo, UserService userService) {
        this.productService = productService;
        this.cartRepo=cartRepo;
        this.userService=userService;
    }


    public Cart addProduct(Long productId, int quantity){


        Cart cart= new Cart();

       // cart.setProduct(this.productService.getProduct(productId));
        cart.setNumOfpProducts(quantity);
        cart.setUser(this.userService.getUser());

      //  cartList.add(cart.getProduct());
       // cart.setProduct(this.productService.getProducts());

       cart.setProduct(this.productService.getProduct(productId));

       // return cart;

        return cart;

    }

    public List<Cart> getCart(){

       // return cartList;
        return cartRepo.findAll();
    }


}
