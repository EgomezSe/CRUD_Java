package mx.com.gm.web;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.IOException;
import java.util.ArrayList;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import mx.com.gm.domain.Persona;
import mx.com.gm.servicio.PersonaServices;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

@Controller
@Slf4j
public class ControladorInicio {
    
    @Autowired
    private PersonaServices personaService;
    
    @Autowired
    private RestTemplate restTemplate;
    
    @GetMapping("/agregar")
    public String agregar(Persona persona){
        return "modificar";
    }
    
     @PostMapping("/reporte")
    public String reporte(Model model) throws ParseException{
         String url = "https://tmvusa4yu3.execute-api.us-east-2.amazonaws.com/default/FuncionLambda";
       
        String response = restTemplate.getForObject(url, String.class);
        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject)parser.parse(response);
        String fecha = json.get("fecha").toString();
        String mensaje = json.get("mensaje").toString();
        System.out.println(json.get("mensaje").toString());
        
        model.addAttribute("mensaje", mensaje);
        model.addAttribute("fecha", fecha);
        return "reporte";
    }
    @PostMapping("/guardar")
    public String guardar(@Valid Persona persona, Errors errores){
        if(errores.hasErrors()){
            return "modificar";
        }
        personaService.guardar(persona);
        return "redirect:/";
    }
    
    @GetMapping("/editar/{idPersona}")
    public String editar(Persona persona, Model model){
       persona = personaService.encontrarPersona(persona);
       model.addAttribute(persona);
       return "modificar";
    }
    
    @GetMapping("/eliminar")
    public String eliminar(Persona persona){
        personaService.eliminar(persona);
        return "redirect:/";
    }
    
    @GetMapping("/")
    public String inicio(Model model) throws IOException, ParseException{
        ArrayList<Persona> personas = new ArrayList<Persona>();
        personas = (ArrayList<Persona>) personaService.listaPersona();
        log.info("ejecutando el controlador Spring MVC");
        model.addAttribute("personas", personas);
        
        return "index";
    }
}