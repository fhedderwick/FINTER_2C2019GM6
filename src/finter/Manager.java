package finter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.JButton;

public class Manager {

	private static final Map<JButton,Boolean> buttons = new HashMap<>();
	private static final List<Punto> puntos = new ArrayList<>();
	private static final List<Punto> puntosAnteriores = new ArrayList<>();

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
	}
	
	public static void guardarPuntosAnteriores() {
		for(final Punto punto : puntos) {
			puntosAnteriores.add(punto.duplicar());
		}
	}

}
