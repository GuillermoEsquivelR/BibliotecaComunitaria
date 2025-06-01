package bibliotecaComunitaria;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class reportes extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					reportes frame = new reportes();
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
	public reportes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1184, 863);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblReportes = new JLabel("Reporte mensual");
		lblReportes.setHorizontalAlignment(SwingConstants.CENTER);
		lblReportes.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblReportes.setBounds(268, 37, 866, 61);
		contentPane.add(lblReportes);
		
		JLabel lblMes = new JLabel("Mes");
		lblMes.setHorizontalAlignment(SwingConstants.CENTER);
		lblMes.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblMes.setBounds(162, 220, 297, 52);
		contentPane.add(lblMes);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(498, 211, 622, 61);
		contentPane.add(comboBox);
		
		JButton btnDescargar = new JButton("Descargar");
		btnDescargar.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnDescargar.setBounds(377, 426, 546, 126);
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
	}
}
