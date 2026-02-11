package com.github.FernandoNakason.ms_produto.controller;

import com.github.FernandoNakason.ms_produto.dto.ProdutoInputDTO;
import com.github.FernandoNakason.ms_produto.dto.ProdutoResponseDTO;
import com.github.FernandoNakason.ms_produto.entities.Produto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/produtos")

public class ProdutoController {

    @GetMapping
    public ResponseEntity<List<ProdutoResponseDTO>> getProduto(){

        List<ProdutoResponseDTO> dto = ProdutoResponseDTO.createMock();

        return ResponseEntity.ok(dto);
    }

    /* List <Produto> produtos = new ArrayList<>();
        produtos.add(new Produto(1L,"Smart tv", "Smart TV LG LED 50 polegadas",2285.0));
        produtos.add(new Produto(2L,"Mouse Microsoft", "Mouse sem fio",250.0));
        produtos.add(new Produto(3L,"Teclado Microsoft", "Teclado sem fio",278.95));
        */

    @PostMapping
    public ResponseEntity<ProdutoResponseDTO> createProduto(@RequestBody ProdutoInputDTO inputDTO){
       ProdutoResponseDTO dto = new ProdutoResponseDTO(1L,inputDTO.getNome(), inputDTO.getDescricao(),
               inputDTO.getValor());
      return ResponseEntity.created(null).body(dto);
    }
}
