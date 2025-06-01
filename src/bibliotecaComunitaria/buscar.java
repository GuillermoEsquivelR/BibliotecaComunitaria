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
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

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
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1147, 636);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(143, 188, 143));
		contentPane.setForeground(new Color(0, 128, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLibroABuscar = new JLabel("Libro a buscar:");
		lblLibroABuscar.setFont(new Font("Tw Cen MT", Font.PLAIN, 39));
		lblLibroABuscar.setBounds(418, 89, 369, 39);
		contentPane.add(lblLibroABuscar);
		
		txfBuscar = new JTextField();
		txfBuscar.setBackground(new Color(238, 232, 170));
		txfBuscar.setBounds(717, 74, 260, 54);
		contentPane.add(txfBuscar);
		txfBuscar.setColumns(10);
		
		JLabel lblNombre = new JLabel("---");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNombre.setForeground(new Color(85, 107, 47));
		JLabel lblAutor = new JLabel("---");
		lblAutor.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblAutor.setForeground(new Color(85, 107, 47));
		JLabel lblExistencia = new JLabel("---");
		lblExistencia.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblExistencia.setForeground(new Color(85, 107, 47));
		JLabel lblCat = new JLabel("---");
		lblCat.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblCat.setForeground(new Color(85, 107, 47));
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBackground(new Color(238, 232, 170));
		btnBuscar.addKeyListener(new KeyAdapter() {
		});
		btnBuscar.setFont(new Font("Tw Cen MT", Font.PLAIN, 40));
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
		btnBuscar.setBounds(788, 491, 260, 80);
		contentPane.add(btnBuscar);
		
		JLabel lblnombre = new JLabel("Nombre:");
		lblnombre.setFont(new Font("Consolas", Font.BOLD, 32));
		lblnombre.setForeground(Color.DARK_GRAY);
		lblnombre.setBounds(418, 199, 388, 86);
		contentPane.add(lblnombre);
		
		
		lblNombre.setBounds(762, 199, 286, 51);
		contentPane.add(lblNombre);
		
		JLabel lblautor = new JLabel("Autor:");
		lblautor.setFont(new Font("Consolas", Font.BOLD, 32));
		lblautor.setForeground(Color.DARK_GRAY);
		lblautor.setBounds(418, 285, 388, 54);
		contentPane.add(lblautor);
		
		
		lblAutor.setBounds(762, 269, 286, 51);
		contentPane.add(lblAutor);
		
		JLabel lblexistencia = new JLabel("Existencias:");
		lblexistencia.setFont(new Font("Consolas", Font.BOLD, 32));
		lblexistencia.setForeground(Color.DARK_GRAY);
		lblexistencia.setBounds(418, 425, 388, 54);
		contentPane.add(lblexistencia);
		
		
		lblExistencia.setBounds(762, 420, 286, 51);
		contentPane.add(lblExistencia);
		
		JLabel lblcat = new JLabel("Categoría:");
		lblcat.setFont(new Font("Consolas", Font.BOLD, 32));
		lblcat.setForeground(Color.DARK_GRAY);
		lblcat.setBounds(418, 346, 388, 68);
		contentPane.add(lblcat);
		
		
		lblCat.setBounds(762, 337, 286, 51);
		contentPane.add(lblCat);
		
		JButton btnAtras = new JButton("Atrás");
		btnAtras.setBackground(new Color(238, 232, 170));
		btnAtras.setFont(new Font("Tw Cen MT", Font.PLAIN, 32));
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				principal abrirPrincipal = new principal();
				abrirPrincipal.setVisible(true);
				buscar.this.dispose();
			}
		});
		btnAtras.setBounds(59, 11, 170, 48);
		contentPane.add(btnAtras);
	}
}
