package com.example.financas.controller;

import com.example.financas.domain.Categoria;
import com.example.financas.domain.DTO.CategoriaDTO;
import com.example.financas.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value="/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService service;

    @GetMapping
    public ResponseEntity<List<CategoriaDTO>> findAll(){
        List<Categoria> list = service.findAll();
        List<CategoriaDTO> listDto= list.stream().map(x-> new CategoriaDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);

    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<CategoriaDTO> findById(@PathVariable Long id){
        Categoria obj = service.findById(id);
        return ResponseEntity.ok().body(new CategoriaDTO(obj));
    }
    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody CategoriaDTO objDto){
        Categoria obj = service.fromDTO(objDto);
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@RequestBody CategoriaDTO objDto, @PathVariable Long id){
        Categoria obj = service.fromDTO(objDto);
        obj.setId(id);
        obj = service.update(obj);
        return ResponseEntity.noContent().build();

    }
}
