package com.security.jwt0Auth.config.doc;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author : Pathum Lakshan
 * @Project : Spring-Boot-With-Spring-Security
 * @Date : 2023-10-03 11:25 AM
 */

@Configuration
public class OpenAPIConfig {
    @Bean
    public OpenAPI myOpenAPI() {

        Contact contact = new Contact();
        contact.setEmail("pathumlakshanherath@gmail.com");
        contact.setName("Pathum-Lakshan");
        contact.setUrl("https://github.com/Pathum-lakshan");

        Info info = new Info()
                .title("Spring Boot 3 With Security API")
                .version("1.0")
                .contact(contact)
                .description("This API exposes endpoints.");

        return new OpenAPI().info(info);
    }
    // http://localhost:8085/api/v1/swagger-ui/index.html
}
