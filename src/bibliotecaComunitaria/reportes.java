package bibliotecaComunitaria;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class reportes extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tableLibros;
	conexionBase conexion = new conexionBase();
	ResultSet resultado;
	DefaultTableModel modeloTabla = new DefaultTableModel();
	boolean archivoCargado = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					reportes frame = new reportes();
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
	public reportes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1443, 892);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(287, 192, 815, 500);
		contentPane.add(scrollPane);
		
		tableLibros = new JTable();
		scrollPane.setViewportView(tableLibros);
		tableLibros.setModel(modeloTabla);
		
		
		JLabel lblReportes = new JLabel("Reporte mensual");
		lblReportes.setHorizontalAlignment(SwingConstants.CENTER);
		lblReportes.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblReportes.setBounds(268, 37, 866, 61);
		contentPane.add(lblReportes);
		
		JLabel lblMes = new JLabel("Mes");
		lblMes.setHorizontalAlignment(SwingConstants.CENTER);
		lblMes.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblMes.setBounds(166, 125, 297, 52);
		contentPane.add(lblMes);
		
		JComboBox comboMeses = new JComboBox();
		comboMeses.setFont(new Font("Tahoma", Font.PLAIN, 30));
		comboMeses.setModel(new DefaultComboBoxModel(new String[] {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"}));
		comboMeses.setBounds(497, 121, 622, 61);
		contentPane.add(comboMeses);
		
		JButton btnDescargar = new JButton("Descargar Reporte");
		btnDescargar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (archivoCargado == true) {
					ExportarExcel obj;
					try {
						obj = new ExportarExcel();
						obj.exportarExcel(tableLibros);
					} catch (IOException ex) {
					System.out.println("Error: " + ex);
					}
				} else {
					JOptionPane.showMessageDialog(null, "Debes cargar un reporte para poder descargar un archivo", "Reporte no cargado", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnDescargar.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnDescargar.setBounds(706, 714, 385, 84);
		contentPane.add(btnDescargar);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				principal abrirPrincipal = new principal();
				abrirPrincipal.setVisible(true);
				reportes.this.dispose();
			}
		});
		btnAtras.setBounds(10, 10, 243, 37);
		contentPane.add(btnAtras);
		
		JButton btnCargar = new JButton("Cargar Reporte");
		btnCargar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				archivoCargado = true;
				try {
					int i = comboMeses.getSelectedIndex();
					String mes = String.valueOf(comboMeses.getSelectedItem());
					resultado = conexion.obtenerPrestamosMensuales(i);
					modeloTabla.setRowCount(0);
					modeloTabla.setColumnCount(0);
					String nombreLibro;
					String cantVecesPrestado;
					modeloTabla.addColumn("Nombre del libro");
					modeloTabla.addColumn("Cantidad de veces prestadas en el mes de " + mes);
					while (resultado.next()) {
						nombreLibro = resultado.getString(2);
						cantVecesPrestado = String.valueOf(resultado.getInt(3));
						String [] filas = {nombreLibro, cantVecesPrestado};
						modeloTabla.addRow(filas);
					}
					} catch (SQLException ex) {
						ex.printStackTrace();
					}
			}
		});
		btnCargar.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnCargar.setBounds(287, 714, 391, 84);
		contentPane.add(btnCargar);
		
		
		
		
	}
}
