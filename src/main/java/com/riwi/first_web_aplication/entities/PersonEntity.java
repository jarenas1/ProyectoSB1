package com.riwi.first_web_aplication.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity //INDICAMOS QUE ES UNA ENTIDAD PARA QUE ME PUEDA PERMITIR MAPEARLO

@Table(name = "persons") //Esto indica el nombre que va a tener la tabla cuando se cree si no ponemos nada se creara con el nombre de la clase
public class PersonEntity {

    //AÑADIMOS LOS ATRIBUTOS DE ESTA ENTIDAD

    @Id //Como esto va a ser mapeado y convertido en una entidad, debemos indicar una PK, y para esto le ponemos @id al id
    private Long id;

    private String name;
    private int age;
}
