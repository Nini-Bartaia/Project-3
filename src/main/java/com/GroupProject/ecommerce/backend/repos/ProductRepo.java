package com.GroupProject.ecommerce.backend.repos;

import com.GroupProject.ecommerce.backend.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(exported = false)
public interface ProductRepo extends JpaRepository<Product, Long> {


}
