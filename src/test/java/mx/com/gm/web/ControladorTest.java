package mx.com.gm.web;

import java.util.ArrayList;
import mx.com.gm.domain.Persona;
import mx.com.gm.servicio.PersonaServices;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.mockito.InjectMocks;
import static org.mockito.Matchers.isA;
import org.mockito.Mock;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;

public class ControladorTest {

    @InjectMocks
    private ControladorInicio controlador;
    
    @Mock
    private PersonaServices servicioPersona;
    
    @Mock
    private Model model;
    
    @Mock
    Errors error;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }
    
    @Test
    public void testAgregarPersona() {
        Persona persona = new Persona();
        String resultado = controlador.agregar(persona);
        assertEquals("modificar", resultado);
    }

    @Test
    public void testAgregar() {
        assertEquals("modificar", controlador.agregar(null));
    }
    
    @Test
    public void testEliminar(){
        doNothing().when(servicioPersona).eliminar(isA(Persona.class));
        assertEquals("redirect:/", controlador.eliminar(new Persona()));
    }
    
    @Test
    public void testGuardar(){
        doNothing().when(servicioPersona).guardar(isA(Persona.class));
        when(error.hasErrors()).thenReturn(Boolean.FALSE);
        assertEquals("redirect:/", controlador.guardar(new Persona(), error));
    }
    
    @Test
    public void editar(){
        doNothing().when(servicioPersona).guardar(isA(Persona.class));
       assertEquals("modificar", controlador.editar(new Persona(), model));
    }
}
