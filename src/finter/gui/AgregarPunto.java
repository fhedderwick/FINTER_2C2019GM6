package finter.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import finter.Punto;

public class AgregarPunto extends JDialog{
	private JTextField textField;
	private JTextField textField_1;

	public AgregarPunto(final List<JButton> buttons, final List<Punto> lista, final JScrollPane scrollPane) {
		setTitle("Agregar punto");
		final JPanel panel = new JPanel();
		this.setContentPane(panel);
		panel.setLayout(null);
		
		disableParentButtons(buttons);
		
		final JLabel lblNewLabel = new JLabel("Agregar punto");
		lblNewLabel.setBounds(10, 12, 84, 14);
		panel.add(lblNewLabel);
		
		final JButton btnNewButton = new JButton("OK");
		btnNewButton.setBounds(26, 111, 84, 23);
		panel.add(btnNewButton);
		
		final JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.setBounds(120, 111, 109, 23);
		panel.add(btnNewButton_1);
		
		textField = new JTextField();
		textField.setBounds(26, 37, 203, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(26, 71, 203, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		final JLabel lblNewLabel_1 = new JLabel("X: ");
		lblNewLabel_1.setBounds(10, 39, 36, 17);
		panel.add(lblNewLabel_1);
		
		final JLabel lblNewLabel_2 = new JLabel("Y:");
		lblNewLabel_2.setBounds(10, 71, 36, 17);
		panel.add(lblNewLabel_2);
		
		btnNewButton.addActionListener(new ActionListener() {
			BigDecimal x;
			BigDecimal y;
			public void actionPerformed(final ActionEvent e) {
				try {
					x = new BigDecimal(textField.getText());
				}catch(final Exception ex) {
					JOptionPane.showMessageDialog(panel, "Error en X");
					return;
				}
				try {
					y = new BigDecimal(textField_1.getText());
				}catch(final Exception ex) {
					JOptionPane.showMessageDialog(panel, "Error en Y");
					return;
				}
				lista.add(new Punto(x,y));				
				enableParentButtons(buttons);
				reloadList(lista,scrollPane);
				dispose();
			}
		});
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				enableParentButtons(buttons);
				dispose();
			}
		});
		
	}

	private void reloadList(final List<Punto> lista, final JScrollPane contenedorPuntos) {
//		scrollPane;
	}
	
	private void disableParentButtons(final List<JButton> buttons) {
		for(final JButton b : buttons) {
			b.setEnabled(false);
		}
	}
	
	private void enableParentButtons(final List<JButton> buttons) {
		for(final JButton b : buttons) {
			b.setEnabled(true);
		}
	}

}
