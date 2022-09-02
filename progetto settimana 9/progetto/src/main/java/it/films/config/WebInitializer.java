package it.films.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {		
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {		
		return new Class[] {WebConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		// � la mappatura della servlet
		// array perch� sono possibili mappature multiple
		return new String[] {"/"};
	}

}
