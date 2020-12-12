package br.eti.avds.blog.dao;
import java.util.List;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import br.eti.avds.blog.bd.FactoryConnection;
import br.eti.avds.blog.model.Autor;

public class AutorDao implements Dao<Autor>{
	
	public Autor get(int id) {
		Connection conexao = FactoryConnection.getConnection();
		try {
			PreparedStatement sentenca = conexao.prepareStatement("SELECT * FROM autores WHERE id=?");
			sentenca.setInt(1, id);
			ResultSet resultado = sentenca.executeQuery();
			resultado.next();
			Autor autor = new Autor(resultado.getString("nome"), 
					resultado.getString("email"));			
			autor.setId(resultado.getInt("id"));
			resultado.close();
			sentenca.close();
			conexao.close();
			return autor;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	
	public List<Autor> getAll() {
		ArrayList<Autor> autores = new ArrayList<Autor>();
		Connection conexao = FactoryConnection.getConnection();
		Statement sentenca;
		try {
			sentenca = conexao.createStatement();
			ResultSet resultado = sentenca.executeQuery("SELECT * FROM autores");
			while (resultado.next()) {
				String nome = resultado.getString("nome");
				String email = resultado.getString("email");		
				Autor autor = new Autor(nome, email);
				autor.setId(resultado.getInt("id"));
				autores.add(autor);
			}
			resultado.close();
			sentenca.close();
			conexao.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return autores;
	}

	
	public void save(Autor autor) {
		Connection conexao = FactoryConnection.getConnection();
		try {
			PreparedStatement sentenca = conexao.prepareStatement("INSERT INTO autores (nome, email) VALUES (?,?)");
			sentenca.setString(1, autor.getNome());
			sentenca.setString(2,  autor.getEmail());			
			sentenca.execute();
			sentenca.close();
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	public void update(Autor autor) {
		Connection conexao = FactoryConnection.getConnection();
		try {
			PreparedStatement sentenca = conexao.prepareStatement("UPDATE autores SET nome=?, email=? WHERE id=?");
			sentenca.setString(1, autor.getNome());
			sentenca.setString(2,  autor.getEmail());		
			sentenca.setInt(3, autor.getId());
			sentenca.execute();
			sentenca.close();
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	public void delete(Autor autor) {
		int id = autor.getId();
		Connection conexao = FactoryConnection.getConnection();
		try {
			PreparedStatement sentenca = conexao.prepareStatement("DELETE FROM autores WHERE id=?");
			sentenca.setInt(1, id);
			sentenca.execute();
			sentenca.close();
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}