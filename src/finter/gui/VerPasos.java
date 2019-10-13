package finter.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import finter.Procesador;

public class VerPasos extends JDialog{

	public VerPasos() {
		final JPanel panel = new JPanel();
		this.setContentPane(panel);
		panel.setLayout(null);
		
		ViewManager.disableAllMainButtons();
		
		final JLabel lblNewLabel = new JLabel(Textos.PASOS);
		lblNewLabel.setBounds(10, 61, 199, 14);
		panel.add(lblNewLabel);
		
		final JButton btnNewButton_1 = new JButton(Textos.VOLVER);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				ViewManager.restoreMainButtons();
				dispose();
			}
		});
		btnNewButton_1.setBounds(325, 228, 84, 23);
		panel.add(btnNewButton_1);
		
		final JLabel lblMtodo = new JLabel(Textos.METODO);
		lblMtodo.setBounds(10, 11, 46, 14);
		panel.add(lblMtodo);
		
		final JLabel lblGrado = new JLabel(Textos.GRADO);
		lblGrado.setBounds(10, 36, 46, 14);
		panel.add(lblGrado);
		
		final JLabel lblNewLabel_1 = new JLabel(Procesador.getMetodo());
		lblNewLabel_1.setBounds(59, 11, 187, 14);
		panel.add(lblNewLabel_1);
		
		final JLabel lblNewLabel_2 = new JLabel(Procesador.getGrado());
		lblNewLabel_2.setBounds(59, 36, 46, 14);
		panel.add(lblNewLabel_2);
		
	}

}
