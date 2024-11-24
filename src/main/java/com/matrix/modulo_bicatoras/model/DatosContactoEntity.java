package com.matrix.modulo_bicatoras.model;

import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

import lombok.Data;

@Data
public class DatosContactoEntity {
    
    @Field(value = "afiliadoPrincipal")
    private ContactoEntity afiliadoPrincipal;

    @Field(value = "personaAutorizada")
    private ContactoEntity personaAutorizada;

    @Field(value = "direccionAp", targetType = FieldType.STRING)
    private String direccionAp;

    @Field(value = "ciudadAp", targetType = FieldType.STRING)
    private String ciudadAp;

    @Field(value = "emailAp", targetType = FieldType.STRING)
    private String emailAp;

    @Field(value = "celular1Ap", targetType = FieldType.STRING)
    private String celular1Ap;

    @Field(value = "celular2Ap", targetType = FieldType.STRING)
    private String celular2Ap;

}
