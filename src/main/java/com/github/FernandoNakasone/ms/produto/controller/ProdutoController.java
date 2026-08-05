package com.github.FernandoNakasone.ms.produto.controller;

import com.github.FernandoNakasone.ms.produto.dto.ProdutoRequestDTO;
import com.github.FernandoNakasone.ms.produto.dto.ProdutoResponseDTO;
import com.github.FernandoNakasone.ms.produto.service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/produtos")

public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

//    @Profile("teste")
//    @GetMapping("/--demo/500")
//    public String force500(){
//        throw new RuntimeException("Erro 500 forçado para demonstraçã");
//    }

    @GetMapping
    public ResponseEntity<List<ProdutoResponseDTO>> getAllProdutos(){
        List<ProdutoResponseDTO> list = produtoService.findAllProdutos();

        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoResponseDTO> getProdutoById(@PathVariable Long id){
        ProdutoResponseDTO produtoResponseDTO = produtoService.findProdutoById(id);

        return ResponseEntity.ok(produtoResponseDTO);
    }

    @PostMapping
    public ResponseEntity<ProdutoResponseDTO> createProduto(@RequestBody @Valid ProdutoRequestDTO inputDTO){
        ProdutoResponseDTO produtoResponseDTO = produtoService.saveProduto(inputDTO);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("{/id}")
                .buildAndExpand(produtoResponseDTO.getId())
                .toUri();

        return ResponseEntity.created(uri).body(produtoResponseDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoResponseDTO> updateProduto(@PathVariable Long id, @RequestBody @Valid ProdutoRequestDTO inputDTO){
        ProdutoResponseDTO produtoResponseDTO = produtoService.updateProduto(id, inputDTO);

        return ResponseEntity.ok(produtoResponseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduto(@PathVariable long id){
        produtoService.deleteProdutoById(id);

        return ResponseEntity.noContent().build();
    }


}
