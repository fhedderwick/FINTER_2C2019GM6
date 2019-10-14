package finter.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import finter.Manager;
import finter.Procesador;
import finter.calculadores.Lagrange;
import finter.calculadores.NewtonGregory;

public class CalcularPolinomio extends JDialog{

	public CalcularPolinomio() {
		final JPanel panel = new JPanel();
		this.setContentPane(panel);
		panel.setLayout(null);
		
		ViewManager.disableAllMainButtons();
		
		final JLabel lblNewLabel = new JLabel(Textos.CALCULAR_POLINOMIO);
		lblNewLabel.setBounds(10, 12, 134, 14);
		panel.add(lblNewLabel);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton(Textos.LAGRANGE);
		rdbtnNewRadioButton.setBounds(20, 33, 109, 23);
		panel.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton(Textos.NG_P);
		rdbtnNewRadioButton_1.setBounds(20, 65, 198, 23);
		panel.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton(Textos.NG_R);
		rdbtnNewRadioButton_2.setBounds(20, 101, 198, 23);
		panel.add(rdbtnNewRadioButton_2);
		
		final ButtonGroup radios = new ButtonGroup();    
		radios.add(rdbtnNewRadioButton);
		radios.add(rdbtnNewRadioButton_1);
		radios.add(rdbtnNewRadioButton_2);
		
		final JButton btnNewButton = new JButton(Textos.CALCULAR);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				Manager.guardarPuntosAnteriores();
				Manager.habilitarBoton(Textos.LESS_THAN_SIGN);
				Manager.habilitarBoton(Textos.ESPECIALIZAR_POLINOMIO);
				Manager.habilitarBoton(Textos.VER_PASOS);
				Manager.deshabilitarBoton(Textos.CALCULAR_POLINOMIO);
				final String polinomioAnterior = Procesador.getPolinomio();
				String nuevoPolinomio = "";
				if(rdbtnNewRadioButton.isSelected()) {
					Procesador.lagrange();
					nuevoPolinomio = Lagrange.getPolinomio();
				} else if(rdbtnNewRadioButton_1.isSelected()) {
					Procesador.ngprogresivo();
					nuevoPolinomio = NewtonGregory.getPolinomio(true);
				} else if(rdbtnNewRadioButton_2.isSelected()) {
					Procesador.ngregresivo();
					nuevoPolinomio = NewtonGregory.getPolinomio(false);
				}
				ViewManager.setTextoPolinomio(nuevoPolinomio);
				if(!polinomioAnterior.isEmpty() && !polinomioAnterior.equals(nuevoPolinomio)) {
					JOptionPane.showMessageDialog(panel, Textos.CAMBIO_POLINOMIO);
				}
				ViewManager.restoreMainButtons();
				dispose();
			}
		});
		btnNewButton.setBounds(10, 143, 87, 23);
		panel.add(btnNewButton);
		
		final JButton btnNewButton_1 = new JButton(Textos.CANCELAR);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				ViewManager.restoreMainButtons();
				dispose();
			}
		});
		btnNewButton_1.setBounds(110, 143, 108, 23);
		panel.add(btnNewButton_1);
		
		rdbtnNewRadioButton.doClick();
		
	}

}
