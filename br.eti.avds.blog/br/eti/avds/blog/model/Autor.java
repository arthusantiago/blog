package br.eti.avds.blog.model;

public class Autor {
	private int id;
	private String nome, email;

	
	public Autor(String nome, String email) {
		this.nome = nome;
		this.email = email;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
