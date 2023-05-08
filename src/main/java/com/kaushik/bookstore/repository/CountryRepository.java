package com.kaushik.bookstore.repository;

import com.kaushik.bookstore.entity.Country;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(exposedHeaders = {"Access-Control-Allow-Origin","Access-Control-Allow-Credentials"})
@RepositoryRestResource
@SecurityRequirement(name = "Bearer Authentication")
@Tag(
        name = "Country",
        description = "Here, GET all details of countries endpoint."
)
public interface CountryRepository extends JpaRepository<Country, Integer> {
}
