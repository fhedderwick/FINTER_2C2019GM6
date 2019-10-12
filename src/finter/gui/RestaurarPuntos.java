package finter.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import finter.Manager;

public class RestaurarPuntos extends JDialog{

	public RestaurarPuntos() {
		final JPanel panel = new JPanel();
		this.setContentPane(panel);
		panel.setLayout(null);
		
		disableParentButtons(Manager.getButtons());
		
		final JLabel lblNewLabel = new JLabel("\u00BFRestaurar puntos?");
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
				restoreParentButtons(Manager.getButtonsAndInfo());
				dispose();
			}
		});
		btnNewButton_1.setBounds(85, 37, 68, 23);
		panel.add(btnNewButton_1);
		
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
