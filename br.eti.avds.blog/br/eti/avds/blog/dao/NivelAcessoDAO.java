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
import br.eti.avds.blog.model.NivelAcesso;


public class NivelAcessoDAO {

	public NivelAcesso get(int id) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		Connection conexao = FactoryConnection.getConnection();
		try {
			PreparedStatement sentenca = conexao.prepareStatement("SELECT * FROM nivel_acesso WHERE id=?");
			sentenca.setInt(1, id);
			ResultSet resultado = sentenca.executeQuery();
			resultado.next();
			NivelAcesso nivel = new NivelAcesso(
					resultado.getInt("id"),
					resultado.getString("nome") );
			resultado.close();
			sentenca.close();
			conexao.close();
			return nivel;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public List<NivelAcesso> getAll() throws NoSuchAlgorithmException, UnsupportedEncodingException {
		ArrayList<NivelAcesso> niveis = new ArrayList<NivelAcesso>();
		Connection conexao = FactoryConnection.getConnection();
		Statement sentenca;
		try {
			sentenca = conexao.createStatement();
			ResultSet resultado = sentenca.executeQuery("SELECT * FROM nivel_acesso");
			while (resultado.next()) {
				NivelAcesso nivel = new NivelAcesso(
						resultado.getInt("id"),
						resultado.getString("nome")	);
				niveis.add(nivel);
			}
			resultado.close();
			sentenca.close();
			conexao.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return niveis;
	}
	
	public void save(NivelAcesso nivel) {
		Connection conexao = FactoryConnection.getConnection();
		try {
			PreparedStatement sentenca = 
					conexao.prepareStatement("INSERT INTO nivel_acesso (nome) VALUES (?)");
			sentenca.setString(1, nivel.getNome());			
			sentenca.execute();
			sentenca.close();
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void update(NivelAcesso nivel) {
		Connection conexao = FactoryConnection.getConnection();
		try {
			PreparedStatement sentenca = 
					conexao.prepareStatement("UPDATE nivel_acesso SET nome=? WHERE id=?");
			sentenca.setString(1, nivel.getNome());			
			sentenca.setInt(2,  nivel.getId());
			sentenca.execute();
			sentenca.close();
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void delete(NivelAcesso nivel) {
		Connection conexao = FactoryConnection.getConnection();
		try {
			PreparedStatement sentenca = conexao.prepareStatement("DELETE FROM nivel_acesso WHERE id=?");
			sentenca.setInt(1, nivel.getId());
			sentenca.execute();
			sentenca.close();
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
