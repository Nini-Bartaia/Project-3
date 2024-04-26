package com.GroupProject.ecommerce.backend.service;


import com.GroupProject.ecommerce.backend.model.Order;
import com.GroupProject.ecommerce.backend.model.Product;
import com.GroupProject.ecommerce.backend.modelBody.LoginBody;
import com.GroupProject.ecommerce.backend.modelBody.RegisterBody;
import com.GroupProject.ecommerce.backend.repos.OrderRepo;
import com.GroupProject.ecommerce.backend.repos.ProductRepo;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    List<Order> orders = new ArrayList<>();
    private UserService userService;

    private ProductService productService;

    private CartService cartService;
    private RegisterBody registerBody;
    private final OrderRepo orderRepo;



    public OrderService(UserService userService, ProductService productService, CartService cartService,OrderRepo orderRepo) {
        this.userService = userService;
        this.productService = productService;
        this.cartService = cartService;
        this.orderRepo=orderRepo;

    }


    public Order createOrder(LoginBody user, Long ProductId, long quantity){

            Order order= new Order();
            order.setUser(this.userService.login(user));
            order.setProduct(this.productService.getProduct(ProductId));
            order.setQuantity(quantity);


           double budget= order.getUser().getBudget();
          // double budget= registerBody.getBudget();

           if(budget > order.getProduct().getPrice() && order.getProduct().getStockQuantity()>0){

               order.setStatus("Accepted");
               budget=order.getUser().getBudget()-(order.getProduct().getPrice()* order.getQuantity());
               order.setPrice(order.getProduct().getPrice()* order.getQuantity());
               this.userService.login(user).setBudget(budget);


           }else{
               order.setStatus("Failed");
           }

          //  return order;

           return orderRepo.save(order);


    }


//    public List<Order> createOrderCart(LoginBody user) {
//
//        for (int i = 0; i < this.cartService.getCart().size(); i++) {
//
//            //Product product = this.cartService.getCart().get(i);
//
//
//            Order order = new Order();
//            order.setUser(this.userService.login(user));
//            order.setProduct(product);
//
//            double budget = order.getUser().getBudget();
//
//            if (budget > product.getPrice() && product.getStockQuantity() > 0) {
//                order.setStatus("Accepted");
//                budget -= product.getPrice();
//                order.getUser().setBudget(budget);
//                product.setStockQuantity(product.getStockQuantity() - 1); // Decrease stock quantity
//            } else {
//                order.setStatus("Failed");
//            }
//
//            orders.add(order);
//        }
//
//        return orders;
//    }


}