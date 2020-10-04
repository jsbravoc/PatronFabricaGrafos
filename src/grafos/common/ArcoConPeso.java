package grafos.common;

import grafos.interfaces.IArco;
import grafos.interfaces.INodo;

public class ArcoConPeso implements IArco {

	private Nodo 	origen;
	private Nodo 	destino;
	private int		peso;
	
	public ArcoConPeso() {	}
	
	public INodo getOrigen() {
		return (INodo) origen;
	}
	public void setOrigen(INodo origen) {
		this.origen = (Nodo) origen;
	}
	
	public INodo getDestino() {
		return (INodo) destino;
	}
	public void setDestino(INodo destino) {
		this.destino = (Nodo) destino;
	}
	
	public int getPeso() {
		return peso;
	}
	public void setPeso(int peso) {
		this.peso = peso;
	}
}
