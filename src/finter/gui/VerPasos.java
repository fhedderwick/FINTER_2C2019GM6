package finter.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VerPasos extends JDialog{

	public VerPasos() {
		final JPanel panel = new JPanel();
		this.setContentPane(panel);
		panel.setLayout(null);
		
		ViewManager.disableAllMainButtons();
		
		final JLabel lblNewLabel = new JLabel(Textos.VER_PASOS);
		lblNewLabel.setBounds(10, 12, 199, 14);
		panel.add(lblNewLabel);
		
		final JButton btnNewButton_1 = new JButton(Textos.VOLVER);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				ViewManager.restoreMainButtons();
				dispose();
			}
		});
		btnNewButton_1.setBounds(20, 37, 68, 23);
		panel.add(btnNewButton_1);
		
	}

}
