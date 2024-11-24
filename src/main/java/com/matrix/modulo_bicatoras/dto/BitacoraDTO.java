package com.matrix.modulo_bicatoras.dto;

import java.util.Date;

import lombok.Data;

@Data
public class BitacoraDTO {
    
    // Id generado automáticamente por Mongodb
    private String _id;

    private Integer numeroSiniestro;

    private Integer idCoordinador;

    private Date fecha;

    private Boolean aprobado;

    private String justificacion;

    private DatosReporteDTO datosReporte;

    private DatosContactoDTO datosContacto;

    private DatosFallecidoDTO datosFallecido;
}
