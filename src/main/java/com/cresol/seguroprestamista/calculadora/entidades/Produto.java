package com.cresol.seguroprestamista.calculadora.entidades;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "produto")
@Getter
@Setter

public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    @Column(name = "idade_minima")
    private Integer idadeMinima;;
    @Column(name = "idade_maxima")
    private Integer idadeMaxima;
    @Column(name = "taxa_juros")
    private BigDecimal taxaJuros;
    @Column(name = "valor_minimo_premio")
    private BigDecimal valorMinimoPremio;

}
