package com.cresol.seguroprestamista.calculadora.controllers;


import com.cresol.seguroprestamista.calculadora.entidades.Simulacao;
import com.cresol.seguroprestamista.calculadora.form.SimulacaoForm;
import com.cresol.seguroprestamista.calculadora.servicos.SimulacaoServico;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/simulacao")
public class SimulacaoControler {
    private final SimulacaoServico simulacaoServico;

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<List<Simulacao>> listarSimulacoes(){
            return ResponseEntity.status(HttpStatus.OK).body(simulacaoServico.buscaSimulacao());
    }

    @PostMapping(value = "/executar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Simulacao> simulacao(@RequestBody SimulacaoForm simulacaoDados) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(simulacaoServico.calcular(simulacaoDados));
    }
}
