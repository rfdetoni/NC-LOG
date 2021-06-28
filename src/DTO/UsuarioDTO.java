package DTO;

public class UsuarioDTO {
	private int id_user;
	private int id_nc;
	private String senha, nome_User, dica_Senha, nome_Completo,email;
	
	
	public String getNome_Completo() {
		return nome_Completo;
	}
	public void setNome_Completo(String nome_Completo) {
		this.nome_Completo = nome_Completo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getId_user() {
		return id_user;
	}
	public void setId_user(int id_user) {
		this.id_user = id_user;
	}
	public int getId_nc() {
		return id_nc;
	}
	public void setId_nc(int id_nc) {
		this.id_nc = id_nc;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getNome_User() {
		return nome_User;
	}
	public void setNome_User(String nome_User) {
		this.nome_User = nome_User;
	}
	public String getDica_Senha() {
		return dica_Senha;
	}
	public void setDica_Senha(String dica_Senha) {
		this.dica_Senha = dica_Senha;
	}
	
	

}
