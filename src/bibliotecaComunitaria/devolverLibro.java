package bibliotecaComunitaria;

import java.awt.EventQueue;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.awt.HeadlessException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class devolverLibro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private ResultSet myRs;
	private JTextField txffecha;
	conexionBase conexion = new conexionBase();
	 DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					devolverLibro frame = new devolverLibro();
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
	public devolverLibro() {
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 576, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Devolver libro:");
		lblNewLabel.setBounds(116, 8, 158, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre Cliente:");
		lblNewLabel_1.setBounds(194, 53, 123, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNombre = new JLabel("---");
		JLabel lblInicio = new JLabel("---");
		JLabel lblFin = new JLabel("---");
		JLabel lblLibro = new JLabel("---");
		
		JLabel nombre = new JLabel("Nombre:");
		nombre.setBounds(82, 95, 49, 14);
		contentPane.add(nombre);
		
	
		lblNombre.setBounds(295, 95, 101, 14);
		contentPane.add(lblNombre);
		
		JLabel inicio = new JLabel("Fecha en que pidió:");
		inicio.setBounds(82, 120, 149, 14);
		contentPane.add(inicio);
		
		
		lblInicio.setBounds(295, 120, 101, 14);
		contentPane.add(lblInicio);
		
		JLabel fin = new JLabel("Fecha que debe devolverse:");
		fin.setBounds(82, 145, 190, 14);
		contentPane.add(fin);
		
		lblFin.setBounds(295, 145, 101, 14);
		contentPane.add(lblFin);
		
		
		lblLibro.setBounds(206, 195, 49, 14);
		contentPane.add(lblLibro);
		
		JLabel lblNewLabel_2 = new JLabel("Libro que devuelve:");
		lblNewLabel_2.setBounds(56, 195, 123, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Fecha en que devuelve:");
		lblNewLabel_3.setBounds(56, 220, 149, 14);
		contentPane.add(lblNewLabel_3);
		
		txffecha = new JTextField();
		txffecha.setBounds(216, 220, 96, 20);
		contentPane.add(txffecha);
		txffecha.setColumns(10);
		JComboBox<String>comboClientes = new JComboBox();
		ResultSet resultado = conexion.mostrarClientes();
		 try {
			while (resultado.next()) {
			        comboClientes.addItem(resultado.getString("nombreCliente"));
			 }
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 contentPane.add(comboClientes);
		comboClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombreSeleccionado = (String) comboClientes.getSelectedItem();
		        ResultSet resultado = conexion.buscarCliente(nombreSeleccionado);
		        try {
					if (resultado != null && resultado.next()) {
					    String nombreCliente = resultado.getString("nombreCliente");
					    String fechainicio = resultado.getString("fechaPrestamo");
					    String fechafinal = resultado.getString("fechaDevolucion");
					    String nombreLibro = resultado.getString("nombreLibro");

					    lblNombre.setText(nombreCliente);
					    lblInicio.setText(fechainicio);
					    lblFin.setText(fechafinal);
					    lblLibro.setText(nombreLibro);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		comboClientes.setBounds(300, 49, 128, 22);
		contentPane.add(comboClientes);
		
		JButton btnSalir = new JButton("Regresar");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				principal abrirPrincipal = new principal();
				abrirPrincipal.setVisible(true);
				devolverLibro.this.dispose();
			}
		});
		btnSalir.setBounds(13, 10, 78, 37);
		contentPane.add(btnSalir);
		
		JButton btnDevolver = new JButton("Devolver");
		btnDevolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cliente = (String) comboClientes.getSelectedItem();
		        ResultSet resultado = conexion.buscarCliente(cliente);
		        try {
					if (resultado != null && resultado.next()) {
						 String nombreLibro = resultado.getString("nombreLibro");
					    String fechaFinal = resultado.getString("fechaDevolucion");
					    
					    String fechaHoy = txffecha.getText();
					   
					    LocalDate fechaPactada = LocalDate.parse(fechaFinal, formato);
		                LocalDate fechaReal = LocalDate.parse(fechaHoy, formato);
		                if (fechaReal.isAfter(fechaPactada)) {
		                    JOptionPane.showMessageDialog(null, "El libro fue devuelto tarde. Penalización de $50.");
		                } else {
		                    JOptionPane.showMessageDialog(null, "Libro devuelto a tiempo. ¡Gracias!");
		                }
		                conexion.aumentarExistencia(nombreLibro);
						comboClientes.removeItem(cliente);
		                lblNombre.setText("---");
		                lblInicio.setText("---");
		                lblFin.setText("---");
		                lblLibro.setText("---");
					    
					}} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}}}
		);
		btnDevolver.setBounds(339, 281, 89, 23);
		contentPane.add(btnDevolver);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(185, 346, 89, 23);
		contentPane.add(btnNewButton);
		
		
	}
}
