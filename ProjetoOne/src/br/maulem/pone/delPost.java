package br.maulem.pone;

import java.io.IOException;

import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/delPost")
public class delPost extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("formDel.html");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAO dao = null;
		try {
			dao = new DAO();
		} catch (ClassNotFoundException | SQLException e2) {
			e2.printStackTrace();
		}
		try {
			dao.delPost(Integer.valueOf(request.getParameter("id")));
		} catch (NumberFormatException | SQLException e1) {
			e1.printStackTrace();
		}
		response.sendRedirect("show");
		try {
			dao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
