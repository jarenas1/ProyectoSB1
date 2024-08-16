package com.riwi.first_web_aplication.repositories;

import com.riwi.first_web_aplication.entities.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Extendemos la interfaz JpaRepository(Este nos trae varios metodos CRUD) y asignamos en los genericos, el tipo de identidad y el tipo de dato del id

//INDICAMOS TAMBIEN QUE ES UN ESTEREOTIPO, es decir que hereda de Component EN ESTE CASO REPOSITORY
@Repository
public interface PersonRepository extends JpaRepository<PersonEntity,Long> {
}
