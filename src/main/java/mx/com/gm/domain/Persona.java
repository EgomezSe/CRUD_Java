package mx.com.gm.domain;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

@Data
@Entity
@Table(name = "persona")
public class Persona implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPersona;
    
    @NotEmpty
    private String nombre;
    @NotEmpty
    private String apellido;
    @NotEmpty
    private String email;
    @NotEmpty
    private String telefono;
    
    private String personaToString(){
        return "idPersona:"+getIdPersona().toString()+";nombre:"+getNombre()+";apellido:"+getApellido()+";email:"+getEmail()+";telefono:"+getTelefono();
    }
}
