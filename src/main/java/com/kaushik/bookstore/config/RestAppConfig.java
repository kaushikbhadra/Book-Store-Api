package com.kaushik.bookstore.config;

import com.kaushik.bookstore.entity.Country;
import com.kaushik.bookstore.entity.Product;
import com.kaushik.bookstore.entity.ProductCategory;
import com.kaushik.bookstore.entity.State;
import jakarta.persistence.EntityManager;
import jakarta.persistence.metamodel.EntityType;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Configuration
@AllArgsConstructor
public class RestAppConfig implements RepositoryRestConfigurer {

    private final EntityManager entityManager;

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        HttpMethod[] theUnsupportedActions = {HttpMethod.POST, HttpMethod.PUT, HttpMethod.DELETE};
        disableHttpsMethods(Product.class, config, theUnsupportedActions);
        disableHttpsMethods(ProductCategory.class, config, theUnsupportedActions);
        disableHttpsMethods(Country.class, config, theUnsupportedActions);
        disableHttpsMethods(State.class, config, theUnsupportedActions);
        exposeIds(config);
    }

    private void disableHttpsMethods(Class myclass ,RepositoryRestConfiguration config, HttpMethod[] theUnsupportedActions) {
        config.getExposureConfiguration()
                .forDomainType(myclass)
                .withItemExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions))
                .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions));
    }

    private void exposeIds(RepositoryRestConfiguration config) {
        Set<EntityType<?>> entityTypes = entityManager.getMetamodel().getEntities();
        List<Class> classes = new ArrayList<>();
        for (EntityType entityType : entityTypes){
            classes.add(entityType.getJavaType());
        }
        Class[] type = classes.toArray(new Class[0]);
        config.exposeIdsFor(type);
    }
}
