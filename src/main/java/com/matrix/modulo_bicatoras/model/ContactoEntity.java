package com.matrix.modulo_bicatoras.model;

import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

import lombok.Data;

@Data
public class ContactoEntity {
    
    @Field(value = "identificacion", targetType = FieldType.INT32)
    private Integer identificacion;

    @Field(value = "nombre", targetType = FieldType.STRING)
    private String nombre;

    @Field(value = "parentescoConFallecido", targetType = FieldType.STRING)
    private String parentescoConFallecido;

    @Field(value = "celular", targetType = FieldType.STRING)
    private String celular;
}
