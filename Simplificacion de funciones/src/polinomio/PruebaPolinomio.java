package polinomio;

public class PruebaPolinomio {
	public static void main(String[] args) {
		Monomio moni = new Monomio(-4.0, 5.0); //Monomios de prueba
		Monomio moni1 = new Monomio(1.0, 0.0);
		Monomio moni2 = new Monomio(-1.0, 0.0);
		System.out.println(moni); //Prueba de toString
		System.out.println(moni1);
		System.out.println(moni2);
		Polinomio poli = new Polinomio(); //Polinomio de prueba
		poli.addMonomio(moni);				//Probando agregar un monomio
		poli.addMonomio(moni1);				//probando agregar un monomio
		poli.addMonomio(1.0,  2.0);			//probando agregar coeficiente y exponente y crea el monomio
		Polinomio poli2 = new Polinomio(); //Polinomio de pruebas
		poli2.addMonomio(3.0, 5.0);
		poli2.addMonomio(1.0, 2.0);
		poli2.addMonomio(5.0, 1.0);;
		System.out.println("El polinomio 1 es: "+poli);  //PRUEBAS DE AGREGAR MONOMIOS
		System.out.println("El polinomio 2 es: "+poli2);
		System.out.println();
		poli.sumarPolinomio(poli2);						//PRUEBA DE SUMA DE POLINOMIOS
		System.out.println("El polinomio 1 after Suma es: "+poli);
		System.out.println("El polinomio 2 after Suma es: "+poli2);
		System.out.println();
		poli.restarPolinomio(poli2); 					//PRUEBA DE RESTA DE POLINOMIOS
		System.out.println("El polinomio 1 after Resta es: "+poli);
		System.out.println("El polinomio 2 after Resta es: "+poli2);
		System.out.println();
		poli.multiplicarPolinomio(poli2);				//PRUEBA DE MULTIPLICACION DE POLINOMIOS
		System.out.println("El polinomio 1 after multiplicacion es: "+poli);
		System.out.println("El polinomio 2 after multiplicacion es: "+poli2);
		System.out.println();
		poli.ordenarPolinomio();						//PRUEBA DE ORDENACION DE POLINOMIOS
		poli2.ordenarPolinomio();
		System.out.println("El polinomio 1 after ordenacion es: "+poli);
		System.out.println("El polinomio 2 after ordenacion es: "+poli2);
		System.out.println();
		System.out.println("PRUEBA DIVISION");			//PRUEBA DIVISION DE POLINOMIOS CON CASO EXACTO
		Polinomio poliDiv1 = new Polinomio();			//EN CASOS NO EXACTOS NO GUARDA RESIDUO
		Polinomio poliDiv2 = new Polinomio();
		poliDiv1.addMonomio(6.0, 5.0);				//SETTEANDO VALORES DE UN PROBLEMA YA RESUELTO
		poliDiv1.addMonomio(23.0, 4.0);
		poliDiv1.addMonomio(-5.0, 3.0);
		poliDiv1.addMonomio(-14.0, 2.0);
		poliDiv1.addMonomio(-35.0, 1.0);
		poliDiv1.addMonomio(20.0, 0.0);
		poliDiv2.addMonomio(3.0, 3.0);
		poliDiv2.addMonomio(1.0, 2.0);
		poliDiv2.addMonomio(-5.0, 0.0);
		System.out.println("El poliDiv1 es: "+poliDiv1);
		System.out.println("El poliDiv2 es: "+poliDiv2);
		System.out.println();
		poliDiv1.dividirPolinomio(poliDiv2);				//REALIZANDO DIVISION
		System.out.println("El poliDiv1 after division es: "+poliDiv1);
		System.out.println("El poliDiv2 after division es: "+poliDiv2);
		System.out.println();
		Polinomio poliLin = new Polinomio(); 	//Polinomio para probar caso lineal X+B=0
		Polinomio poliCuad = new Polinomio();  //Polinomio que usa ec. cuadratica ax^2+bx+c =0
		poliLin.addMonomio(4.0, 1.0);
		poliLin.addMonomio(5.0, 0.0);
		poliCuad.addMonomio(3.0, 2.0);
		poliCuad.addMonomio(5.0, 1.0);
		poliCuad.addMonomio(1.0, 0.0);
		System.out.println("Para poliLin x = "+poliLin.resolverMasRaiz()); 
		//para la lineal da igual si usamos el metodo mas raiz o menos raiz
		System.out.println("Para poloCuad x1 = "+poliCuad.resolverMasRaiz()); //x1 +raiz 
		System.out.println("Para poloCuad x2 = "+poliCuad.resolverMenosRaiz()); //x2 -raiz
		
	}
}
