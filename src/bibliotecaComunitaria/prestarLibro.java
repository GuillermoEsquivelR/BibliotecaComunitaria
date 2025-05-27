package bibliotecaComunitaria;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JList;

public class prestarLibro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					prestarLibro frame = new prestarLibro();
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
	public prestarLibro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1462, 782);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPrestarLibro = new JLabel("Prestar libro");
		lblPrestarLibro.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblPrestarLibro.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrestarLibro.setBounds(320, 34, 878, 67);
		contentPane.add(lblPrestarLibro);
		
		JLabel lblDatosLibro = new JLabel("Datos del Libro");
		lblDatosLibro.setBounds(171, 160, 105, 13);
		contentPane.add(lblDatosLibro);
		
		JLabel lblNombreLibro = new JLabel("Nombre del Libro:");
		lblNombreLibro.setBounds(58, 194, 124, 23);
		contentPane.add(lblNombreLibro);
		
		JLabel lblAutor = new JLabel("Autor:");
		lblAutor.setBounds(58, 242, 124, 23);
		contentPane.add(lblAutor);
		
		JList list = new JList();
		list.setBounds(557, 137, 831, 527);
		contentPane.add(list);
	}
}
