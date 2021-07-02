
package visual;

import java.util.Date;

import DAO.NCDAO;
import DAO.PlanoDAO;
import DTO.NcDTO;
import DTO.PlanoDTO;
import DTO.VariaveisEstaticas;

import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.GroupLayout;
import javax.swing.JTextField;
import javax.swing.JFrame;
import java.awt.Toolkit;

public class CreatePlanodeAcao extends javax.swing.JFrame {
	
	public static int id_nc;

    /**
     * Creates new form CreateNC
     */
    public CreatePlanodeAcao() {
    	setIconImage(Toolkit.getDefaultToolkit().getImage(CreatePlanodeAcao.class.getResource("/imagens/icon.jpg")));
        initComponents();
        Load();
   
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtNome_planodeacao = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtnome_criador = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txttime_resp = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblresponsavel_Nc = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblnome_Nc = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblLocal = new javax.swing.JLabel();

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Criar plano de a\u00E7\u00E3o");
        setLocationByPlatform(true);

        jLabel1.setText("Titulo do plano de a\u00E7\u00E3o");

        jLabel2.setText("Criador");

        jLabel3.setText("Time Respons\u00E1vel");

        txttime_resp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttime_respActionPerformed(evt);
            }
        });

        jLabel4.setText("Descri\u00E7\u00E3o do Plano de A\u00E7\u00E3o");

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnSalvar.setText("Salvar"); // bt salvar
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));

        jLabel5.setText("N\u00E3o conformidade N\u00BA:");

        jLabel6.setText("Respons\u00E1vel NC: ");

        lblresponsavel_Nc.setText(" ");

        jLabel8.setText("Nome da NC:");

        lblnome_Nc.setText(" ");

        jLabel9.setText("Local:");

        lblLocal.setText(" ");
        
        txtidnc = new JTextField();
        txtidnc.setEditable(false);
        txtidnc.setColumns(10);
        
        txtresp = new JTextField();
        txtresp.setEditable(false);
        txtresp.setColumns(10);
        
        txtNomeNC = new JTextField();
        txtNomeNC.setEditable(false);
        txtNomeNC.setColumns(10);
        
        txtLocal = new JTextField();
        txtLocal.setEditable(false);
        txtLocal.setColumns(10);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1Layout.setHorizontalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addGap(12)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(jLabel5)
        				.addComponent(jLabel6)
        				.addComponent(jLabel8)
        				.addComponent(jLabel9))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(txtidnc, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING)
        						.addComponent(txtNomeNC, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
        						.addComponent(txtresp, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
        						.addComponent(txtLocal, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE))
        					.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        						.addGroup(jPanel1Layout.createSequentialGroup()
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addComponent(lblresponsavel_Nc, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addComponent(jLabel7, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE))
        						.addGroup(Alignment.TRAILING, jPanel1Layout.createParallelGroup(Alignment.LEADING)
        							.addGroup(jPanel1Layout.createSequentialGroup()
        								.addGap(6)
        								.addComponent(lblLocal, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE))
        							.addComponent(lblnome_Nc, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)))))
        			.addGap(59))
        );
        jPanel1Layout.setVerticalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel5)
        				.addComponent(txtidnc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel6)
        				.addComponent(jLabel7)
        				.addComponent(lblresponsavel_Nc)
        				.addComponent(txtresp, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel8)
        				.addComponent(lblnome_Nc)
        				.addComponent(txtNomeNC, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel9)
        				.addComponent(lblLocal)
        				.addComponent(txtLocal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel1.setLayout(jPanel1Layout);
        txtestrategia = new javax.swing.JTextArea();
        
                txtestrategia.setColumns(20);
                txtestrategia.setRows(5);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(154)
        			.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(btnCancelar, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        					.addGap(146)
        					.addComponent(btnSalvar, GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
        					.addGap(137))
        				.addGroup(layout.createSequentialGroup()
        					.addGap(99)
        					.addComponent(jLabel4, GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE)
        					.addGap(245))))
        		.addGroup(Alignment.LEADING, layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        				.addGroup(layout.createSequentialGroup()
        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(jLabel2, GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
        						.addComponent(jLabel1, GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
        						.addComponent(txtNome_planodeacao, 178, 178, 178)
        						.addComponent(txtnome_criador, 178, 178, 178)
        						.addComponent(jLabel3)
        						.addComponent(txttime_resp, GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE))
        					.addGap(72)
        					.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 508, GroupLayout.PREFERRED_SIZE))
        				.addComponent(txtestrategia, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 775, GroupLayout.PREFERRED_SIZE))
        			.addContainerGap(41, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(15)
        			.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        				.addGroup(Alignment.LEADING, layout.createSequentialGroup()
        					.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        					.addGap(68)
        					.addComponent(jLabel4))
        				.addGroup(Alignment.LEADING, layout.createSequentialGroup()
        					.addComponent(jLabel1)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(txtNome_planodeacao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(jLabel2)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(txtnome_criador, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(jLabel3)
        					.addGap(18)
        					.addComponent(txttime_resp, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
        			.addGap(23)
        			.addComponent(txtestrategia, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(btnCancelar)
        				.addComponent(btnSalvar))
        			.addGap(52))
        );
        getContentPane().setLayout(layout);

        pack();
    }// </editor-fold>                        

    private void txttime_respActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
    }                                            

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {                                            
      
    	dispose();
    }                                           

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {                                          
       PlanoDTO plan = new PlanoDTO();

       plan.setNome_Criador(txtnome_criador.getText());
       plan.setNome_Plano(txtNome_planodeacao.getText());
       plan.setEstrategia(txtestrategia.getText());
       plan.setTime_resp(txttime_resp.getText());
       plan.setId_Nc(Integer.parseInt(txtidnc.getText()));

       PlanoDAO pldao = new PlanoDAO();
       pldao.registerPlan(plan);
       dispose();
       PesquisaPlano pp = new PesquisaPlano();
       pp.resPesquisa();
       pp.setVisible(true);
       
     
    }                                         

    public static void main(String args[]) {
     
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CreatePlanodeAcao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreatePlanodeAcao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreatePlanodeAcao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreatePlanodeAcao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CreatePlanodeAcao().setVisible(true);
            }
        });
    }
    
    private void Load() {
    	
    	VariaveisEstaticas ve = new VariaveisEstaticas();
    	txtidnc.setText(Integer.toString(ve.getId_nc())); 
    	txtNomeNC.setText(ve.getNome_nc());
    	txtresp.setText(ve.getResponsavel());
    	txtLocal.setText(ve.getLocal());
    	
    	
    }
    public void dados(NcDTO objncDTO) {

    	txtidnc.setText(Integer.toString(objncDTO.getId_Nc()));
    	txtLocal.setText(objncDTO.getLocal_Nc());
    	txtNomeNC.setText(objncDTO.getNome_Nc());
    	txtresp.setText(objncDTO.getResponsavel_Nc());

    	
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblLocal;
    private javax.swing.JLabel lblnome_Nc;
    private javax.swing.JLabel lblresponsavel_Nc;
    private javax.swing.JTextField txtNome_planodeacao;
    private javax.swing.JTextArea txtestrategia;
    private javax.swing.JTextField txtnome_criador;
    private javax.swing.JTextField txttime_resp;
    private JTextField txtidnc;
    private JTextField txtresp;
    private JTextField txtNomeNC;
    private JTextField txtLocal;
    // End of variables declaration                   
}
