package finter.calculadores;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import finter.Manager;
import finter.Punto;
import finter.gui.Textos;

public class Lagrange {

	//TODO: cambiar map por lista de listas, pues si se repite coeficiente lo pisa
	private static Map<BigDecimal,List<BigDecimal>> map = new HashMap<>();
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
			
			map.put(puntoExterno.getY().divide(coeficiente,2,BigDecimal.ROUND_HALF_EVEN),sustraendos);
			i++;
		}
		
		return getGrado();
	}
	
	public static int getGrado() {
		BigDecimal base = new BigDecimal(0);
		for(final BigDecimal coeficiente : map.keySet()) {
			base = base.add(coeficiente);
		}
		return map.size() - ((BigDecimal.ZERO.compareTo(base) == 0) ? 2 : 1);
	}
	
	public static String especializar(final BigDecimal buscado) {
		final List<BigDecimal> terminos = new ArrayList<>();
		for(final Entry<BigDecimal, List<BigDecimal>> termino : map.entrySet()) {
			BigDecimal tempVal = termino.getKey();
			for(final BigDecimal value : termino.getValue()) {
				tempVal = tempVal.multiply(buscado.subtract(value));
			}
			terminos.add(tempVal);
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
		for(final Entry<BigDecimal, List<BigDecimal>> termino : map.entrySet()) {
			final BigDecimal coef = termino.getKey();
			if(!primero && coef.compareTo(BigDecimal.ZERO) >= 0) {
				sb.append("+");
			}
			sb.append(coef);
			for(final BigDecimal value : termino.getValue()) {
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
