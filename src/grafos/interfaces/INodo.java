package grafos.interfaces;

import java.util.List;


public interface INodo {
	
	public String getNombre();
	public void setNombre(String nombre);
	public void agregarArco(IArco arco);
	public List<IArco> getArcos();
	public List<INodo> getNodosAdyacentes();
        
}