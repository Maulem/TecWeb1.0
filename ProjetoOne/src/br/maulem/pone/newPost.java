package br.maulem.pone;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/newPost")
public class newPost extends HttpServlet {

	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		RequestDispatcher dispatcher = request.getRequestDispatcher("formNew.html");
		dispatcher.forward(request, response);
		}
	@Override
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		DAO dao = null;
		try {
			dao = new DAO();
		} catch (ClassNotFoundException | SQLException e3) {
			e3.printStackTrace();
		}
		Post post = new Post();
		post.setTexto(request.getParameter("texto"));
		post.setCriador(request.getParameter("criador"));

		try {
			dao.addPost(post);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		response.sendRedirect("Show");
		try {
			dao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
