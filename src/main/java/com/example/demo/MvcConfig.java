package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.mitchellbosecke.pebble.PebbleEngine;
import com.mitchellbosecke.pebble.loader.ClasspathLoader;
import com.mitchellbosecke.pebble.loader.Loader;
import com.mitchellbosecke.pebble.spring4.PebbleViewResolver;
import com.mitchellbosecke.pebble.spring4.extension.SpringExtension;


@Configuration
@ComponentScan(basePackages = { "com.example.demo" })
@EnableWebMvc
public class MvcConfig extends WebMvcConfigurerAdapter {
//
//    @Autowired
//    private ServletContext servletContext;

    @Bean
    public Loader<String> templateLoader(){
        //return new ServletLoader(servletContext);
    	return new ClasspathLoader();
    }

    @Bean
    public SpringExtension springExtension() {
        return new SpringExtension();
    }

    @Bean
    public PebbleEngine pebbleEngine() {
         return new PebbleEngine.Builder()
                .loader(this.templateLoader())
                .extension(springExtension())
                .build();
    }

    @Bean
    public ViewResolver viewResolver() {
        PebbleViewResolver viewResolver = new PebbleViewResolver();
        //viewResolver.setPrefix("/resources/templates/");
        viewResolver.setPrefix("/templates/");
        viewResolver.setSuffix(".html");
        viewResolver.setPebbleEngine(pebbleEngine());
        //System.out.println( servletContext.getRealPath("") );
        return viewResolver;
    }

}