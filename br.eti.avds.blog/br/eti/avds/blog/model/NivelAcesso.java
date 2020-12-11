package br.eti.avds.blog.model;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import br.eti.avds.blog.dao.UserDao;

public class NivelAcesso {
	private int id;
	private String nome;
	
	public NivelAcesso(int id, String nome){
		this.id = id;
		this.nome = nome;		
		
	}
	
	public NivelAcesso() {
		super();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	

}
