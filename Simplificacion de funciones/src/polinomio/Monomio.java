package polinomio;

public class Monomio {
	private Double coeficiente;
	private static final char LITERAL = 'x' ;
	private Double exponente;
	public Monomio(Double coeficiente, Double exponente) { //Constructor
		this.coeficiente = coeficiente;
		//this.literal = literal;
		this.exponente = exponente;
	}
	//METODOS SETS Y GETS RESPECTIVAMENTE:::::::::::::::::
	public void setCoeficiente(Double coeficiente) {
		this.coeficiente = coeficiente;
	}
	
	
	/*public void setLiteral( char literal) {
		this.literal = literal;
		
	}*/ 
	/*Metodo que era utilizado para settear literal,
	No usado más porque establecí x como única literal para todos los monomios
	Ya que polinomio trabaja sobre 1 incógnita.*/
	
	
	public void setExponente(Double exponente) {
		this.exponente = exponente;
	}
	public Double getCoeficiente() {
		return coeficiente;
	}
	/*public char getLiteral() {
		return literal;
	}*/ //Lo mismo que con el método setLiteral
	
	
	public Double getExponente() {
		return exponente;
	}
	//MÉTODO TOSTRING 
	public String toString() {
		String cadena = "(";
		//PRIMER FILTRO:
		//VERIFICAMOS COEFICIENTE Y AGREGAMOS LITERAL
		if(coeficiente == 1 || coeficiente == -1) {
			if(coeficiente == -1) { //SI EL COEFICIENTE ES -1 (-x
				cadena += String.format("-%c", LITERAL);
			}else {					//SI EL COEFICIENTE ES 1 (x
				cadena += String.format("%c", LITERAL);
			}	
		}else {				//SI EL COEFICIENTE ES (-INF, -1)u(1, inf)
			cadena += String.format("%.0f%c", coeficiente,LITERAL);
		}
		//AGREGAMOS, VERIFICAMOS EXPONENTE y cerramos paréntesis
		if(exponente != 1) 
			cadena += String.format("^%.0f", exponente);
		return cadena+=")";
	}
	//MÉTODOS DE OPERACIONES ENTRE MONOMIOS;
}
