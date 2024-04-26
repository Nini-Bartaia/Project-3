package com.GroupProject.ecommerce.backend.repos;

import com.GroupProject.ecommerce.backend.model.Order;
import com.GroupProject.ecommerce.backend.model.Product;
import com.GroupProject.ecommerce.backend.modelBody.OrderResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(exported = false)
public interface OrderRepo extends JpaRepository<Order, Long> {
}
