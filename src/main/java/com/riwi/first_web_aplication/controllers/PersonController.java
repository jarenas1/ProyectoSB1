package com.riwi.first_web_aplication.controllers;

import com.riwi.first_web_aplication.entities.PersonEntity;
import com.riwi.first_web_aplication.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.util.List;

@Controller //INDICAMOS QUE ES UN CONTROLADOR
public class PersonController {

    //INYECTAMOS EL SERVICE PARA PODER ACCEDER A LOS METODOS

    @Autowired
    PersonService personService;

    //LLAMAMOS TODOS LOS METODOS Y CREAMOS SU CONTROLADOR

    public String listarPersonas(Model model){//ESE MODEL ES UNA CLASE QUE PERMITE TRANSFERIR DATOS DEL CONTROLDOR A LA VISTA
       List<PersonEntity> persons = personService.obtenerTodos();
       //AÑADIMOS UN ATRIBUTO A ESTE MODELO, CLAVE:VALOR
        model.addAttribute("personsList",persons);
        return "personList"; //ACA VA El NOMBRE DEL DOCUMENTO HTML CREADO EN TEMPLATES
    }

}
