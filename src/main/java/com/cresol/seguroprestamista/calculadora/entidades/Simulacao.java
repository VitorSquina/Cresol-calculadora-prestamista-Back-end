package com.cresol.seguroprestamista.calculadora.entidades;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.cglib.core.Local;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "simulacao")
@Getter
@Setter
public class Simulacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "nome_pessoa")
    private String nome;
    @Column(name = "cpf")
    private String cpf;
    @Column(name = "valor_segurado")
    private BigDecimal valorSegurado;
    @Column(name = "numero_contrato_emprestimo")
    private String numeroContratoEmprestimo;
    @Column(name = "data_nascimento")
    private LocalDate dataNacimento;
    @Column(name = "fim_contrato_emprestimo")
    private LocalDate fimContratoEmprestimo;
    @Column(name = "data_simulacao")
    private LocalDate dataSimulacao;
    @Column(name = "valor_total_premio")
    private BigDecimal valorTotalPremio;

    @ManyToOne
    @JoinColumn(name = "produto_escolhido", referencedColumnName = "id")

    private Produto produtoEscolhido;




}
