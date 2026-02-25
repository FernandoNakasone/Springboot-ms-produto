package com.github.FernandoNakason.ms_produto.dto;

import com.github.FernandoNakason.ms_produto.entities.Produto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ProdutoDTO {
    private Long id;
    private String nome;
    private String descricao;
    private Double valor;

    public ProdutoDTO(Produto produto) {
        id = produto.getId();
        descricao = produto.getDescricao();
        nome = produto.getNome();
        valor = produto.getValor();
    }
}
