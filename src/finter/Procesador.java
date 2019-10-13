package finter;

import java.math.BigDecimal;

import finter.gui.Textos;

public class Procesador {

	private static String metodo = "";
	
	public static String especializarPolinomio(final BigDecimal x) {
		return "NO IMPLEMENTADO AUN!";
	}

	public static void lagrange() {
		metodo = Textos.LAGRANGE;
	}
	public static void ngprogresivo() {
		metodo = Textos.NG_P;
	}
	public static void ngregresivo() {
		metodo = Textos.NG_R;
	}
	
	public static String getMetodo() {
		return metodo;
	}

	public static String getGrado() {
		return "GRADO";
	}
	
}
