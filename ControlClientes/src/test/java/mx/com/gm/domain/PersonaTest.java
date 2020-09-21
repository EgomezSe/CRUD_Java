/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.domain;

import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.test.util.ReflectionTestUtils;


public class PersonaTest {

    @Test
    public void testEquals() {
        Persona persona = new Persona();
        assertTrue(persona.equals(new Persona()));
    }
    

    @Test
    public void testEqualsFalse() {
        Persona persona = new Persona();
        Persona persona2 = new Persona();
        persona2.setApellido("Gomez");
        assertFalse(persona.equals(persona2));
    }
    
     @Test
    public void testEqualsFalseNull() {
        Persona persona = new Persona();
        assertFalse(persona.equals(null));
    }
    
    @Test
    public void testEqualsValue() {
        Persona persona = new Persona();
        Persona persona2 = new Persona();
        Long id = new Long(123);
        
        persona.setIdPersona(id);
        persona.setNombre("Edwar");
        persona.setApellido("Gomez");
        persona.setEmail("Serna@gmail.com");
        persona.setTelefono("121212");
        //Comparar personas
        persona2.setIdPersona(id);
        persona2.setNombre("Edwar");
        persona2.setApellido("Gomez");
        persona2.setEmail("Serna@gmail.com");
        persona2.setTelefono("121212");
        assertTrue(persona.equals(persona2));
        assertEquals(persona, persona2);
    }
    
    @Test
    public void testEqualsValueFalse(){
        
        Persona persona = new Persona();
        Persona persona2 = new Persona();
        Long id = new Long(123);
        
        Long id2 = new Long(321);
        
        persona.setIdPersona(id);
        persona.setNombre("Edwar");
        persona.setApellido("Gomez");
        persona.setEmail("Serna@gmail.com");
        persona.setTelefono("121212");
        //Comparar personas
        persona2.setIdPersona(id2);
        persona2.setNombre("Edwar");
        persona2.setApellido("Gomez");
        persona2.setEmail("Serna@gmail.com");
        persona2.setTelefono("121212");
        assertFalse(persona.equals(persona2));
    }

    @Test
    public void testHashCode() {
        Persona persona = new Persona();
        assertNotNull(persona.hashCode());
    }
    
    @Test
    public void testHashCodeNull() {
        Persona persona  = new Persona();
        Long id = new Long(321);
        
        persona.setIdPersona(id);
        persona.setNombre("Edwar");
        persona.setApellido("Gomez");
        persona.setEmail("Serna@gmail.com");
        persona.setTelefono("121212");
        assertNotNull(persona.hashCode());
    }
    
    
    
     @Test
    public void testModifyIdPersona(){
        Persona persona = new Persona();
        Long idPersona = new Long(1231);
        ReflectionTestUtils.setField(persona, "idPersona", idPersona);
        assertEquals(idPersona, persona.getIdPersona());
    }
    @Test
    public void testModifyNombrePersona(){
        Persona persona = new Persona();
        ReflectionTestUtils.setField(persona, "nombre", "Edwar");
        assertEquals("Edwar", persona.getNombre());
    }
    @Test
    public void testModifyApellidoPersona(){
        Persona persona = new Persona();
        ReflectionTestUtils.setField(persona, "apellido", "Gomez");
        assertEquals("Gomez", persona.getApellido());
    }
    @Test
    public void testModifyEmailPersona(){
        Persona persona = new Persona();
        ReflectionTestUtils.setField(persona, "email", "edwar@gmail.com");
        assertEquals("edwar@gmail.com", persona.getEmail());
    }
    @Test
    public void testModifyTelefonoPersona(){
        Persona persona = new Persona();
        ReflectionTestUtils.setField(persona, "telefono", "2342423423");
        assertEquals("2342423423", persona.getTelefono());
    }
    
    @Test
    public void testObjetoPersona(){
        Persona persona = new Persona();
        Long id = new Long(123);
        persona.setIdPersona(id);
        persona.setNombre("Edwar");
        persona.setApellido("Gomez");
        persona.setEmail("Serna@gmail.com");
        persona.setTelefono("121212");
        assertTrue(ReflectionTestUtils.invokeMethod(persona,"personaToString").equals("idPersona:123;nombre:Edwar;apellido:Gomez;email:Serna@gmail.com;telefono:121212"));
    }
    
    
    @Test
    public void testEmptyNombre(){
        Persona persona = new Persona();
        assertEquals(null, persona.getNombre());
    }
    @Test
    public void testEmptyApellido(){
        Persona persona = new Persona();
        assertEquals(null, persona.getApellido());
    }
    @Test
    public void testEmptyEmail(){
        Persona persona = new Persona();
        assertEquals(null, persona.getEmail());
    }
    
    @Test
    public void testEmptyTelefono(){
        Persona persona = new Persona();
        assertEquals(null, persona.getTelefono());
    }
}
