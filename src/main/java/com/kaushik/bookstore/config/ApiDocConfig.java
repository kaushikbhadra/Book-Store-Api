package com.kaushik.bookstore.config;



import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Configuration;


@Configuration
@OpenAPIDefinition(
        info =@Info(
                title = "Book-Store-API",
                version = "1.0.0",
                contact = @Contact(
                        name = "Kaushik Bhadra",
                        email = "kbhadra100@gmail.com",
                        url = "https://kaushikbhadra.epizy.com/"
                ),
                license = @License(
                        name = "Apache 2.0", url = "https://www.apache.org/licenses/LICENSE-2.0"
                ),
                description = "Book store api documentation with spring security."
        ),
        servers = @Server(
                url = "http://localhost:8082",
                description = "Development"
        )
)
@SecurityScheme(
        name = "Bearer Authentication",
        description = "JSON Web Token connect to see all details.",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        scheme = "bearer",
        in = SecuritySchemeIn.HEADER
)
public class ApiDocConfig {

}
