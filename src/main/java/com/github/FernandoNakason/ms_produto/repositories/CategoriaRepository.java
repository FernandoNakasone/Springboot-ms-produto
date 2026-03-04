package com.github.FernandoNakason.ms_produto.repositories;

import com.github.FernandoNakason.ms_produto.entities.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
