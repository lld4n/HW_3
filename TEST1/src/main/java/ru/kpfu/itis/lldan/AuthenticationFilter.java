package ru.kpfu.itis.lldan;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/getweather")
public class AuthenticationFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        String login = (String) httpRequest.getSession().getAttribute("login");
        String password = (String) httpRequest.getSession().getAttribute("password");


        if (login != null && password != null && login.equals(LoginServlet.LOGIN) && password.equals(LoginServlet.PASSWORD)) {
            chain.doFilter(request, response);
        } else {
            httpResponse.sendRedirect("/TEST1_war_exploded/error");
        }
    }

}
