package com.kaushik.bookstore.repository;

import com.kaushik.bookstore.entity.Product;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.RequestParam;

@RepositoryRestResource
@Tag(
        name = "Products",
        description = "Here, GET all details of Products endpoint."
)
public interface ProductRepository extends JpaRepository<Product, Long> {


    Page<Product> findByCategoryId(@RequestParam("id") Long id, Pageable pageable);
    Page<Product> findByNameContaining(@RequestParam("name") String name, Pageable pageable);

}
