package com.itesm.azul.repositories;


import com.itesm.azul.models.Persona;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

@EnableScan
public interface PersonaRepository extends
    CrudRepository<Persona, String>{

    }
/*
    public List<Persona> findAll(){
        Persona p1= new Persona();
        p1.setNombre("Andres");
        p1.setEdad(32);
        Persona p2= new Persona();
        p2.setNombre("Paola");
        p2.setEdad(21);
        List<Persona> personas= new ArrayList<>();
        personas.add(p1);
        personas.add(p2);
        return personas;
    }

}

 */
