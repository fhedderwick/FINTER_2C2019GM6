package finter.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import finter.Procesador;

public class EspecializarPolinomio extends JDialog{
	private JTextField textField;
	private JTextField textField_1;

	public EspecializarPolinomio() {
		setTitle(Textos.ESPECIALIZAR_POLINOMIO);
		final JPanel panel = new JPanel();
		this.setContentPane(panel);
		panel.setLayout(null);
		
		ViewManager.disableAllMainButtons();
		
		final JLabel lblNewLabel = new JLabel(Textos.ESPECIALIZAR_POLINOMIO);
		lblNewLabel.setBounds(10, 12, 84, 14);
		panel.add(lblNewLabel);
		
		final JButton btnNewButton = new JButton(Textos.ESPECIALIZAR);
		btnNewButton.setBounds(26, 111, 124, 23);
		panel.add(btnNewButton);
		
		final JButton btnNewButton_1 = new JButton(Textos.VOLVER);
		btnNewButton_1.setBounds(162, 111, 84, 23);
		panel.add(btnNewButton_1);
		
		textField = new JTextField();
		textField.setBounds(26, 37, 211, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(26, 71, 211, 20);
		textField_1.setEditable(false);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		final JLabel lblNewLabel_1 = new JLabel(Textos.X);
		lblNewLabel_1.setBounds(10, 39, 36, 17);
		panel.add(lblNewLabel_1);
		
		final JLabel lblNewLabel_2 = new JLabel(Textos.Y);
		lblNewLabel_2.setBounds(10, 71, 36, 17);
		panel.add(lblNewLabel_2);
		
		btnNewButton.addActionListener(new ActionListener() {
			BigDecimal x;
			BigDecimal y;
			public void actionPerformed(final ActionEvent e) {
				try {
					x = new BigDecimal(textField.getText());
				}catch(final Exception ex) {
					JOptionPane.showMessageDialog(panel, Textos.ERROR_X);
					return;
				}
				textField_1.setText(Procesador.especializarPolinomio(x));
			}
		});
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				ViewManager.restoreMainButtons();
				dispose();
			}
		});
		
	}
}
