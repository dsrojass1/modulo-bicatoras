package com.matrix.modulo_bicatoras.controller;

import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.matrix.modulo_bicatoras.dto.BitacoraDTO;
import com.matrix.modulo_bicatoras.dto.CreateBitacoraDTO;
import com.matrix.modulo_bicatoras.exception.EntityNotFoundException;
import com.matrix.modulo_bicatoras.model.BitacoraEntity;
import com.matrix.modulo_bicatoras.service.BitacoraService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/bitacoras")
@Tag(name = "Bitacora Management System", description = "Operations pertaining to bitacoras in Bitacora Management System")
public class BitacoraController {
    
    @Autowired
    private BitacoraService bitacoraService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    @Operation(summary = "View a list of available bitacoras", description = "Returns a list of bitacoras")
    public List<BitacoraDTO> findAll() {
        List<BitacoraEntity> bitacoraEntities = bitacoraService.findAll();
        return modelMapper.map(bitacoraEntities, new TypeToken<List<BitacoraDTO>>() {}.getType());
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    @Operation(summary = "Get a bitacora by id", description = "Returns a bitacora by its id")
    public BitacoraDTO findById(@PathVariable("id") String id) throws EntityNotFoundException {
        BitacoraEntity bitacoraEntity = bitacoraService.findById(id);
        return modelMapper.map(bitacoraEntity, BitacoraDTO.class);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    @Operation(summary = "Add a new bitacora", description = "Creates a new bitacora")
    public BitacoraDTO save(@RequestBody CreateBitacoraDTO createBitacoraDTO) throws EntityNotFoundException {
        BitacoraEntity bitacoraEntity = modelMapper.map(createBitacoraDTO, BitacoraEntity.class);
        bitacoraEntity = bitacoraService.save(bitacoraEntity);
        return modelMapper.map(bitacoraEntity, BitacoraDTO.class);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    @Operation(summary = "Update an existing bitacora", description = "Updates an existing bitacora by its id")
    public BitacoraDTO update(@PathVariable("id") String id, @RequestBody BitacoraDTO bitacoraDTO) throws EntityNotFoundException {
        BitacoraEntity bitacoraEntity = modelMapper.map(bitacoraDTO, BitacoraEntity.class);
        bitacoraEntity = bitacoraService.updateById(id, bitacoraEntity);
        return modelMapper.map(bitacoraEntity, BitacoraDTO.class);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete a bitacora", description = "Deletes a bitacora by its id")
    public void deleteById(@PathVariable("id") String id) throws EntityNotFoundException {
        bitacoraService.deleteById(id);
    }

    @GetMapping(value = "/bitacora/{numeroSiniestro}")
    @ResponseStatus(code = HttpStatus.OK)
    @Operation(summary = "Get a bitacora by numeroSiniestro", description = "Returns a bitacora by its numeroSiniestro")
    public List<BitacoraDTO> findByNumeroSiniestro(@PathVariable("numeroSiniestro") Integer numeroSiniestro) {
        List<BitacoraEntity> bitacoraEntities = bitacoraService.findByNumeroSiniestro(numeroSiniestro);
        return modelMapper.map(bitacoraEntities, new TypeToken<List<BitacoraDTO>>() {}.getType());
    }

    @GetMapping(value = "/coordinador/{idCoordinador}")
    @ResponseStatus(code = HttpStatus.OK)
    @Operation(summary = "Get a bitacora by idCoordinador", description = "Returns a bitacora by its idCoordinador")
    public List<BitacoraDTO> findByIdCoordinador(@PathVariable("idCoordinador") Integer idCoordinador) {
        List<BitacoraEntity> bitacoraEntities = bitacoraService.findByIdCoordinador(idCoordinador);
        return modelMapper.map(bitacoraEntities, new TypeToken<List<BitacoraDTO>>() {}.getType());
    }

    @GetMapping(value = "/bitacora/fecha")
    @ResponseStatus(code = HttpStatus.OK)
    @Operation(summary = "Get bitacoras between dates", description = "Returns bitacoras between start and end date")
    public List<BitacoraDTO> findByFechaBetween(
        @RequestParam("fechaInicio") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaInicio,
        @RequestParam("fechaFin") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaFin) {
        List<BitacoraEntity> bitacoraEntities = bitacoraService.findByFechaBetween(fechaInicio, fechaFin);
        return modelMapper.map(bitacoraEntities, new TypeToken<List<BitacoraDTO>>() {}.getType());
    }

    @GetMapping(value = "/datos-fallecido/fecha")
    @ResponseStatus(code = HttpStatus.OK)
    @Operation(summary = "Get bitacoras by fecha fallecimiento range", description = "Returns bitacoras between start and end death date")
    public List<BitacoraDTO> findByFechaFallecimientoBetween(
        @RequestParam("fechaInicio") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaInicio,
        @RequestParam("fechaFin") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaFin) {
        List<BitacoraEntity> bitacoraEntities = bitacoraService.findByFechaFallecimientoBetween(fechaInicio, fechaFin);
        return modelMapper.map(bitacoraEntities, new TypeToken<List<BitacoraDTO>>() {}.getType());
    }

    @GetMapping(value = "/datos-fallecido/{identificacion}")
    @ResponseStatus(code = HttpStatus.OK)
    @Operation(summary = "Get a bitacora by fallecido ID", description = "Returns a bitacora by its fallecido ID")
    public BitacoraDTO findByDatosFallecidoIdentificacion(@PathVariable("identificacion") Integer identificacion) throws EntityNotFoundException {
        BitacoraEntity bitacoraEntity = bitacoraService.findByDatosFallecidoIdentificacion(identificacion);
        return modelMapper.map(bitacoraEntity, BitacoraDTO.class);
    }

    @GetMapping(value = "/datos-contacto/afiliado-principal/{identificacion}")
    @ResponseStatus(code = HttpStatus.OK)
    @Operation(summary = "Get bitacoras by afiliado principal ID", description = "Returns bitacoras by its afiliado principal ID")
    public List<BitacoraDTO> findByDatosContactoAfiliadoPrincipalIdentificacion(@PathVariable("identificacion") Integer identificacion) {
        List<BitacoraEntity> bitacoraEntities = bitacoraService.findByDatosContactoAfiliadoPrincipalIdentificacion(identificacion);
        return modelMapper.map(bitacoraEntities, new TypeToken<List<BitacoraDTO>>() {}.getType());
    }

    @GetMapping(value = "/datos-reporte/{numExpediente}")
    @ResponseStatus(code = HttpStatus.OK)
    @Operation(summary = "Get a bitacora by numExpediente", description = "Returns a bitacora by its numExpediente")
    public BitacoraDTO findByDatosReporteNumExpediente(@PathVariable("numExpediente") Integer numExpediente) throws EntityNotFoundException {
        BitacoraEntity bitacoraEntity = bitacoraService.findByDatosReporteNumExpediente(numExpediente);
        return modelMapper.map(bitacoraEntity, BitacoraDTO.class);
    }

    
}
