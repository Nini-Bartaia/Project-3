package com.GroupProject.ecommerce.backend.model;

import com.GroupProject.ecommerce.backend.service.ProductService;
import com.GroupProject.ecommerce.backend.service.UserService;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    private String status;
    private long quantity;
    private double price;

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {


        this.user= user;
    }

    public void setProduct(Product product){

       this.product= product;

    }
    public Product getProduct(){

        return product;
    }


}
