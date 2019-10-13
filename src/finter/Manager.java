package finter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JTextField;

import finter.gui.Textos;

public class Manager {

	private static final Map<JButton,Boolean> buttons = new HashMap<>();
	private static final List<Punto> puntos = new ArrayList<>();
	private static final List<Punto> puntosAnteriores = new ArrayList<>();
	private static final JTextField polinomio = new JTextField();

	public static void registerButton(final JButton button, final boolean enabled) {
		buttons.put(button,enabled);
	}
	
	public static Set<JButton> getButtons(){
		return buttons.keySet();
	}

	public static Map<JButton, Boolean> getButtonsAndInfo() {
		return buttons;
	}

	public static List<Punto> getPuntos() {
		return puntos;
	}

	public static void agregarPunto(final Punto punto) {
		puntos.add(punto);
		puntos.sort(null);
		for(final JButton button : buttons.keySet()){
			if(Textos.ESPECIALIZAR_POLINOMIO.contentEquals(button.getText()) || Textos.VER_PASOS.contentEquals(button.getText())) {
				registerButton(button, false);
			}
			if(Textos.MINUS_SIGN.contentEquals(button.getText()) || Textos.CALCULAR_POLINOMIO.contentEquals(button.getText())) {
				registerButton(button, true);
			}
		}

	}
	
	public static void quitarPuntos(final int[] indices) {
		for(int i = indices.length; i > 0; i--) {
			puntos.remove(indices[i-1]);
		}
		puntos.sort(null);
		for(final JButton button : buttons.keySet()){
			if(Textos.ESPECIALIZAR_POLINOMIO.contentEquals(button.getText()) || Textos.VER_PASOS.contentEquals(button.getText())) {
				registerButton(button, false);
			}
			if(!hayPuntos()) {
				if(Textos.MINUS_SIGN.contentEquals(button.getText()) || Textos.CALCULAR_POLINOMIO.contentEquals(button.getText())) {
					registerButton(button, false);
				}
			}
		}
	}
	
	public static void guardarPuntosAnteriores() {
		for(final Punto punto : puntos) {
			puntosAnteriores.add(punto.duplicar());
		}
	}

	public static boolean hayPuntos() {
		return !puntos.isEmpty();
	}

	public static boolean existe(final BigDecimal x) {
		for(final Punto punto : puntos) {
			if(x.equals(punto.getX())) {
				return true;
			}
		}
		return false;
	}
	
	public static void habilitarBoton(final String label) {
		for(final JButton button : buttons.keySet()){
			if(label.contentEquals(button.getText())) {
				registerButton(button, true);
			}
		}
	}
	
	public static JTextField getPolinomio() {
		return polinomio;
	}

	public static void restaurarPuntos() {
		puntos.clear();
		for(final Punto punto : puntosAnteriores) {
			puntos.add(punto.duplicar());
		}
		puntosAnteriores.clear();
		for(final JButton button : buttons.keySet()){
			if(Textos.ESPECIALIZAR_POLINOMIO.contentEquals(button.getText()) || Textos.VER_PASOS.contentEquals(button.getText())) {
				registerButton(button, true);
			}
			if(Textos.CALCULAR_POLINOMIO.contentEquals(button.getText())) {
				registerButton(button, false);
			}
		}
	}

	public static void deshabilitarBoton(final String label) {
		for(final JButton button : buttons.keySet()){
			if(label.contentEquals(button.getText())) {
				registerButton(button, false);
			}
		}
	}

}
