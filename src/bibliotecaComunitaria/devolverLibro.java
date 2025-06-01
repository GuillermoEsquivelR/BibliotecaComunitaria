package bibliotecaComunitaria;

import java.awt.EventQueue;
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 576, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Devolver libro:");
		lblNewLabel.setBounds(21, 11, 158, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre Cliente:");
		lblNewLabel_1.setBounds(184, 33, 123, 14);
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
		
		JButton btnDevolver = new JButton("Devolver");
		btnDevolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String fechaDev = txffecha.getText(); 
		       ResultSet resultado = conexion.devolverLibro(fechaDev);
			
			}

		});
		btnDevolver.setBounds(356, 262, 89, 23);
		contentPane.add(btnDevolver);
		
		JComboBox comboClientes = new JComboBox();
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
		comboClientes.setBounds(290, 29, 128, 22);
		contentPane.add(comboClientes);
	}
}
