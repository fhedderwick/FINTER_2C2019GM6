package finter.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Salir extends JDialog{

	public Salir() {
		final JPanel panel = new JPanel();
		this.setContentPane(panel);
		panel.setLayout(null);
		
		ViewManager.disableAllMainButtons();
		
		final JLabel lblNewLabel = new JLabel(Textos.Q_SALIR);
		lblNewLabel.setBounds(10, 12, 134, 14);
		panel.add(lblNewLabel);
		
		final JButton btnNewButton = new JButton(Textos.SI);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton.setBounds(10, 37, 68, 23);
		panel.add(btnNewButton);
		
		final JButton btnNewButton_1 = new JButton(Textos.NO);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				ViewManager.restoreMainButtons();
				dispose();
			}
		});
		btnNewButton_1.setBounds(85, 37, 68, 23);
		panel.add(btnNewButton_1);
		
	}

}
