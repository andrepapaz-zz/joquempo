package com.joquempo.configuration;

import com.joquempo.filter.FilterUser;
import com.joquempo.filter.UserServlet;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;

/**
 * Created by andrepapazoglu on 28/11/16.
 */
@Configuration
public class WebConfiguration {

    @Bean
    public Filter shallowUserFilter() {
        return new FilterUser();
    }

    @Bean
    public ServletRegistrationBean servletRegistrationBean(){
        return new ServletRegistrationBean(new UserServlet(),"/login");
    }
}
