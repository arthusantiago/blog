package br.eti.avds.blog.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FactoryConnection {
	public static Connection getConnection() {
		  String url = "jdbc:postgresql://localhost/lp3-blog";
		  String usuario = "postgres";
		  String password = "postgres";
		  try {
			Class.forName("org.postgresql.Driver");  
			Connection conexao = DriverManager.getConnection(url, usuario, password);
			return conexao;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}
}