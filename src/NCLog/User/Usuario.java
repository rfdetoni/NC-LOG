package NCLog.User;

import javax.swing.JOptionPane;

public class Usuario {

    public int id_user;
    private int id_interfacenc, numero;
    private String nome_usuario, senha, dica_de_senha;

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getId_interfacenc() {
        return id_interfacenc;
    }

    public void setId_interfacenc(int id_interfacenc) {
        this.id_interfacenc = id_interfacenc;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNome_usuario() {
        return nome_usuario;
    }

    public void setNome_usuario(String nome_usuario) {
        this.nome_usuario = nome_usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getDica_de_senha() {
        return dica_de_senha;
    }

    public void setDica_de_senha(String dica_de_senha) {
        this.dica_de_senha = dica_de_senha;
    }

    public void cadastroUsuario() {
        String user, pass;
        loginUsuario();
        password();

    }

    public void loginUsuario() {
        String aux;
        do {
            aux = JOptionPane.showInputDialog("Digite seu usuário: ");
        } while (aux.equals(""));

        this.setNome_usuario(aux);

    }

    public void password() {
        String aux;
        do {
            aux = JOptionPane.showInputDialog("Digite sua Senha: ");
        } while (aux.equals(""));
        this.setSenha(aux);
    }

    public void statusUsuario() {
    }
}
