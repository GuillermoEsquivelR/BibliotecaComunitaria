package bibliotecaComunitaria;

import java.awt.EventQueue;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class buscar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txfBuscar;
	private ResultSet myRs;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					buscar frame = new buscar();
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
	public buscar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblbuscar = new JLabel("Buscar:");
		lblbuscar.setBounds(41, 35, 49, 14);
		contentPane.add(lblbuscar);
		
		JLabel lblLibroABuscar = new JLabel("Libro a buscar:");
		lblLibroABuscar.setBounds(41, 59, 116, 14);
		contentPane.add(lblLibroABuscar);
		
		txfBuscar = new JTextField();
		txfBuscar.setBounds(167, 56, 96, 20);
		contentPane.add(txfBuscar);
		txfBuscar.setColumns(10);
		
		JLabel lblNombre = new JLabel("---");
		JLabel lblAutor = new JLabel("---");
		JLabel lblExistencia = new JLabel("---");
		JLabel lblCat = new JLabel("---");
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombre = txfBuscar.getText(); 
		        conexionBase conexion = new conexionBase();
		        ResultSet resultado = conexion.buscarLibro(nombre);
		        try {
					if (resultado != null && resultado.next()) {
						 String nombreLibro = resultado.getString("nombre");
						 String cat = resultado.getString("categoria");
					     String autor = resultado.getString("autor");
					     String exist = resultado.getString("existencia"); 
					     
					     lblNombre.setText(nombreLibro);
					     lblAutor.setText(autor);
					     lblCat.setText(cat);
					     lblExistencia.setText(exist);   
					}
					else {
						JOptionPane.showMessageDialog(null, "El libro " + nombre + " no se encuentra en nuestra base");
					}
				} catch (HeadlessException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		       	}});
		btnBuscar.setBounds(262, 198, 89, 23);
		contentPane.add(btnBuscar);
		
		JLabel lblnombre = new JLabel("Nombre:");
		lblnombre.setForeground(Color.BLUE);
		lblnombre.setBounds(108, 114, 76, 14);
		contentPane.add(lblnombre);
		
		
		lblNombre.setBounds(194, 114, 132, 14);
		contentPane.add(lblNombre);
		
		JLabel lblautor = new JLabel("Autor:");
		lblautor.setForeground(Color.BLUE);
		lblautor.setBounds(108, 144, 49, 14);
		contentPane.add(lblautor);
		
		
		lblAutor.setBounds(194, 144, 96, 14);
		contentPane.add(lblAutor);
		
		JLabel lblexistencia = new JLabel("Existencias:");
		lblexistencia.setForeground(Color.BLUE);
		lblexistencia.setBounds(108, 202, 75, 14);
		contentPane.add(lblexistencia);
		
		
		lblExistencia.setBounds(194, 198, 49, 14);
		contentPane.add(lblExistencia);
		
		JLabel lblcat = new JLabel("Categoría:");
		lblcat.setForeground(Color.BLUE);
		lblcat.setBounds(108, 169, 75, 14);
		contentPane.add(lblcat);
		
		
		lblCat.setBounds(194, 169, 116, 14);
		contentPane.add(lblCat);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				principal abrirPrincipal = new principal();
				abrirPrincipal.setVisible(true);
				buscar.this.dispose();
			}
		});
		btnAtras.setBounds(5, 4, 110, 21);
		contentPane.add(btnAtras);
	}
}
