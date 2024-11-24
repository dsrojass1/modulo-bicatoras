package com.matrix.modulo_bicatoras.model;

import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

import lombok.Data;

@Data
public class DatosReporteEntity {
    
    @Field(value = "hora", targetType = FieldType.INT32)
    private Integer hora;

    @Field(value = "reportante", targetType = FieldType.STRING)
    private String reportante;

    @Field(value = "numExpediente", targetType = FieldType.INT32)
    private Integer numExpediente;

    @Field(value = "poliza", targetType = FieldType.STRING)
    private String poliza;

    @Field(value = "plan", targetType = FieldType.STRING)
    private String plan;

    @Field(value = "grupo", targetType = FieldType.STRING)
    private String grupo;
    
}
