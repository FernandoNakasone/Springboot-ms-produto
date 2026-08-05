package com.github.FernandoNakasone.ms.produto.dto;

import com.github.FernandoNakasone.ms.produto.entities.Produto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ProdutoResponseDTO {
    private Long id;

    @NotBlank(message = "Campo nome é requerido")
    @Size(min = 3, max = 100, message = "O nome deve ter entre 3 e 100 caracteres")
    private String nome;

    @NotBlank(message = "Campo descrição é requerido")
    @Size(min = 10, message = "A descrição deve ter no mínimo 10 caracteres")
    private String descricao;

    @NotNull(message = "O campo valor é requerido")
    @Positive(message = "O valor deve ser um número positivo (maior que zero '0')")
    private Double valor;

    @NotNull(message = "Campo categoria é requerido")
    private CategoriaResponseDTO categoria;

    public ProdutoResponseDTO(Produto produto) {
        id = produto.getId();
        descricao = produto.getDescricao();
        nome = produto.getNome();
        valor = produto.getValor();
        categoria = new CategoriaResponseDTO(produto.getCategoria());
    }
}
