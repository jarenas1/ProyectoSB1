package com.riwi.first_web_aplication.services;

import com.riwi.first_web_aplication.entities.PersonEntity;

import java.util.List;

public interface PersonService {

    //CREAMOS LAS CLASES ESPECIFICAS DE LA PERSONA

    List<PersonEntity> obtenerTodos();

    PersonEntity buscarId(Long id);

    PersonEntity crearPerson(PersonEntity personEntity);

    void eliminarPerson(Long id);

    PersonEntity editarPerson(Long id, PersonEntity personEntity);
}
