package com.itesm.azul.services;


import com.itesm.azul.models.Persona;
import com.itesm.azul.dto.PersonDTO;
import com.itesm.azul.repositories.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaService {

    @Autowired
    PersonaRepository personaRepository;
    //CREATE
    public void createPersona(final Persona persona){
        personaRepository.save(persona);
    }
    //READ
    public Iterable<Persona> lista(){
        return personaRepository.findAll();
    }
    public Persona getOne(String personaID){
        return personaRepository.findById(personaID).get();
    }
    public boolean existsId(String personaID){
        return personaRepository.existsById(personaID);
    }
    //UPDATE
    public Persona update(PersonDTO dto){
        Persona persona = personaRepository.findById(dto.getPersonaID()).get();
        persona.setPersonaID(dto.getPersonaID());
        persona.setNombre(dto.getNombre());
        persona.setEdad(dto.getEdad());
        return personaRepository.save(persona);
    }
    //DELETE
    public void delete(String personID){
        personaRepository.deleteById(personID);
    }



/*
    public Persona insertar(Persona persona) throws Exception{
        if(persona.getEdad()<18){
            throw new Exception("No puedes ser menor de edad");
        }
        //personaRepository.insert();
        return persona;
    }
*/

}
