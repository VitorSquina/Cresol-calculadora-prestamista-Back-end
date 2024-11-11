package com.cresol.seguroprestamista.calculadora.repositorios;

import com.cresol.seguroprestamista.calculadora.entidades.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepositorio extends JpaRepository<Produto, Integer> {
    @Query(value = """
            select * from produto
            where :idade >= idade_minima and :idade <= idade_maxima
            """, nativeQuery = true)
    public List<Produto> buscaProdutoPorIdade(long idade);


}
