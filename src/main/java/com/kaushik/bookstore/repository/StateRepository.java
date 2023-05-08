package com.kaushik.bookstore.repository;

import com.kaushik.bookstore.entity.State;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@RepositoryRestResource
@SecurityRequirement(name = "Bearer Authentication")
@Tag(
        name = "States",
        description = "Here, GET all details of States based on Countries code endpoint."
)
public interface StateRepository extends JpaRepository<State, Integer> {
    List<State>  findByCountryCode(@Param("code") String code);
}
