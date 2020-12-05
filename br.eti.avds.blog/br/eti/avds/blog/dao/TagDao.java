package br.eti.avds.blog.dao;
import java.util.List;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import br.eti.avds.blog.bd.FactoryConnection;
import br.eti.avds.blog.model.Tag;

public class TagDao implements Dao<Tag>{
	@Override
	public Tag get(int id) {
		Connection conexao = FactoryConnection.getConnection();
		try {
			PreparedStatement sentenca = conexao.prepareStatement("SELECT * FROM tags WHERE id=?");
			sentenca.setInt(1, id);
			ResultSet resultado = sentenca.executeQuery();
			resultado.next();
			Tag tag = new Tag(resultado.getString("nome"));
			tag.setId(resultado.getInt("id"));
			resultado.close();
			sentenca.close();
			conexao.close();
			return tag;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Tag> getAll() {
		ArrayList<Tag> tags = new ArrayList<Tag>();
		Connection conexao = FactoryConnection.getConnection();
		Statement sentenca;
		try {
			sentenca = conexao.createStatement();
			ResultSet resultado = sentenca.executeQuery("SELECT * FROM tags");
			while (resultado.next()) {
				String nome = resultado.getString("nome");
				Tag tag = new Tag(nome);
				tag.setId(resultado.getInt("id"));
				tags.add(tag);
			}
			resultado.close();
			sentenca.close();
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tags;
	}

	@Override
	public void save(Tag tag) {
		Connection conexao = FactoryConnection.getConnection();
		try {
			PreparedStatement sentenca = conexao.prepareStatement("INSERT INTO tags (nome) VALUES (?)");
			sentenca.setString(1, tag.getNome());
			sentenca.execute();
			sentenca.close();
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Tag tag) {
		Connection conexao = FactoryConnection.getConnection();
		try {
			PreparedStatement sentenca = conexao.prepareStatement("UPDATE tags SET nome=? WHERE id=?");
			sentenca.setString(1, tag.getNome());
			sentenca.setInt(2, tag.getId());
			sentenca.execute();
			sentenca.close();
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Tag tag) {
		int id = tag.getId();
		Connection conexao = FactoryConnection.getConnection();
		try {
			PreparedStatement sentenca = conexao.prepareStatement("DELETE FROM tags WHERE id=?");
			sentenca.setInt(1, id);
			sentenca.execute();
			sentenca.close();
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}