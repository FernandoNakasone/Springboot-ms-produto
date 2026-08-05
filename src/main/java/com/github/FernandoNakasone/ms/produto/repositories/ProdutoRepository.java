package com.github.FernandoNakasone.ms.produto.repositories;

import com.github.FernandoNakasone.ms.produto.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
