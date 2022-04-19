package com.itesm.azul.dto;


public class PersonDTO {
    private String personaID;
    private String nombre;
    private String edad;
    public String getPersonaID(){
        return personaID;
    }
    public void setPersonaID(String personaID) {
        this.personaID = personaID;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEdad() {
        return edad;
    }
    public void setEdad(String edad) {
        this.edad = edad;
    }

}
