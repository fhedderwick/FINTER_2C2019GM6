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
import javax.swing.table.DefaultTableModel;

import finter.Manager;
import finter.Punto;

public class AgregarPunto extends JDialog{
	private JTextField textField;
	private JTextField textField_1;

	public AgregarPunto(final DefaultTableModel dtm) {
		
		setTitle(Textos.AGREGAR_PUNTO);
		final JPanel panel = new JPanel();
		this.setContentPane(panel);
		panel.setLayout(null);
		
		ViewManager.disableAllMainButtons();
		
		final JLabel lblNewLabel = new JLabel(Textos.AGREGAR_PUNTO);
		lblNewLabel.setBounds(10, 12, 84, 14);
		panel.add(lblNewLabel);
		
		final JButton btnNewButton = new JButton(Textos.OK);
		btnNewButton.setBounds(26, 111, 84, 23);
		panel.add(btnNewButton);
		
		final JButton btnNewButton_1 = new JButton(Textos.CANCELAR);
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
				try {
					y = new BigDecimal(textField_1.getText());
				}catch(final Exception ex) {
					JOptionPane.showMessageDialog(panel, Textos.ERROR_Y);
					return;
				}
				if(Manager.existe(x)) {
					JOptionPane.showMessageDialog(panel, Textos.EXISTE_X);
					return;
				}
				final Punto punto = new Punto(x,y);
				Manager.agregarPunto(punto);				
				ViewManager.refreshTable(dtm);
				ViewManager.restoreMainButtons();
				dispose();
			}
		});
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				//borrar desde aqui
				Manager.agregarPunto(new Punto(new BigDecimal(1),new BigDecimal(1)));
				Manager.agregarPunto(new Punto(new BigDecimal(3),new BigDecimal(3)));
				Manager.agregarPunto(new Punto(new BigDecimal(4),new BigDecimal(13)));
				Manager.agregarPunto(new Punto(new BigDecimal(5),new BigDecimal(37)));
				Manager.agregarPunto(new Punto(new BigDecimal(7),new BigDecimal(151)));
				//hasta aqui
				ViewManager.restoreMainButtons();
				dispose();
			}
		});
		
	}

}
