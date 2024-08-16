package com.riwi.first_web_aplication.services.implementation;

import com.riwi.first_web_aplication.entities.PersonEntity;
import com.riwi.first_web_aplication.repositories.PersonRepository;
import com.riwi.first_web_aplication.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
//IMPLEMENTAMOS LAS CLASES
@Service
public class PersonImplementation implements PersonService {

    //INYECTAMOS LA INSTANCIA DE REPOSITORIO PARA PODER ACCEDER A LOS METODOS
    @Autowired
    private PersonRepository personRepository;

    //AHORA EN CADA METODO LLAMAMOS A LOS METODOS DEL REPOSITORIO
    @Override

    public List<PersonEntity> obtenerTodos() {
        return personRepository.findAll();
    }

    @Override
    public PersonEntity buscarId(Long id) {
        return personRepository.findById(id).orElse(null); //EL ORELSE LO QUE HACE ES QUE SI NO LO ENCUENTRA DEVUELVE OTRA COSA, EN ESTE CASO NULL
    }

    @Override
    public PersonEntity crearPerson(PersonEntity personEntity) {
        return personRepository.save(personEntity);
    }

    @Override
    public void eliminarPerson(Long id) {
        personRepository.deleteById(id);
    }

    //EDITAR SE HACE DE FORMA DIFERENTE ASI:
    //Se llama al objeto por medio del id y se guarda en una instancia nueva

    //Verificamos si lo encontro

    //Ahora vamos modificando las cosas de la instamcia creada adentro

    //AHORA VOLVEMOS A GUARDAR (como el id es el mismo automaticamente se modifica y no se crea)
    @Override
    public PersonEntity editarPerson(Long id, PersonEntity personEntity) {
        PersonEntity personToUpdate = personRepository.findById(id).orElse(null);

        if (personToUpdate != null){
            personToUpdate.setName(personEntity.getName());
            personToUpdate.setAge(personEntity.getAge());

            return personRepository.save(personToUpdate);
        }
        return null;
    }
}
