package com.matrix.modulo_bicatoras.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.matrix.modulo_bicatoras.model.BitacoraEntity;

public interface BitacoraRepository extends MongoRepository<BitacoraEntity, String> {
    
    List<BitacoraEntity> findAllByNumeroSiniestro(Integer numeroSiniestro);

    List<BitacoraEntity> findAllByIdCoordinador(Integer idCoordinador);

    List<BitacoraEntity> findAllByFechaBetween(Date fechaInicio, Date fechaFin);

    List<BitacoraEntity> findAllByDatosFallecidoFechaFallecimientoBetween(Date fechaInicio, Date fechaFin);

    Optional<BitacoraEntity> findByDatosFallecidoIdentificacion(Integer identificacion);

    List<BitacoraEntity> findAllByDatosContactoAfiliadoPrincipalIdentificacion(Integer identificacion);

    Optional<BitacoraEntity> findByDatosReporteNumExpediente(Integer numExpediente);
}
