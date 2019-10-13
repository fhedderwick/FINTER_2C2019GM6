package finter;

import java.math.BigDecimal;

public class Punto implements Comparable<Punto> {

	final BigDecimal x;
	final BigDecimal y;
	
	public Punto(final BigDecimal x, final BigDecimal y) {
		this.x = x;
		this.y = y;
	}
	
	public Punto duplicar() {
		return new Punto(x,y);
	}

	public BigDecimal getX() {
		return x;
	}
	
	public BigDecimal getY() {
		return y;
	}
	
	@Override
	public boolean equals(final Object otro) {
		if(otro instanceof Punto) {
			final Punto punto = (Punto) otro;
			return this.x.equals(punto.getX()) && this.y.equals(punto.getY());
		}
		return false;
		
	}

	@Override
	public int compareTo(final Punto o) {
		return this.x.compareTo(o.getX());
	}

}
