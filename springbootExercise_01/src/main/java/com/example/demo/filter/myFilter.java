package com.example.demo.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;


//第一种注解配置filter
@WebFilter(urlPatterns = "/*")
public class myFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        System.out.println("进入filter");
        chain.doFilter(request, response);
    }
    @Override
    public void destroy() {

    }

}
