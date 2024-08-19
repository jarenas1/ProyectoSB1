package com.riwi.first_web_aplication.controllers;

import com.riwi.first_web_aplication.entities.PersonEntity;
import com.riwi.first_web_aplication.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller //INDICAMOS QUE ES UN CONTROLADOR
@RequestMapping("/persons") //PARA ACCEDER AL METODO NECESITAMOS ESTO
public class PersonController {

    //INYECTAMOS EL SERVICE PARA PODER ACCEDER A LOS METODOS

    @Autowired
    PersonService personService;

    //LLAMAMOS TODOS LOS METODOS Y CREAMOS SU CONTROLADOR

    @GetMapping //INDICAMOS QUE ES GET
    public String listarPersonas(Model model){//ESE MODEL ES UNA CLASE QUE PERMITE TRANSFERIR DATOS DEL CONTROLDOR A LA VISTA
       List<PersonEntity> persons = personService.obtenerTodos();
       //AÑADIMOS UN ATRIBUTO A ESTE MODELO, CLAVE:VALOR
        model.addAttribute("personsList",persons);
        return "person"; //ACA VA El NOMBRE DEL DOCUMENTO HTML CREADO EN TEMPLATES
    }

    @GetMapping("/new")//LA RUTA DE ESTE METODO
    public String formNew (Model model){
        model.addAttribute("person", new PersonEntity());//ENVIAMOS UNA PERSONA VACIA A LA CUAL SE LE ASIGNARAN LOS DATOS DEL FORMULARIO
        model.addAttribute("action"," /persons/new"  );//INDICAMOS LA RUTA A LA QUE NOS REDIRIGIRA EL FORM AL ENVIAR EN ESTE CASO EL METODO DE CREAR
        return "form";
    }

    @PostMapping("/new")//PONEMOS LA DIRECCION QUE TIENE EL METODO, LA CUAL DEBE SER LA MISMA QUE LA QUE INDICAMOS EN EL FORMULARIO EN ACTION
    public String createPerson(@ModelAttribute PersonEntity personEntity){//modelattribute va a tomar cada uno de los campos y se lo va a asignar al objeto por medio de lo que indicamos en el html
        personService.crearPerson(personEntity); //Añadimos a la persona
        return "redirect:/persons";//CUANDO SE CREE LA PERSONA NOS REDIRIJE A LA PAGINA INICIAL
    }

    @GetMapping("/update/{id}")
    public String updateForm(@PathVariable Long id, @ModelAttribute PersonEntity personEntity, Model model){ //la anotacion permite pasarle variables a la url y la otra enlaza campos dell form con campos del objeto
        model.addAttribute("person", personEntity);//ENVIAMOS LA PERSONA CON EL ID INGRESADO
        model.addAttribute("action"," /persons/update/"+id);//INDICAMOS LA RUTA A LA QUE NOS REDIRIGIRA EL FORM AL ENVIAR EN ESTE CASO EL METODO DE EDITAR Y LE AÑADIMOS SU ID
        return "form";
    }

    @PostMapping("/update/{id}")
    public String updatePerson(@PathVariable Long id,@ModelAttribute PersonEntity personEntity){
        personService.editarPerson(id,personEntity);
        return "redirect:/persons";
    }

    @GetMapping("/delete/{id}")
    public String deletePerson(@PathVariable Long id){//DECIMOS QUE LA VARIABLE QUE ESTA ENTRANDO POR URL SE ASIGNARA COMO ID
        personService.eliminarPerson(id);
        return "redirect:/persons";
    }
}
