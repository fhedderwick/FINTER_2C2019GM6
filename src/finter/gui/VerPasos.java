package finter.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import finter.Manager;
import finter.Procesador;

public class VerPasos extends JDialog{

	public VerPasos() {
		final JPanel panel = new JPanel();
		this.setContentPane(panel);
		panel.setLayout(null);
		
		ViewManager.disableAllMainButtons();
		
		final JTable table = new JTable() {
			@Override
			public boolean isCellEditable(final int row, final int column) {
				return false;
			};
		};
		final DefaultTableModel dtm = new DefaultTableModel(0,0);
		table.setModel(dtm);
		table.setEditingColumn(0);
		final JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 115, 301, 136);
		scrollPane.createHorizontalScrollBar();
		panel.add(scrollPane);
		ViewManager.cargarTablaPasos(dtm);
		
		final JLabel lblNewLabel = new JLabel(Textos.PASOS);
		lblNewLabel.setBounds(10, 88, 199, 14);
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
		lblGrado.setBounds(10, 63, 46, 14);
		panel.add(lblGrado);
		
		final JLabel lblNewLabel_1 = new JLabel(Procesador.getMetodo());
		lblNewLabel_1.setBounds(59, 11, 187, 14);
		panel.add(lblNewLabel_1);
		
		final JLabel lblNewLabel_2 = new JLabel(Procesador.getGrado());
		lblNewLabel_2.setBounds(54, 63, 46, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel(Textos.PUNTOS_EQUIESPACIADOS);
		lblNewLabel_3.setBounds(10, 36, 144, 14);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel(Manager.puntosEquiespaciados()?Textos.SI:Textos.NO);
		lblNewLabel_4.setBounds(151, 36, 46, 14);
		panel.add(lblNewLabel_4);
		
	}

}
