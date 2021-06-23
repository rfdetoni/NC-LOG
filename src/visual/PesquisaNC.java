
package visual;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import DAO.NCDAO;
import DTO.NcDTO;

public class PesquisaNC extends javax.swing.JFrame {

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

	public PesquisaNC() {
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

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jLabel1.setText("Pesquisa por nome da NC:");

		tblPesquisa.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] { { null, null, null, null }, { null, null, null, null }, { null, null, null, null },
						{ null, null, null, null } },
				new String[] { "ID NC", "Nome ", "Responsável", "ID plano de ação" }));
		tblPesquisa.setColumnSelectionAllowed(true);
		scrollPesquisa.setViewportView(tblPesquisa);
		tblPesquisa.getColumnModel().getSelectionModel()
				.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

		btnPesquisarNC.setText("pesquisar");
		btnPesquisarNC.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnPesquisarNCActionPerformed(evt);
			}
		});

		btnOpen.setText("Abrir selecionado");
		btnOpen.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnOpenActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup()
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup().addGap(18, 18, 18).addComponent(jLabel1)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 257,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(12, 12, 12).addComponent(btnPesquisarNC).addGap(0, 0, Short.MAX_VALUE))
						.addComponent(scrollPesquisa, javax.swing.GroupLayout.Alignment.TRAILING)
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
								layout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE).addComponent(btnOpen)))
				.addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addGap(17, 17, 17)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel1)
						.addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(btnPesquisarNC))
				.addGap(19, 19, 19)
				.addComponent(scrollPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 275,
						javax.swing.GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(btnOpen)
				.addContainerGap(15, Short.MAX_VALUE)));

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
			java.util.logging.Logger.getLogger(PesquisaNC.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(PesquisaNC.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(PesquisaNC.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(PesquisaNC.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		}
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new PesquisaNC().setVisible(true);
			}
		});
	}

	public void resPesquisa() {
		try {
			NCDAO objNCDAO = new NCDAO();
			String pesquisa = txtPesquisa.getText();

			DefaultTableModel model = (DefaultTableModel) tblPesquisa.getModel();
			model.setNumRows(0);

			ArrayList<NcDTO> lista = objNCDAO.PesquisaNC(pesquisa);
			for (int num = 0; num < lista.size(); num++) {

				model.addRow(new Object[] {
						lista.get(num).getId_Nc(),
						lista.get(num).getNome_Nc(),
						lista.get(num).getResponsavel_Nc(),
						lista.get(num).getId_Plano()

				});

			}

		} catch (Exception erro) {
			JOptionPane.showMessageDialog(btnOpen, "PesquisarNC resPesquisa " + erro);
		}

	}
	
	private void CarregarCampos() {
		int setar = tblPesquisa.getSelectedRow();
		
		
		int id = Integer.parseInt((tblPesquisa.getModel().getValueAt(setar, 0).toString()));
			
		EditNC editar = new EditNC();
		editar.SetIdNc(id);
		

	}
	
	private void btnOpenActionPerformed(java.awt.event.ActionEvent evt) {
		EditNC abrir = new EditNC();
		abrir.setVisible(true);
		
	}
	
	// Variables declaration - do not modify
	private javax.swing.JButton btnOpen;
	private javax.swing.JButton btnPesquisarNC;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JScrollPane scrollPesquisa;
	private javax.swing.JTable tblPesquisa;
	private javax.swing.JTextField txtPesquisa;
	// End of variables declaration
}
