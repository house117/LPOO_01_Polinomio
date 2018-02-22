package polinomio;

import java.util.ArrayList;
import java.util.ListIterator;


public class Polinomio{
	private ArrayList<Monomio> polinomito = new ArrayList<Monomio>();
	public ArrayList<Monomio> getList() {
		return polinomito;
	}
	//MÉTODO TO STRING
	public String toString() {
		String cadena = "";
		for(int i=0; i<polinomito.size();i++) {
			if(i==0)
				cadena += polinomito.get(i);
			else
				cadena += ("+"+polinomito.get(i));
			
		}
		return cadena;
		
	}
	//AGREGAR UN MONOMIO A LA LISTA RECIBIENDO SUS PROPIEDADES
	public void addMonomio(Double coeficiente, Double exponente) {
		Monomio moniomito = new Monomio(coeficiente, exponente);
		polinomito.add(moniomito);
	} 
	//AGREGAR UN MONOMIO A LA LISTA RECIBIENDO UN PROPIO MONOMIO
	public void addMonomio(Monomio moniomito) {
		polinomito.add(moniomito);
	}
	/*Para ordenar nuestro polinomio, util para division, SIMPLIFICA PRIMERO*/
	public void ordenarPolinomio() {
		this.simplificar();
		Polinomio poliAux = new Polinomio();
		Monomio moniAux;
		Double max = 0.0;
		while(!polinomito.isEmpty()) {
			for(int i=0; i<this.getList().size(); i++) {
				moniAux = this.getList().get(i);
				if(i==0) {
					max = moniAux.getExponente(); //para el primero asignamos max tal cual
				}else {
					if(max < moniAux.getExponente()) { //de ahi buscamos el mayor exponente 
						max = moniAux.getExponente(); //max se queda con el mayor exponente
					}
				}
			}
			for(int i=0; i<this.getList().size();i++) { //buscamos el termino con el mayor exponente
				moniAux = this.getList().get(i); 
				if(max == moniAux.getExponente()) { //Ingresamos el termino con mayor exponente en poliAux 
					poliAux.addMonomio(moniAux.getCoeficiente(), moniAux.getExponente());
					this.polinomito.remove(i); //Y lo eliminamos de polinomito
				}
			//Esto se repite hasta que polinomito este vacio
			}
		}
		//Después insertamos todo en polinomito
		this.polinomito.removeAll(polinomito);
		for(Integer i=0; i<poliAux.getList().size(); i++) {
			this.addMonomio(poliAux.getList().get(i).getCoeficiente(), poliAux.getList().get(i).getExponente());
		}
	}
	/*Método que evalua en la funcion el valor Double dado*/
	public Double evaluarF(Double fx) {
		Double resultado = 0.0;
		Monomio auxiliar;				//Nodo Monomio auxiliar para alojar el actual
		if(!polinomito.isEmpty()) {
			ListIterator<Monomio> PoliRunner = polinomito.listIterator();
			while(PoliRunner.hasNext()) {
				auxiliar = PoliRunner.next();	//Obtenemos el monomio actual y movemos el iterador al siguiente
				resultado += auxiliar.getCoeficiente()*Math.pow(fx, auxiliar.getExponente()); //SUSTITUCION coeficiente*fx^exponente
						
			}
			return resultado;
		}else {
			resultado = 0.0;
			return resultado;
		}
	}
	/*Método que simplifica el polinomio, términos con mismo exponente, eliminar coeficientes 0*/
	public void simplificar() {
		if(!polinomito.isEmpty()) {
			Monomio auxiliar1;
			Monomio auxiliar2;
			for(int i=0; i<polinomito.size(); i++) {
				auxiliar1 = polinomito.get(i);
				for(int j=i+1; j<polinomito.size(); j++) {
					auxiliar2 = polinomito.get(j);
					/*Reminder: no funciono el == con estos dos, preguntar por qué*/
					if(auxiliar1.getExponente() - auxiliar2.getExponente() == 0) { //Si tienen el mismo exponente
						auxiliar2.setCoeficiente(auxiliar1.getCoeficiente()+auxiliar2.getCoeficiente()); 
						/*Asignamos nuevo coeficiente al lejano que sera suma de los dos coef*/
						polinomito.remove(i);
						/*Eliminamos el que tiene index i*/
						i--; //Al eliminar un elemento de la lista cambiarán las posiciones de los index por tanto 
							// hay que restar uno  a i
					}
				}
				
			}
			for(int i=0; i<polinomito.size(); i++) { //Eliminacion de elementos que tengan 0 de coeficiente
				auxiliar1 = polinomito.get(i);
				if(auxiliar1.getCoeficiente() == 0.0) {
					polinomito.remove(i);
					i--;//Al eliminar un elemento de la lista cambiarán las posiciones de los index por tanto 
					// hay que restar uno  a i
				}
			}
		}
	}
	//Sumar otro polinomio a nuestro polinomio
	public void sumarPolinomio(Polinomio aSumar) {
		if(!this.polinomito.isEmpty()) {
			Integer i;
			for(i=0; i<aSumar.getList().size(); i++) {
				this.addMonomio(aSumar.getList().get(i).getCoeficiente(), aSumar.getList().get(i).getExponente());
			}
			this.simplificar();
		}
	}
	/*Restamos un polinomio dado a nuestro polinomio*/
	public void restarPolinomio(Polinomio aRestar) {
		if(!this.polinomito.isEmpty()) {
			for(Integer i=0; i<aRestar.getList().size(); i++) {
				this.addMonomio(-aRestar.getList().get(i).getCoeficiente(), aRestar.getList().get(i).getExponente());
			}
			this.simplificar();
		}
	}
	/*Multiplicamos un polinomio dado a nuestro polinomio*/
	public void multiplicarPolinomio(Polinomio aMultiplicar) {
		if(!this.polinomito.isEmpty()) {
			Monomio auxiliar1;
			Monomio auxiliar2;
			Polinomio polinomioAux = new Polinomio();
			for(Integer i=0; i<aMultiplicar.getList().size(); i++) {
				auxiliar1 = aMultiplicar.getList().get(i);
				for(Integer j=0; j<this.getList().size(); j++) {
					auxiliar2 = this.getList().get(j);
					polinomioAux.addMonomio(auxiliar1.getCoeficiente()*auxiliar2.getCoeficiente(), 
							auxiliar1.getExponente()+auxiliar2.getExponente());
				}
			}
			polinomioAux.simplificar();
			this.polinomito.removeAll(polinomito);
			for(Integer i=0; i<polinomioAux.getList().size(); i++) {
				this.addMonomio(polinomioAux.getList().get(i).getCoeficiente(), polinomioAux.getList().get(i).getExponente());
			}
		}
	}
	/*Nuestro polinomio entre el polinomio dado*/
	public void dividirPolinomio(Polinomio aDividir) {
		if(!this.polinomito.isEmpty() && !aDividir.getList().isEmpty()) {
			Polinomio dividendo = new Polinomio();
			Polinomio divisor = new Polinomio();
			Polinomio resta = new Polinomio();
			Polinomio cociente = new Polinomio();
			Monomio auxDividendo;
			Monomio auxDivisor;
			Monomio auxCociente;
			Double expDividendo;
			Double expDivisor;
			int contCociente = 0;
			int cero = 0;
			for(int i=0; i<this.getList().size(); i++) {
				dividendo.addMonomio(this.getList().get(i).getCoeficiente(), this.getList().get(i).getExponente());
			}
			dividendo.ordenarPolinomio();
			for(int i=0; i<aDividir.getList().size(); i++) {
				divisor.addMonomio(aDividir.getList().get(i).getCoeficiente(), aDividir.getList().get(i).getExponente());
			}
			divisor.ordenarPolinomio();
			dividendo.ordenarPolinomio();
			expDividendo = dividendo.getList().get(cero).getExponente();
			expDivisor = divisor.getList().get(cero).getExponente();
			while(expDividendo >= expDivisor && !dividendo.getList().isEmpty()) {
				auxDividendo = dividendo.getList().get(0);
				auxDivisor = divisor.getList().get(0);
				cociente.addMonomio(auxDividendo.getCoeficiente()/auxDivisor.getCoeficiente(), 
						auxDividendo.getExponente()-auxDivisor.getExponente());
				auxCociente = cociente.getList().get(contCociente);
				for(int i=0; i<divisor.getList().size(); i++) {
					resta.addMonomio(auxCociente.getCoeficiente()*divisor.getList().get(i).getCoeficiente(), 
							auxCociente.getExponente()+divisor.getList().get(i).getExponente());
					
				}
				dividendo.restarPolinomio(resta);
				dividendo.ordenarPolinomio();
				resta.getList().removeAll(resta.polinomito);
				contCociente++;
			}
			this.polinomito.removeAll(polinomito);
			for(int i=0; i<cociente.getList().size(); i++) {
				this.addMonomio(cociente.getList().get(i).getCoeficiente(), 
						cociente.getList().get(i).getExponente());
			}
		}
	}
	/*Resuelve la ecuación hasta cuadrática con +raiz o lineal*/
	public Double resolverMasRaiz() {
		Double respuesta = 0.0;
		this.simplificar();
		this.ordenarPolinomio();
		Double maxGrado = null;
		for(int i=0; i<this.getList().size(); i++) {
			if(i==0) {
				maxGrado = this.getList().get(i).getExponente();
			}else {
				if(this.getList().get(i).getExponente()>maxGrado) {
					maxGrado = this.getList().get(i).getExponente();
				}
			}
		}
		if(maxGrado<=2) {
			Integer grado = Integer.parseInt(String.format("%.0f", maxGrado));
			Double interRaiz;
			Double a = 0.0, b = 0.0, c = 0.0;
			for(int i = 0; i<this.getList().size(); i++) {
				if(this.getList().get(i).getExponente() == 2) {
					a = this.getList().get(i).getCoeficiente();
				}
				if(this.getList().get(i).getExponente() == 1) {
					b = this.getList().get(i).getCoeficiente();
				}
				if(this.getList().get(i).getExponente() == 0) {
					c = this.getList().get(i).getCoeficiente();
				}
			}
			switch (grado) {
			case 1:
				respuesta = -(this.getList().get(1).getCoeficiente())/this.getList().get(0).getCoeficiente();
				break;
			case 2:
				interRaiz = Math.pow(b, 2.0)-4*a*c;
				if(interRaiz>=0) {
					respuesta = (-b+Math.sqrt(interRaiz))/(2*a);
				}else {
					System.out.println("No real solution, ");
					respuesta = 0.0;
				}
				break;
					
			}
			
		}
		return respuesta;
	}
	/*Este metodo devuelve el resultado -raiz si es cuadratica*/
	public Double resolverMenosRaiz() {
		Double respuesta = 0.0;
		this.simplificar();
		this.ordenarPolinomio();
		Double maxGrado = null;
		for(int i=0; i<this.getList().size(); i++) {
			if(i==0) {
				maxGrado = this.getList().get(i).getExponente();
			}else {
				if(this.getList().get(i).getExponente()>maxGrado) {
					maxGrado = this.getList().get(i).getExponente();
				}
			}
		}
		if(maxGrado<=2) {
			Integer grado = Integer.parseInt(String.format("%.0f", maxGrado));
			Double interRaiz;
			Double a = 0.0, b = 0.0, c = 0.0;
			for(int i = 0; i<this.getList().size(); i++) {
				if(this.getList().get(i).getExponente() == 2) {
					a = this.getList().get(i).getCoeficiente();
				}
				if(this.getList().get(i).getExponente() == 1) {
					b = this.getList().get(i).getCoeficiente();
				}
				if(this.getList().get(i).getExponente() == 0) {
					c = this.getList().get(i).getCoeficiente();
				}
			}
			switch (grado) {
			case 1:
				respuesta = -(this.getList().get(1).getCoeficiente())/this.getList().get(0).getCoeficiente();
				break;
			case 2:
				interRaiz = Math.pow(b, 2.0)-4*a*c;
				if(interRaiz>=0) {
					respuesta = (-b-Math.sqrt(interRaiz))/(2*a);
				}else {
					System.out.println("No real solution, ");
					respuesta = 0.0;
				}
				break;
					
			}
			
		}
		return respuesta;
	}
	
	
}
