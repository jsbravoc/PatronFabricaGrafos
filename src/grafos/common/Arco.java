package grafos.common;

import grafos.interfaces.IArco;
import grafos.interfaces.INodo;

public class Arco implements IArco {

	private INodo origen;
	
	private INodo destino;
	
	public Arco() {	}
	
	public INodo getOrigen() {
		return origen;
	}
	public void setOrigen(INodo origen) {
		this.origen = origen;
	}
	
	public Nodo getDestino() {
		return (Nodo) destino;
	}
	public void setDestino(INodo destino) {
		this.destino = destino;
	}
	
}
