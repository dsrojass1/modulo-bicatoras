package com.matrix.modulo_bicatoras.dto;

import java.util.Date;

import lombok.Data;

@Data
public class DatosFallecidoDTO {
    
    private Integer identificacion;

    private String nombre;

    private String parentescoConAfiliadoPrincipal;

    private Date fechaFallecimiento;

    private String ciudadResidencia;

    private String direccionResidencia;

    private Date fechaNacimiento;

    private String ciudadCuerpo;

    private String lugarCuerpo;

    private Date fechaAfiliacion;

    private Integer edadFallecimiento;

    private Integer edadAfiliacion;

    private String causaFallecimiento;

    private String tipoFallecimiento;

    private Boolean periodosCarencia;

    private Boolean covid;

    private Boolean cd;
}
