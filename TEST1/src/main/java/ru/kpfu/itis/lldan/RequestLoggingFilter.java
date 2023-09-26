package ru.kpfu.itis.lldan;

import javax.servlet.Filter;
import javax.servlet.FilterChain;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("/*")
public class RequestLoggingFilter implements Filter {


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        long startTime = System.currentTimeMillis();

        chain.doFilter(request, response);

        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;

        String requestURI = ((HttpServletRequest) request).getRequestURI();
        String requestMethod = ((HttpServletRequest) request).getMethod();

        org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(RequestLoggingFilter.class);
        logger.info("Request URI: {}, Method: {}, Response Time: {} ms", requestURI, requestMethod, elapsedTime);
    }


}
