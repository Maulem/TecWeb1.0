package br.maulem.pone;

import java.io.IOException;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

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
		
		userNow user = null;
		try {
			user = dao.getUserNow();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		Post post = new Post();
		post.setTexto(request.getParameter("texto"));
		post.setCriador(user.getUsername());
		post.setStatus(request.getParameter("status"));
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();
		Date data = null;
		try {
			data = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").parse(dtf.format(now));
		} catch (ParseException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		Calendar dataCreated = Calendar.getInstance();
		dataCreated.setTime(data);
		post.setData(dataCreated);

		try {
			dao.addPost(post);
		} catch (SQLException e1) {
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
