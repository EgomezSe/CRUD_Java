
package mx.com.gm.servicio;

import java.util.List;
import mx.com.gm.domain.Persona;


public interface PersonaServices {
    
    public List<Persona> listaPersona();
    
    public void guardar(Persona persona);
    
    public void eliminar(Persona persona);
    
    public Persona encontrarPersona(Persona persona);
    

}
