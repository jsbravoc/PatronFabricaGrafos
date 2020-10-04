package main;

import java.io.FileReader;
import java.util.Properties;

import grafos.interfaces.IGrafo;

public class FabricaGrafo {

	public static String getOpcionConfigurada() {		

		// lee el archivo de configuración
		Properties opciones = new Properties();
		
		try {
			opciones.load(new FileReader("config-instanciacion.properties"));			
		} catch (Exception e) {
			// ignora cualquier error leyendo el archivo
		}
				
		// obtiene el valor. por defecto use "grafos.grafo.Grafo"
		return opciones.getProperty("grafo", "grafos.grafo.Grafo");

	}
	
	public static IGrafo obtenerNuevoGrafo() {
				
		// obtiene la opción configurada
		String opcion = FabricaGrafo.getOpcionConfigurada();
		
		// crea el objeto de acuerdo a la opción configurada
		IGrafo grafo = null;
		try {
			grafo = (IGrafo) Class.forName(opcion).newInstance();

		} catch (Exception e) {
			// No se pudo crear el algoritmo
			throw new RuntimeException("No se pudo crear el grafo");
		}
		return grafo;
	}
	
}
