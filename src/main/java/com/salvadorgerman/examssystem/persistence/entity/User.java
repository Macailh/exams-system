package com.salvadorgerman.examssystem.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY) // Se usa para indicar como se generará la clave primaria *
    private Long id;
    private String username;
    private String password;
    private String name;
    private String lastname;
    private String email;
    private String phone;
    private boolean enabled;
    private String profile;

    // Establece una relación de 1 a muchos entre 2 entidades de una base de datos
    @OneToMany( // cascade y fetch con esta anotación *
            cascade = CascadeType.ALL, // Opción para estrablecer una cascada de operaciones *
            fetch = FetchType.EAGER, // Opción que indica como seran cargadas las entidades asociadas *
            mappedBy = "user") // Atributo que se utiliza para especificar el lado dueño de la relación
    // Anotación Jackson que sirve para excluir propiedades en la representacióñ JSON
    @JsonIgnore
    private Set<UserRol> userRols = new HashSet<>();
}

//    *   CascadeType.PERSIST: las operaciones de persistencia (guardar) se cascan a las entidades asociadas.
//        CascadeType.MERGE: las operaciones de merge (combinar) se cascan a las entidades asociadas.
//        CascadeType.REMOVE: las operaciones de eliminación se cascan a las entidades asociadas.
//        CascadeType.REFRESH: las operaciones de actualización se cascan a las entidades asociadas.

//    *   FetchTyper.EAGER: ansioso, cuando se cargue una entidad tambien se cargan las entidades asociadas.
//        FetchType.LAZY: perezoso, indica que la relación se cargará solo cuando se solicite explícitamente.

//     *  GenerationType.IDENTITY: la base de datos generará un valor único para la clave primaria cada vez que se inserta una nueva fila en la tabla de la entidad.
//        GenerationType.SEQUENCE: la clave primaria se genera a partir de una secuencia en la base de datos.
//        GenerationType.TABLE: se utiliza una tabla especial en la base de datos para generar claves primarias.
//        GenerationType.AUTO: la elección de la estrategia de generación se delega a la base de datos o al proveedor de persistencia.

//      * OneToOne: esta relación indica que una instancia de una entidad puede estar asociada a una sola instancia de otra entidad.
//        OneToMany: esta relación indica que una instancia de una entidad puede tener muchas instancias de otra entidad asociadas.
//        ManyToOne: esta relación indica que muchas instancias de una entidad pueden estar asociadas a una sola instancia de otra entidad.
//        ManyToMany: esta relación indica que muchas instancias de una entidad pueden estar asociadas a muchas instancias de otra entidad.