package com.kaushik.bookstore.repository;

import com.kaushik.bookstore.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(exposedHeaders = {"Access-Control-Allow-Origin","Access-Control-Allow-Credentials"})
@RepositoryRestResource
public interface CountryRepository extends JpaRepository<Country, Integer> {
}
