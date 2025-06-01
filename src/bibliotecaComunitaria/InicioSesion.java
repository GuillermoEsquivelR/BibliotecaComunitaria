package bibliotecaComunitaria;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InicioSesion extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textUsuario;
	private JPasswordField passContrasena;
	
	String usuario = "Admin";
	String contraseña = "admin12345";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InicioSesion frame = new InicioSesion();
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
	public InicioSesion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1463, 766);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH); //Para maximizar Ventana Tiene que ser en esta área
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblUsuario.setBounds(317, 249, 248, 108);
		contentPane.add(lblUsuario);
		
		JLabel lblNewLabel = new JLabel("Contraseña");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(300, 376, 301, 114);
		contentPane.add(lblNewLabel);
		
		JLabel lblInicioSesion = new JLabel("Inicio de Sesión");
		lblInicioSesion.setFont(new Font("Tahoma", Font.PLAIN, 50));
		lblInicioSesion.setHorizontalAlignment(SwingConstants.CENTER);
		lblInicioSesion.setBounds(513, 32, 539, 140);
		contentPane.add(lblInicioSesion);
		
		textUsuario = new JTextField();
		textUsuario.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textUsuario.setBounds(572, 271, 539, 57);
		contentPane.add(textUsuario);
		textUsuario.setColumns(10);
		
		JButton btnIniciarSesion = new JButton("Iniciar Sesión");
		btnIniciarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String verificarUsuario = textUsuario.getText();
				String verificarContraseña = String.valueOf(passContrasena.getPassword());
					if (usuario.equals(verificarUsuario) && contraseña.equals(verificarContraseña)) {
					principal abrirPrincipal = new principal();
					abrirPrincipal.setVisible(true); 
					InicioSesion.this.dispose();	
					} else {
					JOptionPane.showMessageDialog(null, "El usuario o la contraseña es incorrecta", "No se puede iniciar sesión", JOptionPane.ERROR_MESSAGE);
					}	
			}
		});
		btnIniciarSesion.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnIniciarSesion.setBounds(572, 573, 419, 75);
		contentPane.add(btnIniciarSesion);
		
		passContrasena = new JPasswordField();
		passContrasena.setFont(new Font("Tahoma", Font.PLAIN, 25));
		passContrasena.setBounds(572, 411, 544, 57);
		contentPane.add(passContrasena);
	}
}
