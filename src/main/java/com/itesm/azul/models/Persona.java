package com.itesm.azul.models;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "Persona")
public class Persona {
    private String personaID;
    private String nombre;
    private String edad;
    @DynamoDBHashKey(attributeName = "personaID")
    public String getPersonaID(){
        return personaID;
    }
    public void setPersonaID(String personaID) {
        this.personaID = personaID;
    }

    @DynamoDBAttribute(attributeName = "nombre")
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @DynamoDBAttribute(attributeName = "edad")
    public String getEdad() {
        return edad;
    }
    public void setEdad(String edad) {
        this.edad = edad;
    }
}
