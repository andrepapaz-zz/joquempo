package com.joquempo.filter;

import com.joquempo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by andrepapazoglu on 28/11/16.
 */
public class FilterUser implements Filter{

    @Autowired
    UserService userService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession(false);

        String requestURI = request.getRequestURI();
        String loginURI = request.getContextPath() + "/login.html";
        String loginPostURI = request.getContextPath() + "/login";
        String css = ".css";
        String js = ".js";
        String img = ".jpg";


        boolean loggedIn = session != null && session.getAttribute("user") != null;
        boolean loginRequest = requestURI.equals(loginURI);
        boolean loginPost = requestURI.equals(loginPostURI);
        boolean cssb = requestURI.endsWith(css);
        boolean jsb = requestURI.endsWith(js);
        boolean imgb = requestURI.endsWith(img);

        if (loggedIn || loginRequest || loginPost || cssb || jsb || imgb) {
            filterChain.doFilter(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/login.html");
            return;
        }
        }

    @Override
    public void destroy() {

    }
}
