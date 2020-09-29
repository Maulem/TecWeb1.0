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
		connection = DriverManager.getConnection("jdbc:mysql://localhost/Proj?useTimezone=true&serverTimezone=UTC", "root", "########");
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
		stmt.setInt(3, aPost.getId());
		stmt.execute();stmt.close();
		}
	
	public void delPost(Integer id) throws SQLException{
		PreparedStatement stmt = connection.prepareStatement("DELETE FROM Post WHERE id=?");
		stmt.setLong(1, id);
		stmt.execute();
		stmt.close();}
	
	public void close() throws SQLException{
		connection.close();
		}
}
