package bibliotecaComunitaria;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class principal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					principal frame = new principal();
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
	public principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1463, 783);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH); //Para Maximizar Ventana Tiene que ser en esta área
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPrincipal = new JLabel("Principal");
		lblPrincipal.setBounds(400, 25, 775, 111);
		lblPrincipal.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrincipal.setFont(new Font("Tahoma", Font.PLAIN, 30));
		contentPane.add(lblPrincipal);
		
		JButton btnRegistrarLibro = new JButton("Registrar Libro");
		btnRegistrarLibro.setBounds(531, 134, 488, 86);
		btnRegistrarLibro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registrarLibro abrirRegistrarLibro = new registrarLibro();
				abrirRegistrarLibro.setVisible(true);
				principal.this.dispose();
			}
		});
		contentPane.add(btnRegistrarLibro);
		
		JButton btnPrestarLibro = new JButton("Prestar Libro");
		btnPrestarLibro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				prestarLibro abrirPrestarLibro = new prestarLibro();
				abrirPrestarLibro.setVisible(true);
				principal.this.dispose();
			}
		});
		btnPrestarLibro.setBounds(531, 254, 488, 86);
		contentPane.add(btnPrestarLibro);
		
		JButton btnDevolverLibro = new JButton("Devolver Libro");
		btnDevolverLibro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				devolverLibro abrirDevolverLibro = new devolverLibro();
				abrirDevolverLibro.setVisible(true);
				principal.this.dispose();
			}
		});
		btnDevolverLibro.setBounds(531, 384, 488, 86);
		contentPane.add(btnDevolverLibro);
		
		JButton btnBuscarLibro = new JButton("Buscar Libro");
		btnBuscarLibro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscar abrirBuscar = new buscar();
				abrirBuscar.setVisible(true);
				principal.this.dispose();
			}
		});
		btnBuscarLibro.setBounds(538, 504, 481, 86);
		contentPane.add(btnBuscarLibro);
		
		JButton btnReportes = new JButton("Descargar reporte");
		btnReportes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reportes abrirReportes = new reportes();
				abrirReportes.setVisible(true);
				principal.this.dispose();
			}
		});
		btnReportes.setBounds(531, 629, 495, 86);
		contentPane.add(btnReportes);
		
		JButton btnCerrarSesion = new JButton("Cerrar Sesión");
		btnCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InicioSesion abrirInicioSesion = new InicioSesion();
				abrirInicioSesion.setVisible(true);
				principal.this.dispose();
			}
		});
		btnCerrarSesion.setBounds(1228, 25, 221, 53);
		contentPane.add(btnCerrarSesion);
	}

}
