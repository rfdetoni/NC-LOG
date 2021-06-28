package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import DTO.NcDTO;
import DTO.UsuarioDTO;

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
			//set nome usuário da sessão;

			ResultSet rs = pstm.executeQuery();
			return rs;

		} catch (SQLException erro) {

			JOptionPane.showMessageDialog(null, "UsuarioDAO: " + erro);
			return null;

		}
		
		

	}

	public void registerUser(UsuarioDTO userDTO) {
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
			
			
		} catch (Exception erro) {
			JOptionPane.showMessageDialog(null, "RegisterDAO " + erro);
		}
		
		
		
	}
	
	public void EditarUser(UsuarioDTO userDTO) {
		String sql = "update usuario set nome_User = ?, senha = ?, dica_Senha = ?, email = ?, nome_Completo = ? where id_User = ?";
		conn = new ConexaoDAO().conectaDB();

		try {

			pstm = conn.prepareStatement(sql);
			pstm.setString(1, userDTO.getNome_User());

			pstm.setString(2, userDTO.getSenha());
			pstm.setString(3, userDTO.getDica_Senha());
			pstm.setString(4, userDTO.getEmail());
			pstm.setString(5, userDTO.getNome_Completo());
			pstm.setInt(6, userDTO.getId_user());
		
			pstm.execute();
			pstm.close();

			JOptionPane.showMessageDialog(null, "Usuário atualizado");

		} catch (Exception erro) {
			JOptionPane.showMessageDialog(null, "UsuarioDAO - EditarUser " + erro);
		}

	}
	
	public ArrayList<UsuarioDTO> PesquisarUsuario() {

		try {

			String sql = "select * from usuario where nome_User ="+"'"+this.getUserOn();
			
			JOptionPane.showMessageDialog(null, sql);
			
		
			

			conn = new ConexaoDAO().conectaDB();

			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();

			while (rs.next()) {
				UsuarioDTO userDTO = new UsuarioDTO();
				
				
			

				userDTO.setNome_Completo(rs.getString("nome_Completo"));
				userDTO.setEmail(rs.getString("email"));
				userDTO.setDica_Senha(rs.getString("dica_Senha"));
				userDTO.setId_user(rs.getInt("id_User"));
				userDTO.setNome_Completo(rs.getString("nome_Completo"));
				userDTO.setSenha(rs.getString("senha"));
				
				
				// debug descrição
				// JOptionPane.showMessageDialog(null, objnc.getDescricao_Nc());
				lista.add(userDTO);

			}

		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null, "NCDAO - pesquisarNC " + erro);
		}
		return lista;
	}

}
