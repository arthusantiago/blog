package br.eti.avds.blog.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.eti.avds.blog.bd.FactoryConnection;
import br.eti.avds.blog.model.Pagina;
import br.eti.avds.blog.model.Post;

public class PaginaDao implements Dao<Pagina>{
	
	@Override
	public Pagina get(int id) {
		Connection conexao = FactoryConnection.getConnection();
		try {
			PreparedStatement sentenca = conexao.prepareStatement("SELECT * FROM paginas WHERE id=?");
			sentenca.setInt(1, id);
			ResultSet resultado = sentenca.executeQuery();
			resultado.next();
			Pagina pagina = new Pagina(resultado.getString("titulo"), resultado.getString("conteudo"));
			pagina.setUser_id(resultado.getInt("user_id"));			
			pagina.setId(resultado.getInt("id"));
		
			resultado.close();
			sentenca.close();
			conexao.close();
			return pagina;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public List<Pagina> getAll() {
		ArrayList<Pagina> posts = new ArrayList<Pagina>();
		Connection conexao = FactoryConnection.getConnection();
		Statement sentenca;
		try {
			sentenca = conexao.createStatement();
			ResultSet resultado = sentenca.executeQuery("SELECT * FROM paginas");
			while (resultado.next()) {
				Pagina pagina = new Pagina(resultado.getString("titulo"),resultado.getString("conteudo"));
				pagina.setUser_id(resultado.getInt("user_id"));			
				pagina.setId(resultado.getInt("id"));
				//recuperando o autor e tag
				
				posts.add(pagina);
			}
			resultado.close();
			sentenca.close();
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return posts;
	}	
	

	@Override
	public void save(Pagina pagina) {
		Connection conexao = FactoryConnection.getConnection();
		try {
			PreparedStatement sentenca = conexao.prepareStatement("INSERT INTO paginas (titulo,conteudo,user_id) VALUES (?,?,?)");
			sentenca.setString(1, pagina.getTitulo());
			sentenca.setString(2, pagina.getConteudo());
			sentenca.setInt(3, pagina.getUser_id());			
			sentenca.execute();
			sentenca.close();
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Pagina pagina) {
		int id = pagina.getId();
		Connection conexao = FactoryConnection.getConnection();
		try {
			PreparedStatement sentenca = conexao.prepareStatement("DELETE FROM paginas WHERE id=?");
			sentenca.setInt(1, id);
			sentenca.execute();
			sentenca.close();
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	@Override
	public void update(Pagina pagina) {
		Connection conexao = FactoryConnection.getConnection();
		try {
			PreparedStatement sentenca = conexao.prepareStatement(""
					+ "UPDATE paginas SET titulo=?, conteudo=?, user_id=? WHERE id=?");
			sentenca.setString(1, pagina.getTitulo());
			sentenca.setString(2, pagina.getConteudo());
			sentenca.setInt(3,pagina.getUser_id());	
			sentenca.setInt(4,pagina.getId());
			sentenca.execute();
			sentenca.close();
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
