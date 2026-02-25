package com.github.FernandoNakason.ms_produto.service;

import com.github.FernandoNakason.ms_produto.dto.ProdutoDTO;
import com.github.FernandoNakason.ms_produto.entities.Produto;
import com.github.FernandoNakason.ms_produto.repositories.ProdutoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Transactional(readOnly = true)
    public List<ProdutoDTO> findAllProdutos(){
        List<Produto> produtos = produtoRepository.findAll();

        return produtos.stream().map(ProdutoDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public ProdutoDTO findProdutoById(Long id){
        Produto produto = produtoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Recurso não encontrado. ID:" + id)
        );

        return new ProdutoDTO(produto);
    }
}
