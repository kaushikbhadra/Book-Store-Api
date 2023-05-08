package com.kaushik.bookstore.repository;

import com.kaushik.bookstore.entity.ProductCategory;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(collectionResourceRel = "productCategory", path = "product-category")
@Tag(
        name = "Product-Category",
        description = "Here, GET all details of Product-Category and Products via Product-Category endpoint."
)
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {
}
