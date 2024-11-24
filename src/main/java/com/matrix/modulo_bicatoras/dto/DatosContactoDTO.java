package com.matrix.modulo_bicatoras.dto;

import lombok.Data;

@Data
public class DatosContactoDTO {
    
    private ContactoDTO afiliadoPrincipal;

    private ContactoDTO personaAutorizada;

    private String direccionAp;

    private String ciudadAp;

    private String emailAp;

    private String celular1Ap;

    private String celular2Ap;

}
