package grafos.busqueda.interfaces;

import java.util.List;

import grafos.interfaces.INodo;


public interface IEstrategiaBusqueda {
        
	public boolean existeRuta(String origen, String destino) throws Exception;
	
	public List<INodo> buscarRuta(String origen, String destino) throws Exception;
        
}