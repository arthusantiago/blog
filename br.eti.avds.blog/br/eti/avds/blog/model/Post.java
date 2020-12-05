package br.eti.avds.blog.model;


public class Post {
	private String titulo, texto;
	private int id, autor_id, tag_id;
	private Autor autor;
	private Tag tag;
	
	public Post(String titulo, String texto) {
		this.titulo = titulo;
		this.texto = texto;
	}

	public String getTitulo() {
		return titulo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public int getAutor_id() {
		return autor_id;
	}

	public void setAutor_id(int autor_id) {
		this.autor_id = autor_id;
	}

	public int getTag_id() {
		return tag_id;
	}

	public void setTag_id(int tag_id) {
		this.tag_id = tag_id;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public Tag getTag() {
		return tag;
	}

	public void setTag(Tag tag) {
		this.tag = tag;
	}
	
	
}
