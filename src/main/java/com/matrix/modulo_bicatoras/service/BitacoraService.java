package com.matrix.modulo_bicatoras.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.matrix.modulo_bicatoras.exception.EntityNotFoundException;
import com.matrix.modulo_bicatoras.model.BitacoraEntity;
import com.matrix.modulo_bicatoras.model.CoordinadorEntity;
import com.matrix.modulo_bicatoras.repository.BitacoraRepository;
import com.matrix.modulo_bicatoras.repository.CoordinadorRepository;

@Service
public class BitacoraService {
    
    @Autowired
    private BitacoraRepository bitacoraRepository;

    @Autowired
    private CoordinadorRepository coordinadorRepository;

    @Transactional
    public List<BitacoraEntity> findAll() {
        return bitacoraRepository.findAll();
    }

    @Transactional
    public BitacoraEntity save(BitacoraEntity bitacoraEntity) throws EntityNotFoundException {
        
        // Validar que el coordinador exista
        Integer idCoordinador = bitacoraEntity.getIdCoordinador();
        Optional<CoordinadorEntity> coordinador = coordinadorRepository.findById(idCoordinador);
        if (coordinador.isEmpty()){
            throw new EntityNotFoundException("Ningun coordinador encontrado con el id: " + idCoordinador);
        }

        return bitacoraRepository.save(bitacoraEntity);
    }

    @Transactional
    public BitacoraEntity findById(String id) throws EntityNotFoundException {
        Optional<BitacoraEntity> bitacoraEntity = bitacoraRepository.findById(id);
        if (bitacoraEntity.isEmpty()){
            throw new EntityNotFoundException("Ningun registro encontrado con el id: " + id);
        }
        return bitacoraEntity.get();
    }

    @Transactional
    public BitacoraEntity updateById(String id, BitacoraEntity bitacoraEntity) throws EntityNotFoundException {
        Optional<BitacoraEntity> bitacora = bitacoraRepository.findById(id);
        if (bitacora.isEmpty()){
            throw new EntityNotFoundException("Ningun registro encontrado con el id: " + id);
        }
        bitacoraEntity.set_id(id);

        return bitacoraRepository.save(bitacoraEntity);
    }

    @Transactional
    public void deleteById(String id) throws EntityNotFoundException {
        Optional<BitacoraEntity> bitacora = bitacoraRepository.findById(id);
        if (bitacora.isEmpty()){
            throw new EntityNotFoundException("Ningun registro encontrado con el id: " + id);
        }
        bitacoraRepository.deleteById(id);
    }

    @Transactional
    public List<BitacoraEntity> findByNumeroSiniestro (Integer numeroSiniestro) {
        return bitacoraRepository.findAllByNumeroSiniestro(numeroSiniestro);
    }

    @Transactional
    public List<BitacoraEntity> findByIdCoordinador (Integer idCoordinador) {
        return bitacoraRepository.findAllByIdCoordinador(idCoordinador);
    }

    @Transactional
    public List<BitacoraEntity> findByFechaBetween(Date fechaInicio, Date fechaFin) {
        return bitacoraRepository.findAllByFechaBetween(fechaInicio, fechaFin);
    }
    
    @Transactional
    public List<BitacoraEntity> findByFechaFallecimientoBetween(Date fechaInicio, Date fechaFin) {
        return bitacoraRepository.findAllByDatosFallecidoFechaFallecimientoBetween(fechaInicio, fechaFin);
    }

    @Transactional
    public BitacoraEntity findByDatosFallecidoIdentificacion(Integer identificacion) throws EntityNotFoundException {
        Optional<BitacoraEntity> bitacoraEntity = bitacoraRepository.findByDatosFallecidoIdentificacion(identificacion);
        if (bitacoraEntity.isEmpty()){
            throw new EntityNotFoundException("Ningun registro encontrado con la identificacion del fallecido: " + identificacion);
        }
        return bitacoraEntity.get();
    }

    @Transactional
    public List<BitacoraEntity> findByDatosContactoAfiliadoPrincipalIdentificacion(Integer identificacion) {
        return bitacoraRepository.findAllByDatosContactoAfiliadoPrincipalIdentificacion(identificacion);
    }

    @Transactional
    public BitacoraEntity findByDatosReporteNumExpediente(Integer numExpediente) throws EntityNotFoundException {
        Optional<BitacoraEntity> bitacoraEntity = bitacoraRepository.findByDatosReporteNumExpediente(numExpediente);
        if (bitacoraEntity.isEmpty()){
            throw new EntityNotFoundException("Ningun registro encontrado con el numero de expediente: " + numExpediente);
        }
        return bitacoraEntity.get();
    }
}
