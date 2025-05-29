package bibliotecaComunitaria;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JButton;

public class prestarLibro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNombreCliente;
	private JTextField textFechaPrestamo;
	private JTextField textFechaDevolucion;
	private JTextField textNombreLibro;
	private JTextField textAutor;
	private JTextField textCategoria;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					prestarLibro frame = new prestarLibro();
					frame.setVisible(true);
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH); //Maximiza la ventana
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
		lblDatosLibro.setBounds(457, 183, 105, 13);
		contentPane.add(lblDatosLibro);
		
		JLabel lblNombreLibro = new JLabel("Nombre del Libro:");
		lblNombreLibro.setBounds(373, 226, 124, 23);
		contentPane.add(lblNombreLibro);
		
		JLabel lblAutor = new JLabel("Autor:");
		lblAutor.setBounds(373, 352, 124, 23);
		contentPane.add(lblAutor);
		
		JLabel lblCliente = new JLabel("Cliente");
		lblCliente.setBounds(67, 175, 113, 29);
		contentPane.add(lblCliente);
		
		JLabel lblNombreCliente = new JLabel("Nombre:");
		lblNombreCliente.setBounds(10, 231, 61, 13);
		contentPane.add(lblNombreCliente);
		
		textNombreCliente = new JTextField();
		textNombreCliente.setBounds(94, 223, 219, 23);
		contentPane.add(textNombreCliente);
		textNombreCliente.setColumns(10);
		
		JLabel lblFechaPrestamos = new JLabel("Fecha de prestamo");
		lblFechaPrestamos.setBounds(10, 291, 88, 18);
		contentPane.add(lblFechaPrestamos);
		
		textFechaPrestamo = new JTextField();
		textFechaPrestamo.setBounds(110, 288, 203, 21);
		contentPane.add(textFechaPrestamo);
		textFechaPrestamo.setColumns(10);
		
		JLabel lblFechaDevolucion = new JLabel("Fecha de devolución:");
		lblFechaDevolucion.setBounds(10, 339, 88, 23);
		contentPane.add(lblFechaDevolucion);
		
		textFechaDevolucion = new JTextField();
		textFechaDevolucion.setBounds(110, 339, 208, 23);
		contentPane.add(textFechaDevolucion);
		textFechaDevolucion.setColumns(10);
		
		JButton btnPrestarLibro = new JButton("Prestar libro");
		btnPrestarLibro.setBounds(10, 444, 312, 53);
		contentPane.add(btnPrestarLibro);
		
		textNombreLibro = new JTextField();
		textNombreLibro.setBounds(498, 226, 179, 23);
		contentPane.add(textNombreLibro);
		textNombreLibro.setColumns(10);
		
		textAutor = new JTextField();
		textAutor.setBounds(500, 353, 177, 21);
		contentPane.add(textAutor);
		textAutor.setColumns(10);
		
		JLabel lblCategoria = new JLabel("Categoría:");
		lblCategoria.setBounds(372, 291, 105, 13);
		contentPane.add(lblCategoria);
		
		textCategoria = new JTextField();
		textCategoria.setBounds(502, 291, 175, 23);
		contentPane.add(textCategoria);
		textCategoria.setColumns(10);
		
		JLabel lblExistencias = new JLabel("Existencias:");
		lblExistencias.setBounds(373, 409, 88, 23);
		contentPane.add(lblExistencias);
		
		textField = new JTextField();
		textField.setBounds(498, 409, 179, 23);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblLibros = new JLabel("Libros");
		lblLibros.setBounds(767, 179, 150, 21);
		contentPane.add(lblLibros);
		
		JList list = new JList();
		list.setBounds(767, 226, 602, 209);
		contentPane.add(list);
		
		JButton btnCargarDatos = new JButton("Cargar datos");
		btnCargarDatos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCargarDatos.setBounds(856, 460, 433, 59);
		contentPane.add(btnCargarDatos);
	}
}
