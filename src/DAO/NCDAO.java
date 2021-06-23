package DAO;

import java.io.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import DTO.NcDTO;
import DTO.UsuarioDTO;
import visual.CreateNC;
import visual.EditNC;
import visual.okNext;

public class NCDAO {
	Connection conn;
	PreparedStatement pstm;
	ResultSet rs;
	ArrayList<NcDTO> lista =  new ArrayList<>();
	ArrayList<EditNC> editar = new ArrayList<>();
	private static String resp_nc;
	private String pesquisa;
	
	
	
	public void registerNC(NcDTO objnc) {

		String sql = "insert into naoConformidade (nome_Nc,descricao_Nc,local_Nc,responsavel_Nc) values (?,?,?,?)";
		conn = new ConexaoDAO().conectaDB();
		try {

			pstm = conn.prepareStatement(sql);
			pstm.setString(1, objnc.getNome_Nc());
			pstm.setString(2, objnc.getDescricao_Nc());
			pstm.setString(3, objnc.getLocal_Nc());
			pstm.setString(4, objnc.getResponsavel_Nc());

			pstm.execute();
			pstm.close();
			okNext ok = new okNext();
			ok.setVisible(true);

		} catch (Exception erro) {
			JOptionPane.showMessageDialog(null, "NCDAO - registerNC " + erro);
		}

	}
	
	public void setPesquisa(String pesquisa) {
		this.pesquisa = pesquisa;
		
	}
	public String getPesquisa() {
		return pesquisa;
	}
	
	
	public void setRespNc(String resp_nc) {
		this.resp_nc = resp_nc;
		
	}
	
	public String getRespNc() {
		return resp_nc;
	}
	
	
	public	ArrayList<NcDTO> pesquisarNC(){
		
		try {
			
			String sql = "select * from naoConformidade where responsavel_Nc = " +"'"+ this.getRespNc()+"'";
			
					
			conn = new ConexaoDAO().conectaDB();
			
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			
			
			while (rs.next()){
				NcDTO objnc = new NcDTO();
				objnc.setId_Nc(rs.getInt("id_Nc"));
				
				objnc.setDescricao_Nc(rs.getString("descricao_Nc"));
				objnc.setLocal_Nc(rs.getString("local_Nc"));
				objnc.setNome_Nc(rs.getString("nome_Nc"));
				objnc.setResponsavel_Nc(rs.getString("responsavel_NC"));
				objnc.setId_Plano(rs.getInt("id_Plano"));
				
				//debug descri��o
				//JOptionPane.showMessageDialog(null, objnc.getDescricao_Nc());
				lista.add(objnc);

			}
			
			
			
			
		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null, "NCDAO - pesquisarNC " + erro);
		}return lista;
	}
	
	public	ArrayList<EditNC> pesquisaeditar(String pesquisa){
		
		int idpesquisa = Integer.parseInt(pesquisa);
	
		
		try {
			
			String sql = "select * from naoConformidade where responsavel_Nc = " +"'"+ this.getRespNc() +"'"+ " and nome_Nc = " + idpesquisa;
			
			EditNC editarNc = new EditNC();
			
			conn = new ConexaoDAO().conectaDB();
			
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			
			
			while (rs.next()){
								
				editarNc.SetIdNc(rs.getInt("id_Nc"));
				
				editarNc.setDescricao(rs.getString("descricao_Nc"));
				editarNc.setLocalNC(rs.getString("local_Nc"));
				
				editarNc.setTxtNome(rs.getString("nome_Nc"));
				editarNc.setTxtResponsavelNc(rs.getString("responsavel_NC"));
				editarNc.SetIdplano(rs.getInt("id_Plano"));
				
				//debug descri��o
				//JOptionPane.showMessageDialog(null, objnc.getDescricao_Nc());
				editar.add(editarNc);

			}
			
			
			
			
		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null, "NCDAO - pesquisarNC " + erro);
		}return editar;
	}

}
