package it.films.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.annotations.Api;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Api(value = "Database Films", tags = "Descrizione del progetto Films")
@EnableSwagger2
@Configuration
public class SwaggerConfig {
	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("Database Films")
				.description("Elenco e gestione Films")
				.version("1.0.0")
				.license("Apache License Version 2.0")
				.licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
				.contact(new Contact("Daniele Cerulli", "https://www.instagram.com/daniele.cer/?hl=it", "dcerulli.dc@gmail.com"))
				.build();
	}
	// generatore di documentazione
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.any())  //.paths(regex("/spring/test/*"))
				.build()
				.apiInfo(apiInfo());
	}

}
