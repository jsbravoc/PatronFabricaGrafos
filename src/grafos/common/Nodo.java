package grafos.common;

import java.util.ArrayList;
import java.util.List;

import grafos.interfaces.IArco;
import grafos.interfaces.INodo;

public class Nodo implements INodo {
	
	private String 		nombre;
	private List<IArco>	arcos = new ArrayList<>();
	
	public Nodo() { }
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void agregarArco(IArco arco) {
		arcos.add(arco);
	}

	public List<IArco> getArcos() {
		return arcos;
	}
	
	public List<INodo> getNodosAdyacentes() {
		List<INodo> nodos = new ArrayList<>();
		for (IArco arco : arcos) {
			nodos.add(arco.getDestino());
		}
		return nodos;
	}
	
}
