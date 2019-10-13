package finter.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

import finter.Manager;

public class RestaurarPuntos extends JDialog{

	public RestaurarPuntos(final DefaultTableModel dtm) {
		final JPanel panel = new JPanel();
		this.setContentPane(panel);
		panel.setLayout(null);
		
		ViewManager.disableAllMainButtons();
		
		final JLabel lblNewLabel = new JLabel(Textos.Q_RESTAURAR_PUNTOS);
		lblNewLabel.setBounds(10, 12, 287, 14);
		panel.add(lblNewLabel);
		
		final JButton btnNewButton = new JButton(Textos.SI);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				Manager.restaurarPuntos();
				ViewManager.refreshTable(dtm);
				ViewManager.restoreMainButtons();
				dispose();
			}
		});
		btnNewButton.setBounds(10, 37, 122, 23);
		panel.add(btnNewButton);
		
		final JButton btnNewButton_1 = new JButton(Textos.NO);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				ViewManager.restoreMainButtons();
				dispose();
			}
		});
		btnNewButton_1.setBounds(142, 37, 130, 23);
		panel.add(btnNewButton_1);
		
	}

}
