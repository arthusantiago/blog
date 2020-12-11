package br.eti.avds.blog.dao;
import java.util.List;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import br.eti.avds.blog.bd.FactoryConnection;
import br.eti.avds.blog.model.Categoria;
import br.eti.avds.blog.model.Tag;

public class CategoriaDao implements Dao<Categoria>{
	@Override
	public Categoria get(int id) {
		Connection conexao = FactoryConnection.getConnection();
		try {
			PreparedStatement sentenca = conexao.prepareStatement("SELECT * FROM categorias WHERE id=?");
			sentenca.setInt(1, id);
			ResultSet resultado = sentenca.executeQuery();
			resultado.next();
			Categoria categoria = new Categoria(resultado.getString("nome"));
			categoria.setId(resultado.getInt("id"));
			resultado.close();
			sentenca.close();
			conexao.close();
			return categoria;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Categoria> getAll() {
		ArrayList<Categoria> categorias = new ArrayList<Categoria>();
		Connection conexao = FactoryConnection.getConnection();
		Statement sentenca;
		try {
			sentenca = conexao.createStatement();
			ResultSet resultado = sentenca.executeQuery("SELECT * FROM categorias");
			while (resultado.next()) {
				String nome = resultado.getString("nome");
				Categoria categoria = new Categoria(nome);
				categoria.setId(resultado.getInt("id"));
				categorias.add(categoria);
			}
			resultado.close();
			sentenca.close();
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return categorias;
	}

	@Override
	public void save(Categoria categoria) {
		Connection conexao = FactoryConnection.getConnection();
		try {
			PreparedStatement sentenca = conexao.prepareStatement("INSERT INTO categorias (nome) VALUES (?)");
			sentenca.setString(1, categoria.getNome());
			sentenca.execute();
			sentenca.close();
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Categoria categoria) {
		Connection conexao = FactoryConnection.getConnection();
		try {
			PreparedStatement sentenca = conexao.prepareStatement("UPDATE categorias SET nome=? WHERE id=?");
			sentenca.setString(1, categoria.getNome());
			sentenca.setInt(2, categoria.getId());
			sentenca.execute();
			sentenca.close();
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Categoria categoria) {
		int id = categoria.getId();
		Connection conexao = FactoryConnection.getConnection();
		try {
			PreparedStatement sentenca = conexao.prepareStatement("DELETE FROM categorias WHERE id=?");
			sentenca.setInt(1, id);
			sentenca.execute();
			sentenca.close();
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}