package br.eti.avds.blog.model;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import br.eti.avds.blog.dao.UserDao;

public class User {
	private int id,nivel_acesso_id;
	private String nome, email,password;
	
	public User(int id,String nome, String email,String password,int nivelAcesso){
		this.id = id;
		this.nome = nome;
		this.email = email;
		//this.password = this.passwordToSHA(password);
		this.nivel_acesso_id = nivelAcesso;
	}
	
	public User() {
		super();
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
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getNivel_acesso_id() {
		return nivel_acesso_id;
	}

	public void setNivel_acesso_id(int nivel_acesso) {
		this.nivel_acesso_id = nivel_acesso;
	}

//	public String passwordToSHA(String senha)throws NoSuchAlgorithmException,UnsupportedEncodingException{
//		MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
//		byte messageDigest[] = algorithm.digest(senha.getBytes("UTF-8"));
//		StringBuilder hexString = new StringBuilder();
//		for (byte b : messageDigest) {
//			hexString.append(String.format("%02X", 0xFF & b));
//		}
//		return hexString.toString();
//	}
	
//	public boolean senhaCorreta(String senhaTentada) throws NoSuchAlgorithmException, UnsupportedEncodingException {
//		String hexSenhaTentada = this.passwordToSHA(senhaTentada);
//		if(hexSenhaTentada.equals(this.password)) {
//			return true;
//		}else {
//			return false;
//		}
//		
//	}
	
	public boolean usuarioExiste(User userLogin,UserDao dao) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		User usuarioBD = dao.getEmail(userLogin.getEmail());
		//checando usuario
		if(usuarioBD != null) {
			//checando a senha
			if(userLogin.getPassword().equals(usuarioBD.getPassword())) {
				return true;
			}
			return false;
		}
		return false;
		
	}
}
