package br.eti.avds.blog.model;


public class Pagina {
	private String titulo, conteudo;
	private int user_id, id;

	
	public Pagina(String titulo, String conteudo) {
		this.titulo = titulo;
		this.conteudo = conteudo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	
	
	
}
