package br.com.douglas.dadosempresainsertdata.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenAPIConfig {

    @Value("${dados.openapi.dev-url}")
    private String devUrl;

    @Value("${dados.openapi.prod-url}")
    private String prodUrl;

    @Bean
    public OpenAPI myOpenAPI() {
        Server devServer = new Server();
        devServer.setUrl(devUrl);
        devServer.setDescription("Server URL in Development environment");

        Server prodServer = new Server();
        prodServer.setUrl(prodUrl);
        prodServer.setDescription("Server URL in Production environment");

        Contact contact = new Contact();
        contact.setEmail("douglas.versato@gmail.com");
        contact.setName("Douglas");
        contact.setUrl("https://www.3ptech.com.br");

        Info info = new Info()
                .title("Dados Empresa API")
                .version("1.0")
                .contact(contact)
                .description("API para consulta de dados das empresas brasileiras.").termsOfService("https://www.3ptech.com.br/dados-empresa/terms");

        return new OpenAPI().info(info).servers(List.of(devServer, prodServer));
    }
}
