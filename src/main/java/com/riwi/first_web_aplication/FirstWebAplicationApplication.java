package com.riwi.first_web_aplication;

import com.riwi.first_web_aplication.entities.PersonEntity;
import com.riwi.first_web_aplication.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class FirstWebAplicationApplication implements CommandLineRunner {//Para que nos permita correr las cosas aca

	public static void main(String[] args) {
		SpringApplication.run(FirstWebAplicationApplication.class, args);
	}

	//AHORA VAMOS A AÑADIR USUARIOS A LA BASE DE DATOS POR MEDIO DE LAS COSAS QIE EXTENDIMOS EN EL RESPOSITORIO
	//Instanciamos el repository para poder acceder a los metodos etendidos a esta
	@Autowired
	 private PersonRepository personRepository;


	//CREAMOS ESTE METODO PARA PODER CORRER UN BEAN, EN ESTE CASO EL REPOSITORY
	@Override
	public void run(String... args)throws Exception{
		personRepository.save(new PersonEntity(1L,"Juan",18));
		personRepository.save(new PersonEntity(2L,"Andres",38));

		System.out.println("Cantidad de registros en la tabla por medio de .count que viene de repository: "+ personRepository.count());

		System.out.println("Lista de personas con el metodo findAll()");
		List<PersonEntity> persons = personRepository.findAll(); //AHORA SOLO ITERAMOS
		persons.forEach(person -> System.out.println("name "+ person.getName()));

	}
//LO UNICO QUE TENEMOS QUE HACER ES LLAMAR AL METODO SAVE DEL REPOSITORY PARA GUARDAR TODO AUTOMATICAMENTE, SIN TNEER QUE CREAR NADA COMO EN JDBC
}
