package br.eti.avds.blog.dao;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.eti.avds.blog.bd.FactoryConnection;
import br.eti.avds.blog.model.User;

public class UserDao {
	
	public User getEmail(String email) {
		Connection conexao = FactoryConnection.getConnection();
		try {
			PreparedStatement sentenca = conexao.prepareStatement("SELECT * FROM users WHERE email LIKE ?");
			sentenca.setString(1,email);
			ResultSet resultado = sentenca.executeQuery();
			User user = new User();
			while (resultado.next()) {
				user.setId(resultado.getInt("id"));
				user.setNome(resultado.getString("nome"));
				user.setEmail(resultado.getString("email"));
				user.setPassword(resultado.getString("password"));
				user.setNivel_acesso_id(resultado.getInt("nivel_acesso_id"));
			}
			resultado.close();
			sentenca.close();
			conexao.close();
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public User get(int id) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		Connection conexao = FactoryConnection.getConnection();
		try {
			PreparedStatement sentenca = conexao.prepareStatement("SELECT * FROM users WHERE id=?");
			sentenca.setInt(1, id);
			ResultSet resultado = sentenca.executeQuery();
			resultado.next();
			User user = new User(
					resultado.getInt("id"),
					resultado.getString("nome"),
					resultado.getString("email"),
					resultado.getString("password"),
					resultado.getInt("nivel_acesso_id"));
			resultado.close();
			sentenca.close();
			conexao.close();
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	
	public List<User> getAll() throws NoSuchAlgorithmException, UnsupportedEncodingException {
		ArrayList<User> users = new ArrayList<User>();
		Connection conexao = FactoryConnection.getConnection();
		Statement sentenca;
		try {
			sentenca = conexao.createStatement();
			ResultSet resultado = sentenca.executeQuery("SELECT * FROM users");
			while (resultado.next()) {
				User user = new User(
						resultado.getInt("id"),
						resultado.getString("nome"),
						resultado.getString("email"),
						resultado.getString("password"),
						resultado.getInt("nivel_acesso_id"));
				users.add(user);
			}
			resultado.close();
			sentenca.close();
			conexao.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return users;
	}

	
	public void save(User user) {
		Connection conexao = FactoryConnection.getConnection();
		try {
			PreparedStatement sentenca = 
					conexao.prepareStatement("INSERT INTO users (nome, email,password,nivel_acesso_id) VALUES (?,?,?,?)");
			sentenca.setString(1, user.getNome());
			sentenca.setString(2, user.getEmail());
			sentenca.setString(3, user.getPassword());
			sentenca.setInt(4,  user.getNivel_acesso_id());
			sentenca.execute();
			sentenca.close();
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	public void update(User user) {
		Connection conexao = FactoryConnection.getConnection();
		try {
			PreparedStatement sentenca = 
					conexao.prepareStatement("UPDATE users SET nome=?, email=?, password=?,nivel_acesso_id=? WHERE id=?");
			sentenca.setString(1, user.getNome());
			sentenca.setString(2, user.getEmail());
			sentenca.setString(3, user.getPassword());
			sentenca.setInt(4,  user.getNivel_acesso_id());
			sentenca.setInt(5,  user.getId());
			sentenca.execute();
			sentenca.close();
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	public void delete(User user) {
		Connection conexao = FactoryConnection.getConnection();
		try {
			PreparedStatement sentenca = conexao.prepareStatement("DELETE FROM users WHERE id=?");
			sentenca.setInt(1, user.getId());
			sentenca.execute();
			sentenca.close();
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
