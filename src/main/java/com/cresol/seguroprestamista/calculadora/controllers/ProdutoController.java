package com.cresol.seguroprestamista.calculadora.controllers;

import com.cresol.seguroprestamista.calculadora.entidades.Produto;
import com.cresol.seguroprestamista.calculadora.servicos.ProdutoServico;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@AllArgsConstructor
@RestController
@RequestMapping(value = "/produto")
public class ProdutoController {
    private final ProdutoServico produtoServico;

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Produto>> listarProdutos(){
        return ResponseEntity.status(HttpStatus.OK).body(produtoServico.buscaProduto());
    }
}
