package finter.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import finter.Manager;
import finter.Procesador;

public class CalcularPolinomio extends JDialog{

	public CalcularPolinomio() {
		final JPanel panel = new JPanel();
		this.setContentPane(panel);
		panel.setLayout(null);
		
		disableParentButtons(Manager.getButtons());
		
		final JLabel lblNewLabel = new JLabel("Calcular polinomio");
		lblNewLabel.setBounds(10, 12, 134, 14);
		panel.add(lblNewLabel);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Lagrange");
		rdbtnNewRadioButton.setBounds(20, 33, 109, 23);
		panel.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Newton-Gregory (Progresivo)");
		rdbtnNewRadioButton_1.setBounds(20, 65, 198, 23);
		panel.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Newton-Gregory (Regresivo)");
		rdbtnNewRadioButton_2.setBounds(20, 101, 198, 23);
		panel.add(rdbtnNewRadioButton_2);
		
		final ButtonGroup radios = new ButtonGroup();    
		radios.add(rdbtnNewRadioButton);
		radios.add(rdbtnNewRadioButton_1);
		radios.add(rdbtnNewRadioButton_2);
		
		final JButton btnNewButton = new JButton("Calcular");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				Manager.guardarPuntosAnteriores();
				if(rdbtnNewRadioButton.isSelected()) {
					Procesador.lagrange();
				} else if(rdbtnNewRadioButton_1.isSelected()) {
					Procesador.ngprogresivo();
				} else if(rdbtnNewRadioButton_2.isSelected()) {
					Procesador.ngregresivo();
				}
			}
		});
		btnNewButton.setBounds(10, 143, 87, 23);
		panel.add(btnNewButton);
		
		final JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				restoreParentButtons(Manager.getButtonsAndInfo());
				dispose();
			}
		});
		btnNewButton_1.setBounds(110, 143, 108, 23);
		panel.add(btnNewButton_1);
		
		rdbtnNewRadioButton.doClick();
		
	}

	
	private void disableParentButtons(final Set<JButton> buttons) {
		for(final JButton b : buttons) {
			b.setEnabled(false);
		}
	}
	
	private void restoreParentButtons(final Map<JButton,Boolean> buttons) {
		for(final Entry<JButton, Boolean> entry : buttons.entrySet()) {
			entry.getKey().setEnabled(entry.getValue());
		}
	}
}
