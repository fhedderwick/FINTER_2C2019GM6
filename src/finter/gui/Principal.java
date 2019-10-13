package finter.gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import finter.Manager;

public class Principal {

	private JFrame frmFinter;

	/**
	 * Launch the application.
	 */
	public static void main(final String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					final Principal window = new Principal();
					window.frmFinter.setVisible(true);
				} catch (final Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Principal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmFinter = new JFrame();
		frmFinter.setTitle(Textos.FINTER);
		frmFinter.setBounds(100, 100, 497, 300);
		frmFinter.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		final JPanel panel = new JPanel();
		frmFinter.getContentPane().add(panel);
		panel.setLayout(null);
		
		final JTextField textField = Manager.getPolinomio();
		textField.setEditable(false);
		textField.setBounds(10, 231, 461, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		final JLabel lblNewLabel = new JLabel(Textos.POLINOMIO_ENCONTRADO);
		lblNewLabel.setBounds(10, 205, 354, 14);
		panel.add(lblNewLabel);
		
		final JTable table = new JTable() {
			@Override
			public boolean isCellEditable(final int row, final int column) {
				return false;
			};
		};
		final DefaultTableModel dtm = new DefaultTableModel(0,0);
		final String[] header = new String[] {Textos.I_LABEL,Textos.X_LABEL,Textos.Y_LABEL};
		dtm.setColumnIdentifiers(header);
		table.setModel(dtm);
		table.setEditingColumn(0);
		final JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 36, 148, 158);
		scrollPane.createHorizontalScrollBar();
		panel.add(scrollPane);
		
		final JLabel lblPuntosATomar = new JLabel(Textos.PUNTOS_A_TOMAR);
		lblPuntosATomar.setBounds(10, 11, 98, 14);
		panel.add(lblPuntosATomar);
		
		final JButton button = new JButton(Textos.PLUS_SIGN);
		button.setBounds(168, 36, 41, 41);
		panel.add(button);
		
		final JButton btnNewButton = new JButton(Textos.MINUS_SIGN);
		btnNewButton.setBounds(168, 88, 41, 41);
		panel.add(btnNewButton);
		
		final JButton btnCalcularPolinomio = new JButton(Textos.CALCULAR_POLINOMIO);
		btnCalcularPolinomio.setBounds(242, 36, 229, 23);
		panel.add(btnCalcularPolinomio);
		
		final JButton btnEspecializarPolinomio = new JButton(Textos.ESPECIALIZAR_POLINOMIO);
		btnEspecializarPolinomio.setBounds(242, 71, 229, 23);
		panel.add(btnEspecializarPolinomio);
		
		final JButton btnVerPasosDe = new JButton(Textos.VER_PASOS);
		btnVerPasosDe.setBounds(242, 106, 229, 23);
		panel.add(btnVerPasosDe);
		
		final JButton btnNewButton_1 = new JButton(Textos.LESS_THAN_SIGN);
		btnNewButton_1.setBounds(168, 140, 41, 41);
		panel.add(btnNewButton_1);
	
		final JButton btnSalir = new JButton(Textos.SALIR);

		btnSalir.setBounds(242, 140, 229, 23);
		panel.add(btnSalir);
		
		Manager.registerButton(button, true);
		Manager.registerButton(btnNewButton, false);
		Manager.registerButton(btnCalcularPolinomio, false);
		Manager.registerButton(btnVerPasosDe, false);
		Manager.registerButton(btnNewButton_1, false);
		Manager.registerButton(btnEspecializarPolinomio, false);
		Manager.registerButton(btnSalir, true);
		
		ViewManager.restoreMainButtons();
		
		btnVerPasosDe.addActionListener(new ActionListener() {
			//VER PASOS DE CALCULO
			public void actionPerformed(final ActionEvent e) {
				final VerPasos verPasos = new VerPasos();
				
				verPasos.setLocation(60,70);
				verPasos.setVisible(true);
				verPasos.setSize(450, 320);
				verPasos.setAlwaysOnTop(true);
				verPasos.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			}
		});
		
		btnNewButton_1.addActionListener(new ActionListener() {
			//RESTAURAR ULTIMO POLINOMIO
			public void actionPerformed(final ActionEvent e) {
				final RestaurarPuntos restaurarPuntos = new RestaurarPuntos(dtm);
				
				restaurarPuntos.setLocation(60,70);
				restaurarPuntos.setVisible(true);
				restaurarPuntos.setSize(350, 120);
				restaurarPuntos.setAlwaysOnTop(true);
				restaurarPuntos.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			}
		});
		
		button.addActionListener(new ActionListener() {
			//AGREGAR PUNTO A LISTA
			public void actionPerformed(final ActionEvent e) {
				final AgregarPunto agregarPunto = new AgregarPunto(dtm);
				
				agregarPunto.setLocation(60,70);
				agregarPunto.setVisible(true);
				agregarPunto.setSize(300, 200);
				agregarPunto.setAlwaysOnTop(true);
				agregarPunto.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				
			}
		});
		
		btnSalir.addActionListener(new ActionListener() {
			//SALIR
			public void actionPerformed(final ActionEvent e) {
				final Salir salir = new Salir();
				
				salir.setLocation(60,70);
				salir.setVisible(true);
				salir.setSize(200, 120);
				salir.setAlwaysOnTop(true);
				salir.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
//				salir.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
			}
		});
		
		btnNewButton.addActionListener(new ActionListener() {
			//QUITAR PUNTO
			public void actionPerformed(final ActionEvent e) {
				Manager.quitarPuntos(table.getSelectedRows());
				ViewManager.refreshTable(dtm);
				ViewManager.restoreMainButtons();
			}
		});
		
		btnCalcularPolinomio.addActionListener(new ActionListener() {
			//CALCULAR POLINOMIO
			public void actionPerformed(final ActionEvent arg0) {
				final CalcularPolinomio calcularPolinomio = new CalcularPolinomio();
				
				calcularPolinomio.setLocation(60,70);
				calcularPolinomio.setVisible(true);
				calcularPolinomio.setSize(300, 230);
				calcularPolinomio.setAlwaysOnTop(true);
				calcularPolinomio.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			}
		});
		
		btnEspecializarPolinomio.addActionListener(new ActionListener() {
			//ESPECIALIZAR POLINOMIO
			public void actionPerformed(final ActionEvent e) {
				final EspecializarPolinomio especializarPolinomio = new EspecializarPolinomio();
				
				especializarPolinomio.setLocation(60,70);
				especializarPolinomio.setVisible(true);
				especializarPolinomio.setSize(300, 200);
				especializarPolinomio.setAlwaysOnTop(true);
				especializarPolinomio.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			}
		});
	}
	
}
