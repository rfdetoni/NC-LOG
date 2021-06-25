
package visual;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import DAO.NCDAO;
import DTO.NcDTO;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;

public class Home extends javax.swing.JFrame {

    
    public Home() {
        initComponents();
        listarNc();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblNC = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtUserON = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuInserirNC = new javax.swing.JMenuItem();
        menuInserirNC.setAction(action);
        menuPesquisarNC = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        menuPesquisaPlano = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("NC LOG");

        tblNC.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID NC", "Nome da NC", "Responsável", "Local"
            }
        ));
        jScrollPane1.setViewportView(tblNC);

        jLabel1.setText("Usu\u00E1rio conectado:");

        txtUserON.setEditable(false);

        jMenu1.setText("Não Conformidade");

        menuInserirNC.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        menuInserirNC.setText("Inserir nova");
        menuInserirNC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEditarNcActionPerformed(evt);
            }
        });
        jMenu1.add(menuInserirNC);
        menuInserirNC.getAccessibleContext().setAccessibleDescription("Inserir nova NC");

        menuPesquisarNC.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        menuPesquisarNC.setText("Pesquisar/Editar");
        menuPesquisarNC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuPesquisarActionPerformed(evt);
            }
        });
        jMenu1.add(menuPesquisarNC);
        menuPesquisarNC.getAccessibleContext().setAccessibleDescription("Pesquisar NC");

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Plano de Ação");

        menuPesquisaPlano.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.ALT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        menuPesquisaPlano.setText("Pesquisar/Editar plano de a\u00E7\u00E3o");
        jMenu2.add(menuPesquisaPlano);
        menuPesquisaPlano.getAccessibleContext().setAccessibleDescription("Pesquisar planos de ação existentes");

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Usuário");

        jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem5.setText("Alterar senha");
        jMenu3.add(jMenuItem5);
        jMenuItem5.getAccessibleContext().setAccessibleDescription("Alterar senha do usuário");

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 582, GroupLayout.PREFERRED_SIZE)
        					.addGap(11))
        				.addGroup(Alignment.TRAILING, layout.createSequentialGroup()
        					.addComponent(jLabel1)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(txtUserON, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
        					.addGap(14))))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(38)
        			.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 263, GroupLayout.PREFERRED_SIZE)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addPreferredGap(ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
        					.addComponent(jLabel1)
        					.addGap(14))
        				.addGroup(layout.createSequentialGroup()
        					.addGap(10)
        					.addComponent(txtUserON, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        					.addContainerGap())))
        );
        getContentPane().setLayout(layout);

        pack();
    }// </editor-fold>                        

    private void menuEditarNcActionPerformed(java.awt.event.ActionEvent evt) {                                             
        CreateNC cnc = new CreateNC();
        cnc.setVisible(true);
        dispose();
    }                                            

    private void menuPesquisarActionPerformed(java.awt.event.ActionEvent evt) {                                              
        PesquisaNC pesq = new PesquisaNC();
        pesq.setVisible(true);
       
    }                                             

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem menuInserirNC;
    private javax.swing.JMenuItem menuPesquisaPlano;
    private javax.swing.JMenuItem menuPesquisarNC;
    private javax.swing.JTable tblNC;
    private javax.swing.JTextField txtUserON;
    private final Action action = new SwingAction();
    private final Action action_1 = new SwingAction_1();
    // End of variables declaration       
    
    private void listarNc() { // adiciona os dados das NCs ao jTable;
		try {

			NCDAO objnc = new NCDAO();
			//this.setPesquisa(txtSearch.getText());

			DefaultTableModel model = (DefaultTableModel) tblNC.getModel();
			model.setNumRows(0);

			// cria um arrayList com os dados do objnc.pesquisarNC();
			ArrayList<NcDTO>	 lista = objnc.pesquisarNC();

			// transforma em tabela;
			for (int num = 0; num < lista.size(); num++) {
				model.addRow(new Object[] { lista.get(num).getId_Nc(), lista.get(num).getNome_Nc(),
						lista.get(num).getResponsavel_Nc(), lista.get(num).getLocal_Nc(),
						lista.get(num).getId_Plano(), lista.get(num).getDescricao_Nc() });

			}

		} catch (Exception erro) {
			JOptionPane.showMessageDialog(null, "HomeNC_2 listarNc " + erro);
		}

	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "SwingAction_1");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	
	public void setUser(String user) {
		txtUserON.setText(user);
		NCDAO ncdao = new NCDAO();
		ncdao.setRespNc(user);
		
		
	}
}
