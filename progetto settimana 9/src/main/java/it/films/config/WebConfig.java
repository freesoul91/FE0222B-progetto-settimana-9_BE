package it.films.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SuppressWarnings("deprecation")
@EnableWebMvc  // indica che la classe utilizzerà WebMvc
@Configuration //alla partenza del server cerca tutti  i tag configuration, servono per indicare le classi da usare per configurare i vari componenti
@ComponentScan({"it.films"}) // serve a cercare tutte le annotazioni spring che sono state messe nelle classe a partire da it.anagrafecomunale
public class WebConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {		
		super.addResourceHandlers(registry);
		registry.addResourceHandler("swagger-ui.html")
		.addResourceLocations("classpath:/META-INF/resources/");
		
		registry.addResourceHandler("/webjars/**")
		.addResourceLocations("classpath:/META-INF/resources/webjars/");
	}	

}
