package com.matrix.modulo_bicatoras.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.matrix.modulo_bicatoras.dto.CoordinadorDTO;
import com.matrix.modulo_bicatoras.exception.EntityNotFoundException;
import com.matrix.modulo_bicatoras.model.CoordinadorEntity;
import com.matrix.modulo_bicatoras.service.CoordinadorService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/coordinadores")
@Tag(name = "Coordinador Management System", description = "Operations pertaining to coordinadores in Coordinador Management System")
public class CoordinadorController {

    @Autowired
    private CoordinadorService coordinadorService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    @Operation(summary = "View a list of available coordinadores", description = "Returns a list of coordinadores")
    public List<CoordinadorDTO> findAll() {
        List<CoordinadorEntity> coordinadorEntities = coordinadorService.findAll();
        return modelMapper.map(coordinadorEntities, new TypeToken<List<CoordinadorDTO>>() {}.getType());
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    @Operation(summary = "Get a coordinador by Id", description = "Returns a coordinador by its id")
    public CoordinadorDTO findById(@PathVariable("id") Integer id) throws EntityNotFoundException {
        CoordinadorEntity coordinadorEntity = coordinadorService.findById(id);
        return modelMapper.map(coordinadorEntity, CoordinadorDTO.class);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    @Operation(summary = "Add a new coordinador", description = "Creates a new coordinador")
    public CoordinadorDTO save(@RequestBody CoordinadorDTO coordinadorDTO) {
        CoordinadorEntity coordinadorEntity = modelMapper.map(coordinadorDTO, CoordinadorEntity.class);
        coordinadorEntity = coordinadorService.save(coordinadorEntity);
        return modelMapper.map(coordinadorEntity, CoordinadorDTO.class);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    @Operation(summary = "Update an existing coordinador", description = "Updates an existing coordinador by its id")
    public CoordinadorDTO update(@PathVariable("id") Integer id, @RequestBody CoordinadorDTO coordinadorDTO) throws EntityNotFoundException {
        CoordinadorEntity coordinadorEntity = modelMapper.map(coordinadorDTO, CoordinadorEntity.class);
        coordinadorEntity = coordinadorService.updateById(id, coordinadorEntity);
        return modelMapper.map(coordinadorEntity, CoordinadorDTO.class);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete a coordinador", description = "Deletes a coordinador by its id")
    public void deleteById(@PathVariable("id") Integer id) throws EntityNotFoundException {
        coordinadorService.deleteById(id);
    }
}
