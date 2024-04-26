package com.GroupProject.ecommerce.backend.modelBody;

public class OrderCreationRequest {
    private LoginBody user;
    private Long productId;

    private long quantity;

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public LoginBody getUser() {
        return user;
    }

    public void setUser(LoginBody user) {
        this.user = user;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
}
