package com.example.demo.config;

import com.example.demo.filter.filterConfig;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



//@Configuration
public class ServletConfig {

    //第二种办法 config配置servlet的config
    @Bean
    public ServletRegistrationBean ServletConfigBran() {
        ServletRegistrationBean registration = new ServletRegistrationBean(new com.example.demo.servlet.ServletConfig(), "/servletConfig");
        return registration;
    }

    //第二种办法 config配置filter的config
    @Bean
    public FilterRegistrationBean FilterConfigBran() {
        FilterRegistrationBean registration = new FilterRegistrationBean(new filterConfig());
        registration.addUrlPatterns("/*");
        return registration;
    }

    //springboot filter处理字符编码进行过滤
    //只有spring.http.encoding.enable = false才可用
//    @Bean
//    public FilterRegistrationBean characterFilterConfigBran() {
//        FilterRegistrationBean registration = new FilterRegistrationBean();
//
//        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
//        characterEncodingFilter.setForceEncoding(true);
//        characterEncodingFilter.setEncoding("UTF-8");
//        registration.setFilter(characterEncodingFilter);
//        registration.addUrlPatterns("/*");
//        return registration;
//    }

}
