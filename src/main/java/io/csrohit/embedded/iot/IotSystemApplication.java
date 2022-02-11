package io.csrohit.embedded.iot;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.bohnman.squiggly.Squiggly;
import com.github.bohnman.squiggly.web.RequestSquigglyContextProvider;
import com.github.bohnman.squiggly.web.SquigglyRequestFilter;
import com.google.common.collect.Iterables;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import javax.servlet.http.HttpServletRequest;

@SpringBootApplication
public class IotSystemApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(IotSystemApplication.class, args);

		Iterable<ObjectMapper> objectMappers = context.getBeansOfType(ObjectMapper.class)
				.values();

		Squiggly.init(objectMappers, new RequestSquigglyContextProvider() {
			@Override
			protected String customizeFilter(String filter, HttpServletRequest request, Class beanClass) {

				// OPTIONAL: automatically wrap filter expressions in items{} when the object is a ListResponse
				if (filter != null && Page.class.isAssignableFrom(beanClass)) {
					filter = "*,content[" + filter + "]";
				}

				return filter;
			}
		});

		ObjectMapper objectMapper = Iterables.getFirst(objectMappers, null);

		// Enable Squiggly for Jackson message converter
		if (objectMapper != null) {
			for (MappingJackson2HttpMessageConverter converter : context.getBeansOfType(MappingJackson2HttpMessageConverter.class).values()) {
				converter.setObjectMapper(objectMapper);
			}
		}
	}
	@Bean
	public FilterRegistrationBean squigglyRequestFilter() {
		FilterRegistrationBean filter = new FilterRegistrationBean();
		filter.setFilter(new SquigglyRequestFilter());
		filter.setOrder(1);
		return filter;
	}

}
