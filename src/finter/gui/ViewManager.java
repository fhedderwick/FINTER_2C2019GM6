package finter.gui;

import java.util.Map.Entry;

import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import finter.Manager;
import finter.Procesador;
import finter.Punto;

public class ViewManager {
	
	public static void cargarTablaPasos(final DefaultTableModel dtm) {
		dtm.setRowCount(0);
		int i = 0;
		for(final String paso : Procesador.getPasos()) {
			dtm.addRow(new Object[] {paso});
			i++;
		}
	}

	public static void refreshTable(final DefaultTableModel dtm) {
		dtm.setRowCount(0);
		int i = 0;
		for(final Punto punto : Manager.getPuntos()) {
			i++;
			dtm.addRow(new Object[] {i,punto.getX(),punto.getY()});
		}
	}
	
	public static void disableAllMainButtons() {
		for(final JButton b : Manager.getButtons()) {
			b.setEnabled(false);
		}
	}
	
	public static void restoreMainButtons() {
		for(final Entry<JButton, Boolean> entry : Manager.getButtonsAndInfo().entrySet()) {
			entry.getKey().setEnabled(entry.getValue());
		}
	}

	public static void setTextoPolinomio(final String string) {
		Manager.getPolinomio().setText(string);
	}
	
}
