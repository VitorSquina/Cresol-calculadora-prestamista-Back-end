package com.cresol.seguroprestamista.calculadora.repositorios;

import com.cresol.seguroprestamista.calculadora.entidades.Simulacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SimulacaoRepositorio extends JpaRepository<Simulacao, Integer> {
}
