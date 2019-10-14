package finter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import finter.calculadores.Lagrange;
import finter.calculadores.NGProgresivo;
import finter.calculadores.NGRegresivo;
import finter.gui.Textos;

public class Procesador {

	private static String metodo = "";
	private static int grado = 0;
	
	public static String getPolinomio(){
		switch(metodo) {
			case Textos.LAGRANGE: return Lagrange.getPolinomio();
			case Textos.NG_P: return NGProgresivo.getPolinomio();
			case Textos.NG_R: return NGRegresivo.getPolinomio();
			default:
		};
		return "";
	}
	
	public static List<List<String>> getPasos() {
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

	public static String[] getPasosHeader() {
		switch(metodo) {
			case Textos.LAGRANGE: return Lagrange.getPasosHeader();
			case Textos.NG_P: return NGProgresivo.getPasosHeader();
			case Textos.NG_R: return NGRegresivo.getPasosHeader();
			default:
		};
		return new String[]{};
	}
	
}
