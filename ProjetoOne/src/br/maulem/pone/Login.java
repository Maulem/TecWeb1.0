package br.maulem.pone;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("formLogin.jsp");
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAO dao = null;
		try {
			dao = new DAO();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		List<User> users = null;
		try {
			users = dao.getUser();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String name = request.getParameter("username");
		String pass = request.getParameter("password");
		Boolean logged = false;
		
		for (User aUser : users) {
			String username = aUser.getUsername();
			String password = aUser.getPassword();
			if (username.equals(name)) {
				if (password.equals(pass)) {
					logged = true;
				}
			}
		}
		
		if (logged) {
			userNow aUser = new userNow();
			aUser.setUsername(name);
			try {
				dao.setUser(aUser);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			response.sendRedirect("show");
		}
		else {
			response.sendRedirect("login");
		}
		
		try {
			dao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
