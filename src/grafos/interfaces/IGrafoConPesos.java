package grafos.interfaces;

public interface IGrafoConPesos extends IGrafo {
        
        public void addArco(String origen, String destino, int peso) throws Exception;
        
}