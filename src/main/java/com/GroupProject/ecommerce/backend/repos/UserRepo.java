package com.GroupProject.ecommerce.backend.repos;

import com.GroupProject.ecommerce.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(exported = false)
public interface UserRepo extends JpaRepository<User, Long> {
}
