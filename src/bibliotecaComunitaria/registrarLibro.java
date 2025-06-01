package bibliotecaComunitaria;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class registrarLibro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txfnombre;
	private JTextField txfautor;
	private JTextField txfexistencia;
	conexionBase conexion = new conexionBase();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registrarLibro frame = new registrarLibro();
					frame.setVisible(true);
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public registrarLibro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl1 = new JLabel("Registrar un libro:");
		lbl1.setBounds(67, 39, 130, 14);
		contentPane.add(lbl1);
		
		JLabel lblNombre = new JLabel("Nombre del libro:");
		lblNombre.setBounds(67, 67, 99, 14);
		contentPane.add(lblNombre);
		
		txfnombre = new JTextField();
		txfnombre.setBounds(164, 64, 96, 20);
		contentPane.add(txfnombre);
		txfnombre.setColumns(10);
		
		JLabel lblAutor = new JLabel("Autor:");
		lblAutor.setBounds(67, 140, 99, 14);
		contentPane.add(lblAutor);
		
		JLabel lblCat = new JLabel("Categoría:");
		lblCat.setBounds(67, 115, 99, 14);
		contentPane.add(lblCat);
		
		txfautor = new JTextField();
		txfautor.setColumns(10);
		txfautor.setBounds(164, 137, 96, 20);
		contentPane.add(txfautor);
		
		txfexistencia = new JTextField();
		txfexistencia.setColumns(10);
		txfexistencia.setBounds(164, 165, 96, 20);
		contentPane.add(txfexistencia);
		
		JLabel lblExistencia = new JLabel("Cantidad de libros:");
		lblExistencia.setBounds(67, 168, 99, 14);
		contentPane.add(lblExistencia);
		
		JComboBox comboBox = new JComboBox();
		JButton btnGuardar = new JButton("Guardar!");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombre = txfnombre.getText();
				String cat = (String) comboBox.getSelectedItem();
				String autor = txfautor.getText();
				int existencia = Integer.parseInt(txfexistencia.getText());
				conexion.registrarLibro(nombre,cat,autor,existencia);
				JOptionPane.showMessageDialog(null, "Libro registrado");
			}
		});
		btnGuardar.setBounds(247, 196, 89, 23);
		contentPane.add(btnGuardar);
		
		
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Clásicos", "Literatura", "Superación", "NBS", "Juveniles", "Infantiles", "Cocina", "Historia", "Ficción"}));
		comboBox.setBounds(164, 107, 96, 22);
		contentPane.add(comboBox);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				principal abrirPrincipal = new principal();
				abrirPrincipal.setVisible(true);
				registrarLibro.this.dispose();
			}
		});
		btnAtras.setBounds(10, 8, 96, 21);
		contentPane.add(btnAtras);
	}
}
