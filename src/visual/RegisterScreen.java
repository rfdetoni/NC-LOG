package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.UsuarioDAO;
import DTO.UsuarioDTO;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class RegisterScreen extends JFrame {

	private JPanel contentPane;
	private JTextField txtSetUserRegister;
	private JPasswordField txtSetUserPassword;
	private JTextField txtSetPasswordTip;
	private JTextField txtNomeCompleto;
	private JTextField txtEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterScreen frame = new RegisterScreen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RegisterScreen() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(RegisterScreen.class.getResource("/imagens/icon.jpg")));
		setTitle("NC LOG - Registro");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRegistreSe = new JLabel("Registre-se");
		lblRegistreSe.setFont(new Font("Tahoma", Font.BOLD, 32));
		lblRegistreSe.setBounds(133, 17, 190, 38);
		contentPane.add(lblRegistreSe);
		
		JLabel lblRegisterUser = new JLabel("Usuario");
		lblRegisterUser.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblRegisterUser.setBounds(133, 66, 46, 14);
		contentPane.add(lblRegisterUser);
		
		txtSetUserRegister = new JTextField(); // Espa�o para o user digitar o usuario (getText)
		txtSetUserRegister.setColumns(10);
		txtSetUserRegister.setBounds(180, 66, 128, 20);
		contentPane.add(txtSetUserRegister);
		
		JLabel lblPassword = new JLabel("Senha");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPassword.setBounds(133, 158, 46, 14);
		contentPane.add(lblPassword);
		
		txtSetUserPassword = new JPasswordField(); // Espa�o para o user digitar a senha (getText)
		txtSetUserPassword.setEchoChar('*');
		txtSetUserPassword.setBounds(180, 155, 86, 20);
		contentPane.add(txtSetUserPassword);
		
		JButton btRegistrarUser = new JButton("Registrar");
		btRegistrarUser.addActionListener(new ActionListener() {
			/**
			 * A��o do bot�o para Registrar
			 * Colocar em baixo o metodo que insera o usuario no sistema
			 * e abre a tela de LoginPincipal.java denovo.
			 */
			public void actionPerformed(ActionEvent e) {
			UsuarioDTO reg = new UsuarioDTO();
			String passText = new String(txtSetUserPassword.getPassword());
			
			reg.setNome_User(txtSetUserRegister.getText());
			reg.setSenha(passText);
			reg.setDica_Senha(txtSetPasswordTip.getText());	
			reg.setEmail(txtEmail.getText());
			reg.setNome_Completo(txtNomeCompleto.getText());
			
			UsuarioDAO objuserdao = new UsuarioDAO();
			objuserdao.registerUser(reg);
			
			
			Login maincallback = new Login();
			maincallback.setVisible(true);
			dispose();
				
			}
		});
		btRegistrarUser.setFont(new Font("Tahoma", Font.BOLD, 11));
		btRegistrarUser.setBounds(234, 215, 89, 23);
		contentPane.add(btRegistrarUser);
		
		/**
		 * DICA DA SENHA
		 */
		
		JLabel lblDicaDeSenha = new JLabel("Dica de senha");
		lblDicaDeSenha.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDicaDeSenha.setBounds(94, 184, 86, 14);
		contentPane.add(lblDicaDeSenha);
		
		txtSetPasswordTip = new JTextField();
		txtSetPasswordTip.setColumns(10);
		txtSetPasswordTip.setBounds(180, 184, 86, 20);
		contentPane.add(txtSetPasswordTip);
		
// Fim dica da senha
		
		JButton btCancel = new JButton("Cancelar");  // Bota�o cancelar (VOLTA PARA O MainScreen)
		btCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Login maincallback = new Login();
				maincallback.setVisible(true);
			}
		});
		btCancel.setFont(new Font("Tahoma", Font.BOLD, 11));
		btCancel.setBounds(121, 215, 89, 23);
		contentPane.add(btCancel);
		
		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(143, 95, 36, 16);
		contentPane.add(lblNewLabel);
		
		txtNomeCompleto = new JTextField();
		txtNomeCompleto.setBounds(180, 92, 128, 22);
		contentPane.add(txtNomeCompleto);
		txtNomeCompleto.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("E-mail");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(132, 123, 47, 16);
		contentPane.add(lblNewLabel_1);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(180, 123, 128, 22);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
	}
}
