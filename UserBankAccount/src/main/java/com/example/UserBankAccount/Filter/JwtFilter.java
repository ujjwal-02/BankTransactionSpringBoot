package com.example.UserBankAccount.Filter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.filter.GenericFilterBean;

import java.io.IOException;

public class JwtFilter extends GenericFilterBean {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request= (HttpServletRequest) servletRequest;
        HttpServletResponse response=(HttpServletResponse) servletResponse;


        String authHeader=request.getHeader("authorization");

        if(request.getMethod().equalsIgnoreCase("Options"))
        {
            response.setStatus(HttpServletResponse.SC_OK);
        }else if(authHeader==null||!authHeader.startsWith("Bearer "))
        {
            throw new ServletException("Missing or invalid token");
        }


        String token=authHeader.substring(7);
        //  Claims claims= Jwts.parser().setSigningKey("userkey").parseClaimsJwt(token).getBody();
        // request.setAttribute("claims",claims);;

        //forwarding request and response to other available
        filterChain.doFilter(request,response);

    }
}