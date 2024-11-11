package com.cresol.seguroprestamista.calculadora.servicos;


import com.cresol.seguroprestamista.calculadora.entidades.Produto;
import com.cresol.seguroprestamista.calculadora.repositorios.ProdutoRepositorio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProdutoServico {
    private final ProdutoRepositorio produtoRepositorio;


    public List<Produto> buscaProduto(){
        return produtoRepositorio.findAll();
    }
}
