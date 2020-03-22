package com.example.demo.filter;

import javax.servlet.*;
import java.io.IOException;

//第二种config配置filter
public class filterConfig implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        System.out.println("进入filterConfig");
        chain.doFilter(request, response);
    }
    @Override
    public void destroy() {

    }
}
