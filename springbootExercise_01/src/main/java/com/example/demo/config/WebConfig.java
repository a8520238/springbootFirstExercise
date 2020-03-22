package com.example.demo.config;


import com.example.demo.intercept.LoginIntercept;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


//登录拦截器的配置类
@Configuration
//public class WebConfig extends WebMvcConfigurerAdapter {
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //配置拦截路径
        String[] addPathPatterns = {
                "/hello"
        };
        //配置不拦截路径
        String[] excludePathPatterns = {
                "/boot/index"
        };
        registry.addInterceptor(new LoginIntercept()).addPathPatterns().excludePathPatterns();
    }
}
