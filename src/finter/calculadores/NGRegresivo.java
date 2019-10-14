package finter.calculadores;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import finter.Manager;
import finter.Punto;

public class NGRegresivo {

	/*
		puedo hacer una matriz, poniendo los puntos intercalados 
		con un espacio en blanco para poder armar las diferencias 
		de forma visualmente amigable.
		
		x1 y1
		      C1
		x2 y2    C2
		      C1    C3
		x3 y3    C2    C4
		      C1    C3
		x4 y4    C2
		      C1
		x5 y5
	 */
	private static BigDecimal[][] matriz;
	private static int grado = 0;
	
	public static int procesar() {
		
		final int cantPuntos = Manager.getPuntos().size();
		matriz = new BigDecimal[(cantPuntos * 2) -1][cantPuntos + 1];
		
		int i = 0;
		for(final Punto punto : Manager.getPuntos()) {
			matriz[i][0] = punto.getX();
			matriz[i][1] = punto.getY();
			if(i!=(cantPuntos * 2) - 2) {
				matriz[i+1][0] = null;
				matriz[i+1][1] = null;
			}
			i+=2;
		}
		
		for(int col=2;col<cantPuntos+1;col++) {
			int iteraciones = 0;
			for(int fila=col-1;iteraciones<cantPuntos+1-col;fila+=2) {
				final BigDecimal minuendoNumerador = matriz[fila+1][col-1];
				final BigDecimal sustraendoNumerador= matriz[fila-1][col-1];
				//retroceder n columnas, y tomar el n de arriba y n de abajo;
				final BigDecimal minuendoDenominador = matriz[fila+(col-1)][0];
				final BigDecimal sustraendoDenominador = matriz[fila-(col-1)][0];
				
				final BigDecimal numerador = minuendoNumerador.subtract(sustraendoNumerador);
				final BigDecimal denominador = minuendoDenominador.subtract(sustraendoDenominador);
				
				final BigDecimal valorFinal = numerador.divide(denominador,2,BigDecimal.ROUND_HALF_EVEN);
				matriz[fila][col] = valorFinal;
				if(valorFinal != null && BigDecimal.ZERO.compareTo(valorFinal) != 0) {
					grado = col-1;
				}
				iteraciones++;
			}
		}
		
		return getGrado();
	}

	public static int getGrado() {
		return grado;
	}

	public static String especializar(final BigDecimal buscado) {
		return "NO IMPLEMENTADO AUN!";
	}
	
	public static String getPolinomio() {
		final StringBuilder sb = new StringBuilder();
		return sb.toString();
	}

	public static List<List<String>> getPasos() {
		final List<List<String>> list = new ArrayList<>();
		final int cantPuntos = Manager.getPuntos().size();
		int filas=(cantPuntos * 2) -1;
		int columnas = cantPuntos + 1;
		for(int i=0;i<filas;i++) {
			final List<String> temp = new ArrayList<>();
			for(int j=0;j<columnas;j++) {
				final BigDecimal bd = matriz[i][j];
				temp.add(bd != null ? bd.toString() : "");
			}
			list.add(temp);
		}
		return list;
	}
	
	public static String[] getPasosHeader() {
		final int columnas = Manager.getPuntos().size() - 1;
		final List<String> headers = new ArrayList<>();
		headers.add("X");
		headers.add("Y");
		for(int i=0;i<columnas;i++) {
			headers.add(pad(i+1));
		}
		return headers.toArray(new String[] {});
	}
	
	private static String pad(final int i) {
		return i<10 ? "0" + i : String.valueOf(i);
	}

}
