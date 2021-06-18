package visual;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.DropMode;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.SwingConstants;

public class LoginPrincipal {

	private JFrame frame;
	private JTextField txtUsuario;
	private JPasswordField txtSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPrincipal window = new LoginPrincipal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel labelUsuario = new JLabel("Usuario");
		labelUsuario.setFont(new Font("Tahoma", Font.BOLD, 11));
		labelUsuario.setBounds(118, 136, 46, 14);
		frame.getContentPane().add(labelUsuario);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(171, 133, 86, 20);
		frame.getContentPane().add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel labelSenha = new JLabel("Senha");
		labelSenha.setFont(new Font("Tahoma", Font.BOLD, 11));
		labelSenha.setBounds(118, 167, 46, 14);
		frame.getContentPane().add(labelSenha);
		
		txtSenha = new JPasswordField();
		txtSenha.setEchoChar('*');
		txtSenha.setBounds(171, 164, 86, 20);
		frame.getContentPane().add(txtSenha);
		
		JButton btLogin = new JButton("Entrar");
		btLogin.setForeground(Color.BLACK);
		btLogin.setBounds(168, 207, 89, 23);
		frame.getContentPane().add(btLogin);
		
		JLabel lblNewLabel_1 = new JLabel("NC LOG");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(177, 51, 68, 31);
		frame.getContentPane().add(lblNewLabel_1);
	}
}
