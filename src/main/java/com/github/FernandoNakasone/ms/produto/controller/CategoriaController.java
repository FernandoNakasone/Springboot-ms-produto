package com.github.FernandoNakasone.ms.produto.controller;

import com.github.FernandoNakasone.ms.produto.dto.CategoriaRequestDTO;
import com.github.FernandoNakasone.ms.produto.dto.CategoriaResponseDTO;
import com.github.FernandoNakasone.ms.produto.service.CategoriaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    CategoriaService categoriaService;

    @GetMapping
    public ResponseEntity<List<CategoriaResponseDTO>> getAllCategorias(){
        List<CategoriaResponseDTO> categorias = categoriaService.findAllCategorias();

        return ResponseEntity.ok(categorias);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaResponseDTO> getCategoriaById(@PathVariable Long id){
        CategoriaResponseDTO categoriaResponseDTO = categoriaService.findCategoriaById(id);

        return ResponseEntity.ok(categoriaResponseDTO);
    }

    @PostMapping
    public ResponseEntity<CategoriaResponseDTO> createCategoria(@Valid @RequestBody CategoriaRequestDTO inputDTO){
        CategoriaResponseDTO categoriaDTO = categoriaService.saveCategoria(inputDTO);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}").buildAndExpand(categoriaDTO.getId()).toUri();

        return ResponseEntity.created(uri).body(categoriaDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaResponseDTO> updateCategoria(@PathVariable Long id, @RequestBody @Valid CategoriaRequestDTO inputDTO){
        CategoriaResponseDTO categoriaDTO = categoriaService.updateCategoria(id, inputDTO);
        return ResponseEntity.ok(categoriaDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategoria(@PathVariable Long id){
        categoriaService.deleteCategoriaById(id);
        return ResponseEntity.noContent().build();
    }

}
