package main;

import grafos.interfaces.IGrafo;
import grafos.interfaces.IGrafoConPesos;
import grafos.interfaces.IGrafoSinPesos;

public class MainConInstanciacion {

	public static void main(String[] args) throws Exception {
		
		//Para probar las diferentes alternativas de grafos
		String Alternativa = "Peso";
		
		IGrafo g = FabricaGrafo.obtenerNuevoGrafo();
		
		g.addNodo("A");
		g.addNodo("B");
		g.addNodo("C");
		g.addNodo("D");
		
		if (g instanceof IGrafoSinPesos) {
			g = (IGrafoSinPesos) g;	

			((IGrafoSinPesos) g).addArco("A", "B");
			((IGrafoSinPesos) g).addArco("B", "C");
			((IGrafoSinPesos) g).addArco("A", "D");
		}
		else {
			g = (IGrafoConPesos) g;
			((IGrafoConPesos) g).addArco("A", "B", 10);
			((IGrafoConPesos) g).addArco("B", "C", 12);
			((IGrafoConPesos) g).addArco("A", "D", 10);
		}

		

		System.out.println(g.existeRuta("A", "C")); 
		System.out.println(g.existeRuta("C", "A")); 
		
		
	}
	
}
