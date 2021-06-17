package NCLog.User;

import Conexao.ConexaoMySql;
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

    public boolean cadastroUsuario() {
        ConexaoMySql BD = new ConexaoMySql();
        if (!login()) {//verifica se já não há o usuário cadastrado;
            try {
                BD.conectarMySQL();
                String sql = String.format("insert into usuario (nome_User,login,senha, dica_Senha) values ('%s','%s','%s','%s')", this.nome_usuario, this.nome_usuario, this.senha, this.dica_de_senha);
                BD.execute(sql);
                BD.FecharConexao();

            } catch (Exception e) {
                System.out.println(e.getMessage());
                return false;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Usuário ja cadastrado");
        }
        return true;
    }

    public void loginUsuario() {
        String aux;
        do {
            aux = JOptionPane.showInputDialog("Digite seu usuário: ");
        } while (aux.equals(""));

        this.setNome_usuario(aux);

    }

    public void dicaSenha() {
        String aux;
        do {
            aux = JOptionPane.showInputDialog("digite a dica de senha: ");
        } while (aux.equals(""));

        this.setDica_de_senha(aux);

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

    public boolean login() {
        ConexaoMySql BD = new ConexaoMySql();

        try {
            BD.conectarMySQL();
            String sql = String.format("select * from usuario where nome_User = '%s' and  senha = '%s'", this.nome_usuario, this.senha);

            BD.executeQuery(sql);

            BD.FecharConexao();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }

        return true;
    }

    public void inicio() {

        int opt;
        do {
            opt = Integer.parseInt(JOptionPane.showInputDialog(String.format("Digite uma Opção:%n1 - Fazer Login%n2 - Cadastrar usuário%n0 - sair")));

            switch (opt) {
                case 1:
                    this.loginUsuario();
                    this.password();

                    if (this.login()) {
                        JOptionPane.showMessageDialog(null, "Logado com sucesso", "Login realizado", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Usuário ou senha inválidos", "ERRO", JOptionPane.ERROR_MESSAGE);
                    }
                    break;
                case 2:
                    this.loginUsuario();
                    this.password();
                    this.dicaSenha();

                    if (this.cadastroUsuario()) {
                        JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso" + this.getNome_usuario(), "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Erro ao cadastrar usuário", "ERRO", JOptionPane.ERROR_MESSAGE);
                    }
                    break;
                default:
                    opt = 0;

            }
        } while (opt != 0);
    }
}
