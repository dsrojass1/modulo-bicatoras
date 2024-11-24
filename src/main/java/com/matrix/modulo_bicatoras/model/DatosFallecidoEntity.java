package com.matrix.modulo_bicatoras.model;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

import lombok.Data;

@Data
public class DatosFallecidoEntity {
    
    @Field(value = "identificacion", targetType = FieldType.INT32)
    private Integer identificacion;

    @Field(value = "nombre", targetType = FieldType.STRING)
    private String nombre;

    @Field(value = "parentescoConAfiliadoPrincipal", targetType = FieldType.STRING)
    private String parentescoConAfiliadoPrincipal;

    @Field(value = "fechaFallecimiento", targetType = FieldType.DATE_TIME)
    private Date fechaFallecimiento;

    @Field(value = "ciudadResidencia", targetType = FieldType.STRING)
    private String ciudadResidencia;

    @Field(value = "direccionResidencia", targetType = FieldType.STRING)
    private String direccionResidencia;

    @Field(value = "fechaNacimiento", targetType = FieldType.DATE_TIME)
    private Date fechaNacimiento;

    @Field(value = "ciudadCuerpo", targetType = FieldType.STRING)
    private String ciudadCuerpo;

    @Field(value = "lugarCuerpo", targetType = FieldType.STRING)
    private String lugarCuerpo;

    @Field(value = "fechaAfiliacion", targetType = FieldType.DATE_TIME)
    private Date fechaAfiliacion;

    @Field(value = "edadFallecimiento", targetType = FieldType.INT32)
    private Integer edadFallecimiento;

    @Field(value = "edadAfiliacion", targetType = FieldType.INT32)
    private Integer edadAfiliacion;

    @Field(value = "causaFallecimiento", targetType = FieldType.STRING)
    private String causaFallecimiento;

    @Field(value = "tipoFallecimiento", targetType = FieldType.STRING)
    private String tipoFallecimiento;

    @Field(value = "periodosCarencia", targetType = FieldType.BOOLEAN)
    private Boolean periodosCarencia;

    @Field(value = "covid", targetType = FieldType.BOOLEAN)
    private Boolean covid;

    @Field(value = "cd", targetType = FieldType.BOOLEAN)
    private Boolean cd;
    
}
