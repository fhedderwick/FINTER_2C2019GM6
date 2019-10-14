package finter.calculadores;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import finter.Manager;
import finter.Punto;
import finter.gui.Textos;

public class Lagrange {

	private static List<BigDecimal> coefs = new ArrayList<>();
	private static List<List<BigDecimal>> list = new ArrayList<>();
	private static List<String> pasos = new ArrayList<>();
	
	public static int procesar() {
		int i = 0;
		for(final Punto puntoExterno : Manager.getPuntos()) {
			final List<BigDecimal> sustraendos = new ArrayList<>();
			for(final Punto puntoInterno : Manager.getPuntos()) {
				if(puntoInterno.equals(puntoExterno)) {
					continue;
				}
				sustraendos.add(puntoInterno.getX());
			}
			
			final StringBuilder sb = new StringBuilder();
			sb.append("L").append(i).append("(").append(puntoExterno.getX()).append(")=");
			BigDecimal coeficiente = new BigDecimal(1);
			for(final BigDecimal sustraendo : sustraendos) {
				sb.append("(")
					.append(puntoExterno.getX())
					.append(sustraendo.compareTo(BigDecimal.ZERO) < 0 ? "+" : "-")
					.append(sustraendo.abs())
					.append(")");
				coeficiente = coeficiente.multiply(puntoExterno.getX().subtract(sustraendo));
			}
			pasos.add(sb.toString() + "=" + coeficiente);
			
			coefs.add(puntoExterno.getY().divide(coeficiente,2,BigDecimal.ROUND_HALF_EVEN));
			list.add(sustraendos);
			i++;
		}
		
		return getGrado();
	}
	
	public static int getGrado() {
		BigDecimal base = new BigDecimal(0);
		for(final BigDecimal coeficiente : coefs) {
			base = base.add(coeficiente);
		}
		return coefs.size() - ((BigDecimal.ZERO.compareTo(base) == 0) ? 2 : 1);
	}
	
	public static String especializar(final BigDecimal buscado) {
		final List<BigDecimal> terminos = new ArrayList<>();
		int i =0;
		for(final List<BigDecimal> termino : list) {
			BigDecimal tempVal = coefs.get(i);
			for(final BigDecimal value : termino) {
				tempVal = tempVal.multiply(buscado.subtract(value));
			}
			terminos.add(tempVal);
			i++;
		}
		BigDecimal retVal = BigDecimal.ZERO;
		for(final BigDecimal termino : terminos) {
			retVal = retVal.add(termino);
		}
		return retVal.toString();
	}

	public static String getPolinomio() {
		final StringBuilder sb = new StringBuilder();
		boolean primero = true;
		int i =0;
		for(final List<BigDecimal> termino : list) {
			final BigDecimal coef = coefs.get(i);
			i++;
			if(!primero && coef.compareTo(BigDecimal.ZERO) >= 0) {
				sb.append("+");
			}
			sb.append(coef);
			for(final BigDecimal value : termino) {
				sb.append("(x");
				sb.append(value.compareTo(BigDecimal.ZERO) >= 0 ? "-" : "+");
				sb.append(value.abs()).append(")");
			}
			primero = false;
		}
		return sb.toString();
	}

	public static List<List<String>> getPasos(){
		final List<List<String>> list = new ArrayList<>();
		for(final String paso : pasos) {
			final List<String> temp = new ArrayList<>();
			temp.add(paso);
			list.add(temp);
		}
		return list;
	}

	public static String[] getPasosHeader() {
		return new String[] {Textos.PASO};
	}

}
