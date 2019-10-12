package finter;

import java.math.BigDecimal;

public class Punto {

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

}
