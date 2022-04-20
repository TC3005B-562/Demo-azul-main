package com.itesm.azul.controllers;

import com.itesm.azul.models.Persona;
import com.itesm.azul.dto.PersonDTO;
import com.itesm.azul.repositories.PersonaRepository;
import com.itesm.azul.services.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/v1/persona")
public class PersonaController {

    @Autowired
    PersonaService personaService;

    //Create
    //insert a tuple
    @PostMapping("/save")
    public PersonDTO save(@RequestBody PersonDTO persona) throws Exception{
        personaService.createPersona(persona);
        return persona;
    }
    //Read
    //select 1 tuple
    @GetMapping("/perfil/{personaID}")
    public ResponseEntity<Persona> getOne(@PathVariable("personaID") String personaID){
        if(!personaService.existsId(personaID))
            return new ResponseEntity("no existe", HttpStatus.NOT_FOUND);
        return ResponseEntity.ok(personaService.getOne(personaID));
    }
    //select all tuples
    @GetMapping("/all")
    public ResponseEntity<Iterable<Persona>> getAll(){
            return ResponseEntity.ok(personaService.lista());
    }

    //Update a tuple
    @PutMapping("/perfil")
    public ResponseEntity<Persona> update(@RequestBody PersonDTO personaDTO){
        if(!personaService.existsId(personaDTO.getPersonaID()))
            return new ResponseEntity("no existe, no se puede actualizar", HttpStatus.NOT_FOUND);
        return ResponseEntity.ok(personaService.update(personaDTO));
    }

    //Delete a tuple
    @DeleteMapping("/perfil/{personaID}")
    public ResponseEntity<?> delete(@PathVariable("personaID") String personaID){
        if(!personaService.existsId(personaID))
            return new ResponseEntity("no existe", HttpStatus.NOT_FOUND);
        personaService.delete(personaID);
        return new ResponseEntity("persona eliminada", HttpStatus.OK);
    }

}
