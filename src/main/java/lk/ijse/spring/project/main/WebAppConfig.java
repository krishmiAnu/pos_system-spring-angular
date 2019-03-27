package lk.ijse.spring.project.main;

import lk.ijse.spring.project.repository.CustomerRepository;
import lk.ijse.spring.project.repository.CategorieRepository;
import lk.ijse.spring.project.repository.ProductRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@ComponentScan("lk.ijse.spring.project")
@EnableWebMvc
@EnableJpaRepositories(basePackageClasses = {CustomerRepository.class, CategorieRepository.class, ProductRepository.class})
@EnableTransactionManagement
public class WebAppConfig implements WebMvcConfigurer{
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }


}