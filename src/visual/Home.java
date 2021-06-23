
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
        menuEditarNC = new javax.swing.JMenuItem();
        menuEditarNC.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		EditNC edit = new EditNC();
        		edit.setVisible(true);
        	}
        });
        menuEditarNC.setAction(action_1);
        menuPesquisarNC = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        menuEditPlano = new javax.swing.JMenuItem();
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

        jLabel1.setText("Usuário");

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

        menuEditarNC.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        menuEditarNC.setText("Editar NC");
        jMenu1.add(menuEditarNC);
        menuEditarNC.getAccessibleContext().setAccessibleDescription("Editar NC");

        menuPesquisarNC.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        menuPesquisarNC.setText("Pesquisar");
        menuPesquisarNC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuPesquisarActionPerformed(evt);
            }
        });
        jMenu1.add(menuPesquisarNC);
        menuPesquisarNC.getAccessibleContext().setAccessibleDescription("Pesquisar NC");

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Plano de Ação");

        menuEditPlano.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.ALT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        menuEditPlano.setText("Editar Plano de ação");
        jMenu2.add(menuEditPlano);
        menuEditPlano.getAccessibleContext().setAccessibleDescription("Editar plano de ação existente");

        menuPesquisaPlano.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.ALT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        menuPesquisaPlano.setText("Pesquisar plano de ação");
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
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtUserON, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(19, 19, 19))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtUserON, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>                        

    private void menuEditarNcActionPerformed(java.awt.event.ActionEvent evt) {                                             
        CreateNC cnc = new CreateNC();
        cnc.setVisible(true);
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
    private javax.swing.JMenuItem menuEditarNC;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem menuEditPlano;
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
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "SwingAction_1");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
