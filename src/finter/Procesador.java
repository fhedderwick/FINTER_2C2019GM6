package finter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import finter.calculadores.Lagrange;
import finter.calculadores.NGProgresivo;
import finter.calculadores.NGRegresivo;
import finter.gui.Textos;

public class Procesador {

	private static String metodo = "";
	private static int grado = 0;
	
	public static List<String> getPasos() {
		switch(metodo) {
			case Textos.LAGRANGE: return Lagrange.getPasos();
			case Textos.NG_P: return NGProgresivo.getPasos();
			case Textos.NG_R: return NGRegresivo.getPasos();
			default:
		};
		return new ArrayList<>();
	}
	
	public static String especializarPolinomio(final BigDecimal x) {
		switch(metodo) {
			case Textos.LAGRANGE: return Lagrange.especializar(x);
			case Textos.NG_P: return NGProgresivo.especializar(x);
			case Textos.NG_R: return NGRegresivo.especializar(x);
			default:
		};
		return "NO IMPLEMENTADO AUN!";
	}

	public static void lagrange() {
		metodo = Textos.LAGRANGE;
		grado = Lagrange.procesar();
	}
	public static void ngprogresivo() {
		metodo = Textos.NG_P;
		grado = NGProgresivo.procesar();
	}
	public static void ngregresivo() {
		metodo = Textos.NG_R;
		grado = NGRegresivo.procesar();
	}
	
	public static String getMetodo() {
		return metodo;
	}

	public static String getGrado() {
		return String.valueOf(grado);
	}
	
}
