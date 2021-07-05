package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import DTO.NcDTO;
import DTO.UsuarioDTO;
import DTO.VariaveisEstaticas;
import visual.Login;
import visual.RegisterScreen;

public class UsuarioDAO {
	public static String userOn;

	public String getUserOn() {
		return userOn;
	}

	public void setUserOn(String userOn) {
		UsuarioDAO.userOn = userOn;
	}

	ArrayList<UsuarioDTO> lista = new ArrayList<>();
	ResultSet rs;

	Connection conn;
	PreparedStatement pstm;

	public ResultSet autUsuario(UsuarioDTO objuser) {
		conn = new ConexaoDAO().conectaDB();

		try {

			String sql = "select * from usuario where nome_User = ? and senha = ?";
			PreparedStatement pstm = conn.prepareStatement(sql);

			pstm.setString(1, objuser.getNome_User());
			pstm.setString(2, objuser.getSenha());
			// set nome usuário da sessão;

			ResultSet rs = pstm.executeQuery();
	
				
			
			return rs;
			
		} catch (SQLException erro) {

			JOptionPane.showMessageDialog(null, "UsuarioDAO: " + erro);
			return null;

		}
		

	}

	public boolean validaUsuario(UsuarioDTO objuser) {// valida se nome de usuário ja foi usado
		conn = new ConexaoDAO().conectaDB();

		try {

			String sql = "select * from usuario where nome_User = ?";
			PreparedStatement pstm = conn.prepareStatement(sql);

			pstm.setString(1, objuser.getNome_User());

			ResultSet rs = pstm.executeQuery();

			if (rs.next()) {
				return true;
			}

		} catch (SQLException erro) {

			JOptionPane.showMessageDialog(null, "UsuarioDAO: " + erro);

		}
		return false;

	}

	public boolean registerUser(UsuarioDTO userDTO) {

		if (!validaUsuario(userDTO)) {
			String sql = "insert into usuario (nome_User,senha,dica_Senha,nome_Completo,email ) values (?,?,?,?,?)";
			conn = new ConexaoDAO().conectaDB();
			try {
				pstm = conn.prepareStatement(sql);
				pstm.setString(1, userDTO.getNome_User());
				pstm.setString(2, userDTO.getSenha());
				pstm.setString(3, userDTO.getDica_Senha());
				pstm.setString(4, userDTO.getNome_Completo());
				pstm.setString(5, userDTO.getEmail());

				pstm.execute();
				pstm.close();
				JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");

				Login login = new Login();
				login.setVisible(true);

				return true;

			} catch (Exception erro) {
				JOptionPane.showMessageDialog(null, "Erro! favor informar UsuarioDAO registerUser");
			}
		} else {
			JOptionPane.showMessageDialog(null, "Nome de usuário já utilizado, favor selecionar outro");

		}
		return false;

	}



	public ArrayList<UsuarioDTO> PesquisarUsuario() {

		try {

			String sql = "select * from usuario where nome_User =" + "'" + this.getUserOn() + "'";

			conn = new ConexaoDAO().conectaDB();

			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();

			while (rs.next()) {
				UsuarioDTO userDTO = new UsuarioDTO();

				userDTO.setNome_Completo(rs.getString("nome_Completo"));
				userDTO.setEmail(rs.getString("email"));
				userDTO.setDica_Senha(rs.getString("dica_Senha"));
				userDTO.setId_user(rs.getInt("id_User"));
				userDTO.setNome_User(rs.getString("nome_User"));
				userDTO.setSenha(rs.getString("senha"));

				lista.add(userDTO);

			}

		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null, "NCDAO - pesquisarNC " + erro);
		}
		return lista;
	}

	public boolean salvarUsuario(UsuarioDTO userDTO) {
		
			try {
				String sql = "update usuario set  dica_Senha = ?, senha = ?, email = ?, nome_Completo = ? where id_User =?  ";
				conn = new ConexaoDAO().conectaDB();
				pstm = conn.prepareStatement(sql);

				
				pstm.setString(1, userDTO.getDica_Senha());
				pstm.setString(2, userDTO.getSenha());
				pstm.setString(3, userDTO.getEmail());
				pstm.setString(4, userDTO.getNome_Completo());
				pstm.setInt(5, userDTO.getId_user());

				pstm.execute();
				pstm.close();
				JOptionPane.showMessageDialog(null, "Usuário atualizado com sucesso!");
				return true;

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "UsuarioDAO SalvarUsuario - " + e);
			}
		

		return false;

	}

}
