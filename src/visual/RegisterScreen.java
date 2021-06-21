package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.RegisterDAO;
import DAO.UsuarioDAO;
import DTO.UsuarioDTO;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegisterScreen extends JFrame {

	private JPanel contentPane;
	private JTextField txtSetUserRegister;
	private JPasswordField txtSetUserPassword;
	private JTextField txtSetPasswordTip;

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
		setTitle("NC LOG");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRegistreSe = new JLabel("Registre-se");
		lblRegistreSe.setFont(new Font("Tahoma", Font.BOLD, 32));
		lblRegistreSe.setBounds(118, 43, 190, 38);
		contentPane.add(lblRegistreSe);
		
		JLabel lblRegisterUser = new JLabel("Usuario");
		lblRegisterUser.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblRegisterUser.setBounds(133, 108, 46, 14);
		contentPane.add(lblRegisterUser);
		
		txtSetUserRegister = new JTextField(); // Espaço para o user digitar o usuario (getText)
		txtSetUserRegister.setColumns(10);
		txtSetUserRegister.setBounds(180, 105, 86, 20);
		contentPane.add(txtSetUserRegister);
		
		JLabel lblPassword = new JLabel("Senha");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPassword.setBounds(133, 140, 46, 14);
		contentPane.add(lblPassword);
		
		txtSetUserPassword = new JPasswordField(); // Espaço para o user digitar a senha (getText)
		txtSetUserPassword.setEchoChar('*');
		txtSetUserPassword.setBounds(180, 137, 86, 20);
		contentPane.add(txtSetUserPassword);
		
		JButton btRegistrarUser = new JButton("Registrar");
		btRegistrarUser.addActionListener(new ActionListener() {
			/**
			 * Ação do botão para Registrar
			 * Colocar em baixo o metodo que insera o usuario no sistema
			 * e abre a tela de LoginPincipal.java denovo.
			 */
			public void actionPerformed(ActionEvent e) {
			UsuarioDTO reg = new UsuarioDTO();
			String passText = new String(txtSetUserPassword.getPassword());
			
			reg.setNome_User(txtSetUserRegister.getText());
			reg.setSenha(passText);
			reg.setDica_Senha(txtSetPasswordTip.getText());	
			
			RegisterDAO objuserdao = new RegisterDAO();
			objuserdao.registerUser(reg);
			
			
			Login maincallback = new Login();
			maincallback.setVisible(true);
			dispose();
				
			}
		});
		btRegistrarUser.setFont(new Font("Tahoma", Font.BOLD, 11));
		btRegistrarUser.setBounds(118, 210, 89, 23);
		contentPane.add(btRegistrarUser);
		
		/**
		 * DICA DA SENHA
		 */
		
		JLabel lblDicaDeSenha = new JLabel("Dica de senha");
		lblDicaDeSenha.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDicaDeSenha.setBounds(93, 171, 86, 14);
		contentPane.add(lblDicaDeSenha);
		
		txtSetPasswordTip = new JTextField();
		txtSetPasswordTip.setColumns(10);
		txtSetPasswordTip.setBounds(180, 168, 86, 20);
		contentPane.add(txtSetPasswordTip);
		
// Fim dica da senha
		
		JButton btCancel = new JButton("Cancelar");  // Botaão cancelar (VOLTA PARA O MainScreen)
		btCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Login maincallback = new Login();
				maincallback.setVisible(true);
			}
		});
		btCancel.setFont(new Font("Tahoma", Font.BOLD, 11));
		btCancel.setBounds(231, 210, 89, 23);
		contentPane.add(btCancel);
	}
}
