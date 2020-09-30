package br.maulem.pone;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;



//DAO ProjOne
public class DAO {
private Connection connection = null;
	
	public DAO() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:mysql://localhost/Proj?useTimezone=true&serverTimezone=UTC", "root", "######");
	}
	
	public List<Post> getPost() throws SQLException{
		List<Post> posts = new ArrayList<Post>();
		PreparedStatement stmt = connection.
				prepareStatement("SELECT * FROM Post");
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()){
			Post aPost = new Post();
			aPost.setId(rs.getInt("id"));
			aPost.setTexto(rs.getString("texto"));
			aPost.setCriador(rs.getString("criador"));
			aPost.setStatus(rs.getString("status"));
			
			Calendar data = Calendar.getInstance();
			data.setTime(rs.getDate("criado"));
			aPost.setData(data);
			
			posts.add(aPost);
			}
		rs.close();
		stmt.close();
		return posts;
		}
		
	public List<User> getUser() throws SQLException{
		List<User> users = new ArrayList<User>();
		PreparedStatement stmt = connection.
				prepareStatement("SELECT * FROM User");
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()){
			User aUser = new User();
			aUser.setUsername(rs.getString("username"));
			aUser.setPassword(rs.getString("password"));			
			users.add(aUser);
			}
		rs.close();
		stmt.close();
		return users;
		}
	
	public void addPost(Post aPost) throws SQLException{
		String sql = "INSERT INTO Post"+"(texto,criador,status,criado) values(?,?,?,?)";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1, aPost.getTexto());
		stmt.setString(2, aPost.getCriador());
		stmt.setString(3, aPost.getStatus());
		stmt.setDate(4, new java.sql.Date(aPost.getData().getTimeInMillis()));
		stmt.execute();
		stmt.close();
		}
	
	public void changePost(Post aPost) throws SQLException{
		String sql ="UPDATE Post SET " +"texto=?, criador=?, status=? WHERE id=?";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1, aPost.getTexto());
		stmt.setString(2, aPost.getCriador());
		stmt.setString(3, aPost.getStatus());
		stmt.setInt(4, aPost.getId());
		stmt.execute();stmt.close();
		}
	
	public void delPost(Integer id) throws SQLException{
		PreparedStatement stmt = connection.prepareStatement("DELETE FROM Post WHERE id=?");
		stmt.setLong(1, id);
		stmt.execute();
		stmt.close();}
	
	public void setUser(userNow aUser) throws SQLException{
		String sql = "UPDATE now SET " +"username=?";;
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1, aUser.getUsername());
		stmt.execute();
		stmt.close();
		}
	
	public userNow getUserNow() throws SQLException {
		PreparedStatement stmt = connection.prepareStatement("SELECT * FROM now");
		ResultSet rs = stmt.executeQuery();
		userNow aUser = new userNow();
		while(rs.next()){
			aUser.setUsername(rs.getString("username"));
		}
		rs.close();
		stmt.close();
		return aUser;
	}
	
public List<Post> selectOrder(String option) throws SQLException {
		List<Post> posts = new ArrayList<Post>();
		String sql = "SELECT * FROM Post ORDER BY ";
		
		if (option.equals("1")) {
			sql += "texto";
		} else if (option.equals("2")) {
			sql += "criador";
		} else if (option.equals("3")) {
			sql += "status";
		} else if (option.equals("4")) {
			sql += "criado";
		}
		
		PreparedStatement stmt = connection.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()){
			Post aPost = new Post();
			aPost.setId(rs.getInt("id"));
			aPost.setTexto(rs.getString("texto"));
			aPost.setCriador(rs.getString("criador"));
			aPost.setStatus(rs.getString("status"));
			
			Calendar data = Calendar.getInstance();
			data.setTime(rs.getDate("criado"));
			aPost.setData(data);
			
			posts.add(aPost);
			}
		
		rs.close();
		stmt.close();
		
		return posts;
	}

	public Post search(String input) throws SQLException {
		String sql = "SELECT * FROM Post WHERE texto LIKE ?";
		
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1, input);
		ResultSet rs = stmt.executeQuery();
		
		Post aPost = new Post();
		
		while (rs.next()) {
			aPost.setId(rs.getInt("id"));
			aPost.setTexto(rs.getString("texto"));
			aPost.setCriador(rs.getString("criador"));
			aPost.setStatus(rs.getString("status"));
			
			Calendar data = Calendar.getInstance();
			data.setTime(rs.getDate("criado"));
			aPost.setData(data);
		}
		
		return aPost;
	}

	public void close() throws SQLException{
		connection.close();
		}
}
