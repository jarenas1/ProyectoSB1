package com.riwi.first_web_aplication.controllers;

import com.riwi.first_web_aplication.entities.PersonEntity;
import com.riwi.first_web_aplication.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
        model.addAttribute("action"," /persons/new"  );//INDICAMOS LA RUTA A LA QUE NOS REDIRIGIRA EL FORM AL ENVIAR
        return "form";
    }

}
