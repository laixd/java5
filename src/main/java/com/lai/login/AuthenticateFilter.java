package com.lai.login;

import java.io.IOException;

import javax.persistence.Entity;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.lai.model.UsersModel;

@Component
@Order(1)
public class AuthenticateFilter implements Filter {
@Override
public void doFilter(ServletRequest request,ServletResponse response, FilterChain chain)
throws IOException, ServletException{
	HttpServletRequest req = (HttpServletRequest) request;
	HttpSession session = req.getSession();
	UsersModel usersModel = (UsersModel) session.getAttribute("UsersModel");
			if (usersModel == null) {
				req.getRequestDispatcher("authenticate/login").forward(request, response);
			}
	chain.doFilter(request, response);
}
}
