package br.maulem.pone;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/attPost")
public class attPost extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("formF5.html");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAO dao = null;
		try {
			dao = new DAO();
		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
		}
		Post post = new Post();
		post.setId(Integer.valueOf(request.getParameter("id")));
		post.setTexto(request.getParameter("texto"));
		post.setCriador(request.getParameter("criador"));
		
		try {
			dao.changePost(post);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		response.sendRedirect("show");
		try {
			dao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
