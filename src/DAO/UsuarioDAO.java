package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import DTO.UsuarioDTO;

public class UsuarioDAO {

	


	Connection conn;

	public ResultSet autUsuario(UsuarioDTO objuser) {
		conn = new ConexaoDAO().conectaDB();

		try {
			
			String sql = "select * from usuario where nome_User = ? and senha = ?";
			PreparedStatement pstm = conn.prepareStatement(sql);

			pstm.setString(1, objuser.getNome_User());
			pstm.setString(2, objuser.getSenha());
			//set nome usuário da sessão;

			ResultSet rs = pstm.executeQuery();
			return rs;

		} catch (SQLException erro) {

			JOptionPane.showMessageDialog(null, "UsuarioDAO: " + erro);
			return null;

		}

	}

}
