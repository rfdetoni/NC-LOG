package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

import DTO.UsuarioDTO;

public class RegisterDAO {
	
	Connection conn;
	PreparedStatement pstm;	
	
	public void registerUser(UsuarioDTO userDTO) {
		String sql = "insert into usuario (nome_User,senha,dica_Senha) values (?,?,?)";
		conn = new ConexaoDAO().conectaDB();
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, userDTO.getNome_User());
			pstm.setString(2, userDTO.getSenha());
			pstm.setString(3, userDTO.getDica_Senha());
			
			pstm.execute();
			pstm.close();
			JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");
			
			
		} catch (Exception erro) {
			JOptionPane.showMessageDialog(null, "RegisterDAO " + erro);
		}
		
		
		
	}

}
