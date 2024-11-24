package com.matrix.modulo_bicatoras.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

import lombok.Data;

@Data
@Document(collection = "bitacoras")
public class BitacoraEntity {
    
    @Id
    private String _id;

    @Field(value = "numeroSiniestro")
    private Integer numeroSiniestro;

    @Field(value = "idCoordinador")
    private Integer idCoordinador;

    @Field(value = "fecha", targetType = FieldType.DATE_TIME)
    private Date fecha;

    @Field(value = "aprobado", targetType = FieldType.BOOLEAN)
    private Boolean aprobado;

    @Field(value = "justificacion", targetType = FieldType.STRING)
    private String justificacion;

    @Field(value = "datosReporte")
    private DatosReporteEntity datosReporte;

    @Field(value = "datosContacto")
    private DatosContactoEntity datosContacto;

    @Field(value = "datosFallecido")
    private DatosFallecidoEntity datosFallecido;
}
