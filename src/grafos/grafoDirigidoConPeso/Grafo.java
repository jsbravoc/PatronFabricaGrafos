package grafos.grafoDirigidoConPeso;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import grafos.interfaces.IGrafoConPesos;
import grafos.interfaces.INodo;
import grafos.common.Nodo;
import grafos.common.ArcoConPeso;
public class Grafo implements IGrafoConPesos {

	List<Nodo> nodos = new ArrayList<>();
	List<ArcoConPeso> arcos = new ArrayList<>();
	
	public Grafo() { }
	
	public void addNodo(String nombre)
	{
		Nodo nodo = new Nodo();
		nodo.setNombre(nombre);
		nodos.add(nodo);
	}
	
	public void addArco(String origen, String destino, int peso) throws Exception {
		
		Nodo nodoOrigen = buscarNodo(origen);
		Nodo nodoDestino = buscarNodo(destino);
		
		// Origen o destino no encontrado
		if (nodoOrigen == null) {
			throw new RuntimeException("Error en la Búsqueda: NodoOrigen no encontrado");
		}
		if (nodoDestino == null) {
			throw new RuntimeException("Error en la Búsqueda: NodoDestino no encontrado");
		}
		
		addArco(nodoOrigen, nodoDestino, peso);
	}
	
	public void addArco(Nodo nodoOrigen, Nodo nodoDestino, int peso)
	{
		ArcoConPeso arco = new ArcoConPeso();
		arco.setOrigen(nodoOrigen);
		arco.setDestino(nodoDestino);
		arco.setPeso(peso);
		arcos.add(arco);
		nodoOrigen.agregarArco(arco);
	}
	
	public Nodo buscarNodo(String nombre) 
	{
		for (Nodo nodo: nodos) {
			if (nodo.getNombre().equals(nombre)) {
				return nodo;
			}
		}
		return null;
	}
	
	public boolean existeRuta(String origen, String destino) throws Exception {
		if (buscarRuta(origen, destino) != null) {
			return true;
		}
		return false;
	}
	
	public List<INodo> buscarRuta(String origen, String destino) throws Exception {
		
		Nodo nodoOrigen = buscarNodo(origen);
		Nodo nodoDestino = buscarNodo(destino);
		List<INodo> nodosRuta = new ArrayList<>();
		
		// Origen o destino no encontrado
		if (nodoOrigen == null) {
			throw new RuntimeException("Error en la Búsqueda: NodoOrigen no encontrado");
		}
		if (nodoDestino == null) {
			throw new RuntimeException("Error en la Búsqueda: NodoDestino no encontrado");
		}
		
		if (buscarRutaDFS(nodosRuta, nodoOrigen, nodoDestino)) {
			return nodosRuta;
		} else {
			return null;
		}
	}
	
	private boolean buscarRutaDFS(List<INodo> nodosRuta, Nodo nodoOrigen, Nodo nodoDestino) {
		
		// agrega el origen
	    nodosRuta.add(nodoOrigen);
		
		// origen y destino son el mismo ?
		if(nodoOrigen.getNombre().equals(nodoDestino.getNombre())){
            return true;
        }
		
		// si no son el mismo, revise las rutas usando una pila
        Stack<Nodo> pilaDeNodos = new Stack<>();
        ArrayList<Nodo> nodosVisitados = new ArrayList<>();

        pilaDeNodos.add(nodoOrigen);

        while(!pilaDeNodos.isEmpty()){
            Nodo actual = pilaDeNodos.pop();

            // ignore los nodos ya visitados
            if (nodosVisitados.contains(actual))
            	continue;
            
            // es el nodo que estamos buscando ?
            if (actual.equals(nodoDestino)) {
            	nodosRuta.addAll(pilaDeNodos);
            	nodosRuta.add(nodoDestino);
                return true;
            }
            else {
                // siga buscando en las rutas no visitadas
            	nodosVisitados.add(actual);
            	for(INodo nodo: actual.getNodosAdyacentes()) {
            		if (!pilaDeNodos.contains(nodo))
            			pilaDeNodos.add((Nodo) nodo);
            	}
            }
        }
        return false;
        
	}
	
}
