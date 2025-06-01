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

public class devolverLibro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txfCliente;
	private ResultSet myRs;
	private JTextField txffecha;

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
		lblNewLabel.setBounds(56, 40, 158, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre Cliente:");
		lblNewLabel_1.setBounds(56, 57, 123, 14);
		contentPane.add(lblNewLabel_1);
		
		txfCliente = new JTextField();
		txfCliente.setBounds(176, 54, 96, 20);
		contentPane.add(txfCliente);
		txfCliente.setColumns(10);
		
		JLabel lblNombre = new JLabel("---");
		JLabel lblInicio = new JLabel("---");
		JLabel lblFin = new JLabel("---");
		JLabel lblLibro = new JLabel("---");
		
		JButton btnBuscarCliente = new JButton("Buscar:");
		btnBuscarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombre = txfCliente.getText(); 
		        conexionBase conexion = new conexionBase();
		        ResultSet resultado = conexion.buscarCliente(nombre);
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
					else {
						JOptionPane.showMessageDialog(null, "El cliente " + nombre + " no se encuentra en nuestra base");
					}
				} catch (HeadlessException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnBuscarCliente.setBounds(356, 53, 89, 23);
		contentPane.add(btnBuscarCliente);
		
		JLabel nombre = new JLabel("Nombre:");
		nombre.setBounds(82, 95, 49, 14);
		contentPane.add(nombre);
		
	
		lblNombre.setBounds(175, 95, 49, 14);
		contentPane.add(lblNombre);
		
		JLabel inicio = new JLabel("Fecha en que pidió:");
		inicio.setBounds(82, 120, 123, 14);
		contentPane.add(inicio);
		
		
		lblInicio.setBounds(223, 120, 49, 14);
		contentPane.add(lblInicio);
		
		JLabel fin = new JLabel("Fecha que debe devolverse:");
		fin.setBounds(82, 145, 158, 14);
		contentPane.add(fin);
		
		lblFin.setBounds(258, 145, 49, 14);
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
		txffecha.setBounds(186, 217, 96, 20);
		contentPane.add(txffecha);
		txffecha.setColumns(10);
		
		JButton btnDevolver = new JButton("Devolver");
		btnDevolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDevolver.setBounds(356, 262, 89, 23);
		contentPane.add(btnDevolver);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				principal abrirPrincipal = new principal();
				abrirPrincipal.setVisible(true);
				devolverLibro.this.dispose();
			}
		});
		btnAtras.setBounds(10, 10, 101, 20);
		contentPane.add(btnAtras);
	}
}
