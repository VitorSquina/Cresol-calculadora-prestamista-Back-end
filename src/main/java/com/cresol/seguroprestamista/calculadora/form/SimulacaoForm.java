package com.cresol.seguroprestamista.calculadora.form;

import lombok.Data;

import java.time.LocalDate;

@Data //GETTER E SETTER

public class SimulacaoForm {
    private String nomePessoa;
    private String cpf;
    private Double valorSegurado;
    private String numeroContratoDeEmprestimo;
    private LocalDate dataNascimento;
    private LocalDate dataFimContrato;


}
