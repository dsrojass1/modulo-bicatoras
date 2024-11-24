package com.matrix.modulo_bicatoras.model;

import lombok.Data;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

@Data
@Document(collection = "coordinadores")
public class CoordinadorEntity {
    
    @Id
    @Field(value = "identificacion", targetType = FieldType.INT32)
    private Integer identificacion;

    @Field(value = "nombre", targetType = FieldType.STRING)
    private String nombre;

    @Field(value = "email", targetType = FieldType.STRING)
    private String email;

    @Field(value = "password", targetType = FieldType.STRING)
    private String password;
    
}
