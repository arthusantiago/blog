package br.eti.avds.blog.model;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class User {
	private int id,nivelAcesso;
	private String nome, email,password;
	
	public User(int id,String nome, String email,String password,int nivelAcesso) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.password = this.passwordToSHA(password);
		this.nivelAcesso = nivelAcesso;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public int getNivelAcesso() {
		return nivelAcesso;
	}

	public void setNivelAcesso(int nivelAcesso) {
		this.nivelAcesso = nivelAcesso;
	}
	
	public String passwordToSHA(String senha)throws NoSuchAlgorithmException,UnsupportedEncodingException{
		MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
		byte messageDigest[] = algorithm.digest(senha.getBytes("UTF-8"));
		StringBuilder hexString = new StringBuilder();
		for (byte b : messageDigest) {
			hexString.append(String.format("%02X", 0xFF & b));
		}
		return hexString.toString();
	}
	
	public boolean senhaCorreta(String senhaTentada) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		String hexSenhaTentada = this.passwordToSHA(senhaTentada);
		if(hexSenhaTentada.equals(this.password)) {
			return true;
		}else {
			return false;
		}
		
	}
}
