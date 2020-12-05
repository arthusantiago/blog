package br.eti.avds.blog.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.eti.avds.blog.bd.FactoryConnection;
import br.eti.avds.blog.model.Post;

public class PostDao implements Dao<Post>{
	
	@Override
	public Post get(int id) {
		Connection conexao = FactoryConnection.getConnection();
		try {
			PreparedStatement sentenca = conexao.prepareStatement("SELECT * FROM posts WHERE id=?");
			sentenca.setInt(1, id);
			ResultSet resultado = sentenca.executeQuery();
			resultado.next();
			Post post = new Post(resultado.getString("titulo"), resultado.getString("texto"));
			post.setAutor_id(resultado.getInt("autor_id"));
			post.setTag_id(resultado.getInt("tag_id"));
			post.setId(resultado.getInt("id"));
			//recuperando o autor e tag
			post.setAutor(new AutorDao().get(resultado.getInt("autor_id")));
			post.setTag(new TagDao().get(resultado.getInt("tag_id")));
			resultado.close();
			sentenca.close();
			conexao.close();
			return post;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public List<Post> getAll() {
		ArrayList<Post> posts = new ArrayList<Post>();
		Connection conexao = FactoryConnection.getConnection();
		Statement sentenca;
		try {
			sentenca = conexao.createStatement();
			ResultSet resultado = sentenca.executeQuery("SELECT * FROM posts");
			while (resultado.next()) {
				Post post = new Post(resultado.getString("titulo"),resultado.getString("texto"));
				post.setId(resultado.getInt("id"));
				post.setAutor_id(resultado.getInt("autor_id"));
				post.setTag_id(resultado.getInt("tag_id"));
				//recuperando o autor e tag
				post.setAutor(new AutorDao().get(resultado.getInt("autor_id")));
				post.setTag(new TagDao().get(resultado.getInt("tag_id")));
				posts.add(post);
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
	public void save(Post post) {
		Connection conexao = FactoryConnection.getConnection();
		try {
			PreparedStatement sentenca = conexao.prepareStatement("INSERT INTO posts (titulo,texto,autor_id,tag_id) VALUES (?,?,?,?)");
			sentenca.setString(1, post.getTitulo());
			sentenca.setString(2, post.getTexto());
			sentenca.setInt(3, post.getAutor_id());
			sentenca.setInt(4, post.getTag_id());
			sentenca.execute();
			sentenca.close();
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Post post) {
		int id = post.getId();
		Connection conexao = FactoryConnection.getConnection();
		try {
			PreparedStatement sentenca = conexao.prepareStatement("DELETE FROM posts WHERE id=?");
			sentenca.setInt(1, id);
			sentenca.execute();
			sentenca.close();
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	@Override
	public void update(Post post) {
		Connection conexao = FactoryConnection.getConnection();
		try {
			PreparedStatement sentenca = conexao.prepareStatement(""
					+ "UPDATE posts SET titulo=?, texto=?, autor_id=?,tag_id=? WHERE id=?");
			sentenca.setString(1, post.getTitulo());
			sentenca.setString(2, post.getTexto());
			sentenca.setInt(3,post.getAutor_id());
			sentenca.setInt(4,post.getTag_id());
			sentenca.setInt(5,post.getId());
			sentenca.execute();
			sentenca.close();
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
