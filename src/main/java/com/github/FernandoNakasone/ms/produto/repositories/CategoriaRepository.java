package com.github.FernandoNakasone.ms.produto.repositories;

import com.github.FernandoNakasone.ms.produto.entities.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
