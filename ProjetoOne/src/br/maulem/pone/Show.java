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

@WebServlet("/Show")
public class Show extends HttpServlet {

	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAO dao = null;
		try {
			dao = new DAO();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		List<Post> posts = null;
		try {
			posts = dao.getPost();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		userNow user = null;
		try {
			user = dao.getUserNow();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		String name = user.getUsername();
		request.setAttribute("name", name);
		request.setAttribute("posts", posts);
		RequestDispatcher dispatcher = request.getRequestDispatcher("show.jsp");
		dispatcher.forward(request, response);
		
		try {
			dao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
		
	}

}
