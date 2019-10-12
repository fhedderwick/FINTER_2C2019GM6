package finter.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Salir extends JDialog{

	public Salir(final List<JButton> buttons) {
		final JPanel panel = new JPanel();
		this.setContentPane(panel);
		panel.setLayout(null);
		
		disableParentButtons(buttons);
		
		final JLabel lblNewLabel = new JLabel("\u00BFSalir de FINTER?");
		lblNewLabel.setBounds(10, 12, 134, 14);
		panel.add(lblNewLabel);
		
		final JButton btnNewButton = new JButton("SI");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton.setBounds(10, 37, 68, 23);
		panel.add(btnNewButton);
		
		final JButton btnNewButton_1 = new JButton("NO");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				enableParentButtons(buttons);
				dispose();
			}
		});
		btnNewButton_1.setBounds(85, 37, 68, 23);
		panel.add(btnNewButton_1);
		
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
