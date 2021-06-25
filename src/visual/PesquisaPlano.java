
package visual;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import DAO.NCDAO;
import DAO.PlanoDAO;
import DTO.NcDTO;
import DTO.PlanoDTO;

import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PesquisaPlano extends javax.swing.JFrame {

	private static String nome_NC, local_NC, responsavel_NC;
	private static int id_NC, id_Plano;

	public String getNome_NC() {
		return nome_NC;
	}

	public void setNome_NC(String nome_NC) {
		this.nome_NC = nome_NC;
	}

	public String getLocal_NC() {
		return local_NC;
	}

	public void setLocal_NC(String local_NC) {
		this.local_NC = local_NC;
	}

	public String getResponsavel_NC() {
		return responsavel_NC;
	}

	public void setResponsavel_NC(String responsavel_NC) {
		this.responsavel_NC = responsavel_NC;
	}

	public int getId_NC() {
		return id_NC;
	}

	public void setId_NC(int id_NC) {
		this.id_NC = id_NC;
	}

	public int getId_Plano() {
		return id_Plano;
	}

	public void setId_Plano(int id_Plano) {
		this.id_Plano = id_Plano;
	}

	public PesquisaPlano() {
		initComponents();
	}

	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jLabel1 = new javax.swing.JLabel();
		txtPesquisa = new javax.swing.JTextField();
		scrollPesquisa = new javax.swing.JScrollPane();
		tblPesquisa = new javax.swing.JTable();
		btnPesquisarNC = new javax.swing.JButton();
		btnOpen = new javax.swing.JButton();
		btnOpen.setToolTipText("Visualizar ou editar NC selecionada");

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

		jLabel1.setText("Pesquisa por estrat\u00E9gia");

		tblPesquisa.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"ID Plano", "Respons\u00E1vel", "Nome ", "Estrat\u00E9gia", "Data de Cria\u00E7\u00E3o", "ID NC"
			}
		));
		tblPesquisa.getColumnModel().getColumn(1).setPreferredWidth(93);
		tblPesquisa.getColumnModel().getColumn(2).setPreferredWidth(78);
		tblPesquisa.getColumnModel().getColumn(3).setPreferredWidth(82);
		tblPesquisa.getColumnModel().getColumn(4).setPreferredWidth(100);
		tblPesquisa.setColumnSelectionAllowed(true);
		scrollPesquisa.setViewportView(tblPesquisa);

		btnPesquisarNC.setText("pesquisar");
		btnPesquisarNC.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnPesquisarNCActionPerformed(evt);
			}
		});

		btnOpen.setText("Visualizar/editar");
		btnOpen.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnOpenActionPerformed(evt);
			}
		});
		
		JLabel lblNewLabel = new JLabel("Nome do plano");
		
		txtNomePlano = new JTextField();
		txtNomePlano.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Respons\u00E1vel:");
		
		txtResponsavel = new JTextField();
		txtResponsavel.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("ID da NC");
		
		txtIdNC = new JTextField();
		txtIdNC.setEditable(false);
		txtIdNC.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("ID Plano de A\u00E7\u00E3o");
		
		txtPlano = new JTextField();
		txtPlano.setEditable(false);
		txtPlano.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Estrat\u00E9gia");
		
		JButton btnNewButton = new JButton("Salvar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SalvarEdit();
			}
		});
		
		JSeparator separator = new JSeparator();
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		txtEstrategia = new JTextPane();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addComponent(lblNewLabel_3)
					.addGap(22)
					.addComponent(txtIdNC, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblNewLabel_4)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtPlano, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(216))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addComponent(lblNewLabel)
					.addGap(2)
					.addComponent(txtNomePlano, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(lblNewLabel_1)
					.addGap(10)
					.addComponent(txtResponsavel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(175))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(250)
					.addComponent(lblNewLabel_5))
				.addComponent(separator, GroupLayout.DEFAULT_SIZE, 575, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(431, Short.MAX_VALUE)
					.addComponent(btnVoltar)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnNewButton)
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(456, Short.MAX_VALUE)
					.addComponent(btnOpen)
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPesquisa, GroupLayout.DEFAULT_SIZE, 547, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(jLabel1)
							.addGap(18)
							.addComponent(txtPesquisa, GroupLayout.PREFERRED_SIZE, 257, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnPesquisarNC)))
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(txtEstrategia, GroupLayout.DEFAULT_SIZE, 555, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(jLabel1)
						.addComponent(txtPesquisa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnPesquisarNC))
					.addGap(20)
					.addComponent(scrollPesquisa, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnOpen)
					.addGap(11)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 11, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNewLabel_3))
						.addComponent(txtIdNC, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_4)
								.addComponent(txtPlano, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addGap(11)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNewLabel))
						.addComponent(txtNomePlano, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNewLabel_1))
						.addComponent(txtResponsavel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(lblNewLabel_5)
					.addGap(13)
					.addComponent(txtEstrategia, GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnVoltar))
					.addGap(12))
		);
		getContentPane().setLayout(groupLayout);

		pack();
	}// </editor-fold>

	

	private void btnPesquisarNCActionPerformed(java.awt.event.ActionEvent evt) {
		resPesquisa();
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		// <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
		// (optional) ">
		/*
		 * If Nimbus (introduced in Java SE 6) is not available, stay with the default
		 * look and feel. For details see
		 * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(PesquisaPlano.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(PesquisaPlano.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(PesquisaPlano.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(PesquisaPlano.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		}
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new PesquisaPlano().setVisible(true);
			}
		});
	}

	public void resPesquisa() {
		try {
			PlanoDAO objPlanoDAO = new PlanoDAO();
			String pesquisa = txtPesquisa.getText();

			DefaultTableModel model = (DefaultTableModel) tblPesquisa.getModel();
			model.setNumRows(0);

			ArrayList<PlanoDTO> lista = objPlanoDAO.PesquisaPlano(pesquisa);
			for (int num = 0; num < lista.size(); num++) {

				model.addRow(new Object[] {
						lista.get(num).getId_Nc(),
						lista.get(num).getNome_Criador(),
						lista.get(num).getTime_resp(),
						lista.get(num).getId_Plano(),
						lista.get(num).getEstrategia(),
						lista.get(num).getExec_plano()

				});

			}

		} catch (Exception erro) {
			JOptionPane.showMessageDialog(null, "PesquisarNC resPesquisa " + erro);
		}

	}

	
	private void btnOpenActionPerformed(java.awt.event.ActionEvent evt) {
		resPesquisa();
		

		
	}
	
	// Variables declaration - do not modify
	private javax.swing.JButton btnOpen;
	private javax.swing.JButton btnPesquisarNC;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JScrollPane scrollPesquisa;
	private javax.swing.JTable tblPesquisa;
	private javax.swing.JTextField txtPesquisa;
	private JTextField txtNomePlano;
	private JTextField txtResponsavel;
	private JTextField txtIdNC;
	private JTextField txtPlano;
	private JButton btnVoltar;
	private JTextPane txtEstrategia;
	
	
	//carrega dados da planilha para campo de edição
	private  void Carregar() {
		try {
			int setar = tblPesquisa.getSelectedRow();
			
			
			//txtIdNC.setText(tblPesquisa.getModel().getValueAt(setar, 0).toString());
			txtPlano.setText(tblPesquisa.getModel().getValueAt(setar, 0).toString());
			
			txtNomePlano.setText(tblPesquisa.getModel().getValueAt(setar, 1).toString());
			txtResponsavel.setText(tblPesquisa.getModel().getValueAt(setar, 2).toString());	
			
			txtEstrategia.setText(tblPesquisa.getModel().getValueAt(setar, 4).toString());
		
			}
			catch(Exception e){
				JOptionPane.showMessageDialog(null, "Favor selecionar uma linha para visualizar ou editar");
				
			}
			
		
	}
	
	
	private void SalvarEdit() {
		int id_NC;
		
		String nome_Nc, responsavel_nc, local, descricao;
		
		id_NC =Integer.parseInt(txtIdNC.getText());
		nome_Nc = txtNomePlano.getText();
		responsavel_nc = txtResponsavel.getText();
	
		descricao = txtEstrategia.getText();
		
		NcDTO objncDTO = new NcDTO();
		
		objncDTO.setId_Nc(id_NC);
		objncDTO.setDescricao_Nc(descricao);
		
		objncDTO.setNome_Nc(nome_Nc);
		objncDTO.setResponsavel_Nc(responsavel_nc);
		
		NCDAO objncdao = new NCDAO();
		objncdao.EditarNC(objncDTO);
		
		
		
		
		
	}
}
