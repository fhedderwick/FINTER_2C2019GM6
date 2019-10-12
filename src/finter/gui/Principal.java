package finter.gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import finter.Punto;

public class Principal {

	final List<JButton> buttons = new ArrayList<>();
	final List<Punto> puntos = new ArrayList<>();
	private JFrame frmFinter;
	private JTextField textField;

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
		frmFinter.setTitle("FINTER");
		frmFinter.setBounds(100, 100, 497, 300);
		frmFinter.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		final JPanel panel = new JPanel();
		frmFinter.getContentPane().add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(10, 231, 461, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		final JLabel lblNewLabel = new JLabel("Polinomio encontrado:");
		lblNewLabel.setBounds(10, 205, 354, 14);
		panel.add(lblNewLabel);
		
		final JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 36, 148, 158);
		scrollPane.createHorizontalScrollBar();
		panel.add(scrollPane);
		
		final JLabel lblPuntosATomar = new JLabel("Puntos a tomar:");
		lblPuntosATomar.setBounds(10, 11, 98, 14);
		panel.add(lblPuntosATomar);
		
		final JButton button = new JButton("+");
		button.setBounds(168, 36, 41, 41);
		panel.add(button);
		
		final JButton btnNewButton = new JButton("-");
		btnNewButton.setBounds(168, 88, 41, 41);
		panel.add(btnNewButton);
		
		final JButton btnCalcularPolinomio = new JButton("Calcular polinomio");
		btnCalcularPolinomio.setBounds(242, 36, 229, 23);
		panel.add(btnCalcularPolinomio);
		
		final JButton btnEspecializarPolinomio = new JButton("Especializar polinomio");
		btnEspecializarPolinomio.setBounds(242, 71, 229, 23);
		panel.add(btnEspecializarPolinomio);
		
		final JButton btnVerPasosDe = new JButton("Ver pasos de c\u00E1lculo");
		btnVerPasosDe.setBounds(242, 106, 229, 23);
		panel.add(btnVerPasosDe);
		
		final JButton btnNewButton_1 = new JButton("<");
		btnNewButton_1.setBounds(168, 140, 41, 41);
		panel.add(btnNewButton_1);
	
		final JButton btnSalir = new JButton("Salir");

		btnSalir.setBounds(242, 140, 229, 23);
		panel.add(btnSalir);
		
		buttons.add(button);
		buttons.add(btnNewButton);
		buttons.add(btnCalcularPolinomio);
		buttons.add(btnVerPasosDe);
		buttons.add(btnNewButton_1);
		buttons.add(btnEspecializarPolinomio);
		buttons.add(btnSalir);
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				final AgregarPunto agregarPunto = new AgregarPunto(buttons,puntos,scrollPane);
				
				agregarPunto.setLocation(60,70);
				agregarPunto.setVisible(true);
				agregarPunto.setSize(300, 200);
				agregarPunto.setAlwaysOnTop(true);
				agregarPunto.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			}
		});
		
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				final Salir salir = new Salir(buttons);
				
				salir.setLocation(60,70);
				salir.setVisible(true);
				salir.setSize(200, 120);
				salir.setAlwaysOnTop(true);
				salir.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
//				salir.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
			}
		});
		
		btnEspecializarPolinomio.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				final EspecializarPolinomio especializarPolinomio = new EspecializarPolinomio(buttons);
				
				especializarPolinomio.setLocation(60,70);
				especializarPolinomio.setVisible(true);
				especializarPolinomio.setSize(300, 200);
				especializarPolinomio.setAlwaysOnTop(true);
				especializarPolinomio.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			}
		});
	}
}
