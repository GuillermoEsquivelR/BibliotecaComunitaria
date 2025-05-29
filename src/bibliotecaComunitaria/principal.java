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
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // Maximiza la ventana
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
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPrincipal = new JLabel("Principal");
		lblPrincipal.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrincipal.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblPrincipal.setBounds(400, 25, 775, 111);
		contentPane.add(lblPrincipal);
		
		JButton btnRegistrarLibro = new JButton("Registrar Libro");
		btnRegistrarLibro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRegistrarLibro.setBounds(531, 134, 488, 86);
		contentPane.add(btnRegistrarLibro);
		
		JButton btnPrestarLibro = new JButton("Prestar Libro");
		btnPrestarLibro.setBounds(531, 254, 488, 86);
		contentPane.add(btnPrestarLibro);
		
		JButton btnDevolverLibro = new JButton("Devolver Libro");
		btnDevolverLibro.setBounds(531, 384, 488, 86);
		contentPane.add(btnDevolverLibro);
		
		JButton btnBuscarLibro = new JButton("Buscar Libro");
		btnBuscarLibro.setBounds(538, 504, 481, 86);
		contentPane.add(btnBuscarLibro);
		
		JButton btnReportes = new JButton("Descargar reporte");
		btnReportes.setBounds(531, 629, 495, 86);
		contentPane.add(btnReportes);
	}

}
