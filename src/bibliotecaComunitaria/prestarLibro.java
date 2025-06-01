package bibliotecaComunitaria;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class prestarLibro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNombreCliente;
	private JTextField textDiaPrestamo;
	private JTextField textDiaDevolucion;
	DefaultListModel modeloLibros = new DefaultListModel <>();
	ArrayList<libro> listaLibros = new ArrayList<>();
	ResultSet resultado;
	boolean datosCargados = false;
	private JTextField textMesPrestamo;
	private JTextField textAñoPrestamo;
	private JTextField textMesDevolucion;
	private JTextField textAñoDevolucion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					prestarLibro frame = new prestarLibro();
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
	public prestarLibro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1462, 782);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH); //Para maximizar la ventana tiene que ser en esta área
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
		lblNombreLibro.setBounds(457, 250, 124, 23);
		contentPane.add(lblNombreLibro);
		
		JLabel lblAutor = new JLabel("Autor:");
		lblAutor.setBounds(457, 352, 124, 23);
		contentPane.add(lblAutor);
		
		JLabel lblCliente = new JLabel("Cliente");
		lblCliente.setBounds(67, 175, 113, 29);
		contentPane.add(lblCliente);
		
		JLabel lblNombreCliente = new JLabel("Nombre:");
		lblNombreCliente.setBounds(10, 231, 61, 13);
		contentPane.add(lblNombreCliente);
		
		textNombreCliente = new JTextField();
		textNombreCliente.setBounds(145, 226, 219, 23);
		contentPane.add(textNombreCliente);
		textNombreCliente.setColumns(10);
		
		textDiaPrestamo = new JTextField();
		textDiaPrestamo.setHorizontalAlignment(SwingConstants.CENTER);
		textDiaPrestamo.setText("DD");
		textDiaPrestamo.setBounds(145, 290, 51, 21);
		contentPane.add(textDiaPrestamo);
		textDiaPrestamo.setColumns(10);
		
		textMesPrestamo = new JTextField();
		textMesPrestamo.setHorizontalAlignment(SwingConstants.CENTER);
		textMesPrestamo.setText("MM");
		textMesPrestamo.setBounds(227, 291, 51, 19);
		contentPane.add(textMesPrestamo);
		textMesPrestamo.setColumns(10);
		
		textAñoPrestamo = new JTextField();
		textAñoPrestamo.setHorizontalAlignment(SwingConstants.CENTER);
		textAñoPrestamo.setText("AAAA");
		textAñoPrestamo.setBounds(313, 291, 51, 19);
		contentPane.add(textAñoPrestamo);
		textAñoPrestamo.setColumns(10);

		JLabel lblFechaPrestamos = new JLabel("Fecha de prestamo:");
		lblFechaPrestamos.setBounds(10, 291, 105, 18);
		contentPane.add(lblFechaPrestamos);
	
		JLabel lblFechaDevolucion = new JLabel("Fecha de devolución:");
		lblFechaDevolucion.setBounds(10, 339, 125, 23);
		contentPane.add(lblFechaDevolucion);
		
		textDiaDevolucion = new JTextField();
		textDiaDevolucion.setHorizontalAlignment(SwingConstants.CENTER);
		textDiaDevolucion.setText("DD");
		textDiaDevolucion.setBounds(145, 339, 51, 23);
		contentPane.add(textDiaDevolucion);
		textDiaDevolucion.setColumns(10);
		
		textMesDevolucion = new JTextField();
		textMesDevolucion.setHorizontalAlignment(SwingConstants.CENTER);
		textMesDevolucion.setText("MM");
		textMesDevolucion.setBounds(227, 341, 51, 19);
		contentPane.add(textMesDevolucion);
		textMesDevolucion.setColumns(10);
		
		textAñoDevolucion = new JTextField();
		textAñoDevolucion.setHorizontalAlignment(SwingConstants.CENTER);
		textAñoDevolucion.setText("AAAA");
		textAñoDevolucion.setBounds(313, 341, 51, 19);
		contentPane.add(textAñoDevolucion);
		textAñoDevolucion.setColumns(10);
		
		JLabel lblCategoria = new JLabel("Categoría:");
		lblCategoria.setBounds(457, 291, 105, 13);
		contentPane.add(lblCategoria);
		
		JLabel lblExistencias = new JLabel("Existencias:");
		lblExistencias.setBounds(456, 409, 88, 23);
		contentPane.add(lblExistencias);
		
		JLabel lblLibro = new JLabel("-----");
		lblLibro.setBounds(599, 247, 158, 29);
		contentPane.add(lblLibro);
		
		JLabel lblCategoriaLibro = new JLabel("-----");
		lblCategoriaLibro.setBounds(599, 286, 158, 29);
		contentPane.add(lblCategoriaLibro);
		
		JLabel lblAutorLibro = new JLabel("-----");
		lblAutorLibro.setBounds(599, 349, 158, 29);
		contentPane.add(lblAutorLibro);
		
		JLabel lblExistenciaLibro = new JLabel("-----");
		lblExistenciaLibro.setBounds(599, 403, 158, 34);
		contentPane.add(lblExistenciaLibro);
		
		JLabel lblLibros = new JLabel("Libros");
		lblLibros.setBounds(767, 179, 150, 21);
		contentPane.add(lblLibros);
		
		JButton btnPrestarLibro = new JButton("Prestar libro");
		btnPrestarLibro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				conexionBase conexion = new conexionBase();
				String cliente = textNombreCliente.getText();
				String diaPrestamo = textDiaPrestamo.getText();
				String mesPrestamo = textMesPrestamo.getText();
				String añoPrestamo = textAñoPrestamo.getText();
				String fechaPrestamo = diaPrestamo+"-"+mesPrestamo+"-"+añoPrestamo;
				String diaDevolucion = textDiaDevolucion.getText();
				String mesDevolucion = textMesDevolucion.getText();
				String añoDevolucion = textAñoDevolucion.getText();
				String fechaDevolucion = diaDevolucion+"-"+mesDevolucion+"-"+añoDevolucion;
				String nombreLibro = lblLibro.getText();
				 boolean resultado= conexion.registrarCliente(cliente, fechaPrestamo, fechaDevolucion, nombreLibro);
				 if(resultado) {
					 JOptionPane.showMessageDialog(null, "Préstamo agregado correctamente a la base de datos");
				 }
				 else {
					 JOptionPane.showMessageDialog(null, "No se pudo agregar el préstamo");	
				 }
				 boolean libroPrestado = conexion.registrarPrestamoMes(nombreLibro, mesPrestamo);
				 boolean disminuir = conexion.disminuirExistencia(nombreLibro); 
			}
		});
		btnPrestarLibro.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnPrestarLibro.setBounds(10, 464, 354, 59);
		contentPane.add(btnPrestarLibro);
		
		
		JList listLibros = new JList();
		listLibros.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				int indiceLista = listLibros.getSelectedIndex();
				String nombreLibro = listaLibros.get(indiceLista).getNombre();
				lblLibro.setText(nombreLibro);
				String categoria = listaLibros.get(indiceLista).getCategoria();
				lblCategoriaLibro.setText(categoria);
				String autor = listaLibros.get(indiceLista).getAutor();
				lblAutorLibro.setText(autor);
				String existencias = String.valueOf(listaLibros.get(indiceLista).getExistencias());
				lblExistenciaLibro.setText(existencias);
			}
		});
		listLibros.setBounds(767, 226, 602, 209);
		contentPane.add(listLibros);
		listLibros.setModel(modeloLibros);
		
		JButton btnCargarDatos = new JButton("Cargar datos");
		btnCargarDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (datosCargados == false) {
					datosCargados = true;
					int i = 0;
					conexionBase conexion = new conexionBase();
					resultado = conexion.obtenerLibros();
					try {
						while (resultado.next()) {
							String nombre = resultado.getString("nombre");
							String categoria = resultado.getString("categoria");
							String autor = resultado.getString("autor");
							int existencias = resultado.getInt("existencia");
							libro libro = new libro(nombre, autor, categoria, existencias);
							listaLibros.add(libro);
							modeloLibros.add(i, libro.getNombre());
							i++;
						}
					} catch (SQLException error) {
					error.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(null, "Ya se han cargado los datos", "Datos cargados", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnCargarDatos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCargarDatos.setBounds(856, 460, 433, 59);
		contentPane.add(btnCargarDatos);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				principal abrirPrincipal = new principal();
				abrirPrincipal.setVisible(true);
				prestarLibro.this.dispose();
			}
		});
		btnSalir.setBounds(13, 10, 150, 42);
		contentPane.add(btnSalir);
		
	}
}
