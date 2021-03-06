
package visual;

import java.util.ArrayList;

import javax.swing.DefaultCellEditor;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import DAO.PlanoDAO;
import DAO.UsuarioDAO;
import DTO.UsuarioDTO;
import DTO.VariaveisEstaticas;


import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class AtualizarUsuario extends javax.swing.JFrame {

	public AtualizarUsuario() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(AtualizarUsuario.class.getResource("/imagens/icon.jpg")));
		setTitle("Atualizar dados de usu\u00E1rio");
		initComponents();
		Pesquisar();
	}

	@SuppressWarnings("unchecked")
	
	private void initComponents() {

		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		txtNomeCompleto = new javax.swing.JTextField();
		jLabel3 = new javax.swing.JLabel();
		txtUsuario = new javax.swing.JTextField();
		txtUsuario.setEditable(false);
		txtEmail = new javax.swing.JTextField();
		jLabel4 = new javax.swing.JLabel();
		jLabel5 = new javax.swing.JLabel();
		txtPass = new javax.swing.JPasswordField();
		jLabel6 = new javax.swing.JLabel();
		txtDica = new javax.swing.JTextField();
		btnCancelar = new javax.swing.JButton();
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSalvar = new javax.swing.JButton();
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Salvar();
				Pesquisar();
			}
		});
		jScrollPane1 = new javax.swing.JScrollPane();
		tblFuncionario = new javax.swing.JTable();
		btnEditar = new javax.swing.JButton();
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Carregar();
			}
		});

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

		jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
		jLabel1.setText("Atualizar dados de usu?rio");

		jLabel2.setText("Nome Completo");

		jLabel3.setText("Nome de usu?rio");

		jLabel4.setText("Senha");

		jLabel5.setText("E-mail");

		jLabel6.setText("Dica de senha");

		btnCancelar.setText("Cancelar");

		btnSalvar.setText("Salvar");

		tblFuncionario.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"Nome de Usu\u00E1rio", "Nome Completo", "E-mail", "Dica de senha", "ID Usuario", "Senha"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				true, true, true, true, true, false
			};
			
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
			
			
		});
		tblFuncionario.getColumnModel().getColumn(3).setPreferredWidth(91);
		tblFuncionario.getColumnModel().getColumn(5).setPreferredWidth(0);
		TableColumnModel tcm = tblFuncionario.getColumnModel();
		tcm.removeColumn( tcm.getColumn(5) );
	
		
		jScrollPane1.setViewportView(tblFuncionario);

		btnEditar.setText("Editar Selecionado");

		JLabel lblNewLabel = new JLabel("ID");

		txtID = new JTextField();
		txtID.setEditable(false);
		txtID.setColumns(10);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		layout.setHorizontalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addGap(18)
					.addGroup(layout.createParallelGroup(Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
							.addGroup(layout.createParallelGroup(Alignment.LEADING)
								.addComponent(jLabel3)
								.addComponent(jLabel2)
								.addComponent(jLabel5)
								.addComponent(jLabel4))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(layout.createParallelGroup(Alignment.LEADING)
								.addComponent(txtEmail, 362, 362, 362)
								.addComponent(txtNomeCompleto, 362, 362, 362)
								.addGroup(layout.createSequentialGroup()
									.addComponent(txtUsuario, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblNewLabel)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(txtID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addComponent(txtPass, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE))
							.addGap(21))
						.addGroup(layout.createSequentialGroup()
							.addGap(29)
							.addComponent(btnCancelar)
							.addPreferredGap(ComponentPlacement.RELATED, 257, Short.MAX_VALUE)
							.addComponent(btnSalvar)
							.addGap(33))
						.addGroup(layout.createSequentialGroup()
							.addComponent(jLabel6)
							.addGap(18)
							.addComponent(txtDica, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
				.addGroup(layout.createSequentialGroup()
					.addContainerGap(344, Short.MAX_VALUE)
					.addComponent(btnEditar)
					.addContainerGap())
				.addGroup(layout.createSequentialGroup()
					.addGap(77)
					.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 312, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(86, Short.MAX_VALUE))
				.addGroup(layout.createSequentialGroup()
					.addContainerGap()
					.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(13, Short.MAX_VALUE))
		);
		layout.setVerticalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addGap(12)
					.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnEditar)
					.addGroup(layout.createParallelGroup(Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
							.addGap(28)
							.addGroup(layout.createParallelGroup(Alignment.BASELINE)
								.addComponent(jLabel3)
								.addComponent(txtUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel)
								.addComponent(txtID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(layout.createParallelGroup(Alignment.TRAILING)
								.addComponent(jLabel2)
								.addComponent(txtNomeCompleto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(layout.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel5))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(layout.createParallelGroup(Alignment.BASELINE)
								.addComponent(jLabel4)
								.addComponent(txtPass, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(layout.createParallelGroup(Alignment.BASELINE)
								.addComponent(jLabel6)
								.addComponent(txtDica, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(layout.createSequentialGroup()
							.addGap(198)
							.addGroup(layout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnCancelar)
								.addComponent(btnSalvar))))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		getContentPane().setLayout(layout);

		pack();
	}//

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {

		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(AtualizarUsuario.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(AtualizarUsuario.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(AtualizarUsuario.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(AtualizarUsuario.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		}
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new AtualizarUsuario().setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify
	private javax.swing.JButton btnCancelar;
	private javax.swing.JButton btnEditar;
	private javax.swing.JButton btnSalvar;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTable tblFuncionario;
	private javax.swing.JTextField txtDica;
	private javax.swing.JTextField txtEmail;
	private javax.swing.JTextField txtNomeCompleto;
	private javax.swing.JPasswordField txtPass;
	private javax.swing.JTextField txtUsuario;
	private JTextField txtID;
	// End of variables declaration

	public void Pesquisar() {

		try {
			UsuarioDAO objUserDAO = new UsuarioDAO();
			DefaultTableModel model = (DefaultTableModel) tblFuncionario.getModel();
			model.setNumRows(0);

			ArrayList<UsuarioDTO> lista = objUserDAO.PesquisarUsuario();
			for (int num = 0; num < lista.size(); num++) {
				model.addRow(new Object[] { lista.get(num).getNome_User(), lista.get(num).getNome_Completo(),
						lista.get(num).getEmail(), lista.get(num).getDica_Senha(), lista.get(num).getId_user(),
						lista.get(num).getSenha()

				});

			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Informe ao desenvolvedor > AtualizarUsuario - Carregar ","ERRO", JOptionPane.ERROR_MESSAGE);
		}

	}

	private void Carregar() { //carrega dados da linha selecionada na tabela;

		try {
			int setar = tblFuncionario.getSelectedRow();

			txtID.setText(tblFuncionario.getModel().getValueAt(setar, 4).toString());
			txtDica.setText(tblFuncionario.getModel().getValueAt(setar, 3).toString());
			txtEmail.setText(tblFuncionario.getModel().getValueAt(setar, 2).toString());
			txtNomeCompleto.setText(tblFuncionario.getModel().getValueAt(setar, 1).toString());
			txtUsuario.setText(tblFuncionario.getModel().getValueAt(setar, 0).toString());
			txtPass.setText(tblFuncionario.getModel().getValueAt(setar, 5).toString());

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Favor selecionar uma linha para visualizar ou editar");

		}

	}
	private void Salvar() {
		try {
			String nome_user,dica, email, nome_completo;
			nome_user = txtUsuario.getText();
			dica = txtDica.getText();
			email = txtEmail.getText();
			nome_completo = txtNomeCompleto.getText();
			String senha = new String(txtPass.getPassword());
			

			if(nome_user.equals("")) {
				JOptionPane.showMessageDialog(null, "Campo Usu?rio n?o pode estar vazio","AVISO", JOptionPane.WARNING_MESSAGE);
			}else if(nome_completo.equals("") ) {
				JOptionPane.showMessageDialog(null, "Campo Nome completo n?o pode estar vazio","AVISO", JOptionPane.WARNING_MESSAGE);
			}else if(email.equals("")) {
				JOptionPane.showMessageDialog(null, "Campo Email n?o pode estar vazio","AVISO", JOptionPane.WARNING_MESSAGE);
			} else if(senha.equals("") ) {
				JOptionPane.showMessageDialog(null, "Campo senha  n?o pode estar vazio","AVISO", JOptionPane.WARNING_MESSAGE);
			} else if(dica.equals("") ){
			JOptionPane.showMessageDialog(null, "Campo Dica de senha n?o pode estar vazio","AVISO", JOptionPane.WARNING_MESSAGE);
			}
			
			else {
			UsuarioDAO userDAO = new UsuarioDAO();
			UsuarioDTO userDTO = new UsuarioDTO();
		
			
			userDTO.setDica_Senha(dica);
			userDTO.setEmail(email);
			userDTO.setId_user(Integer.parseInt(txtID.getText()));
			userDTO.setNome_User(nome_user);
			userDTO.setNome_Completo(nome_completo);
			userDTO.setSenha(senha);
			
			if(userDAO.salvarUsuario(userDTO)) {
			//prevemos valida??o de cargo
				Pesquisar();
				VariaveisEstaticas.usuario_logado =nome_user;
				
			}
			
			
		} }catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Favor verificar informa??es - Erro: " + e);
		}
		
		
	}
	
}
