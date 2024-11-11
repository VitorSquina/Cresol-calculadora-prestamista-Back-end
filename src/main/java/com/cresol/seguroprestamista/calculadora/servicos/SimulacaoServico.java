package com.cresol.seguroprestamista.calculadora.servicos;

import com.cresol.seguroprestamista.calculadora.entidades.Produto;
import com.cresol.seguroprestamista.calculadora.entidades.Simulacao;
import com.cresol.seguroprestamista.calculadora.excecoes.SimulationException;
import com.cresol.seguroprestamista.calculadora.form.SimulacaoForm;
import com.cresol.seguroprestamista.calculadora.repositorios.ProdutoRepositorio;
import com.cresol.seguroprestamista.calculadora.repositorios.SimulacaoRepositorio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
@AllArgsConstructor
public class SimulacaoServico {
    private final SimulacaoRepositorio simulacaoRepositorio;
    private final ProdutoRepositorio produtoRepositorio;

    public List<Simulacao> buscaSimulacao() {
        return simulacaoRepositorio.findAll();
    }

    public static boolean cpfValido(String cpf) {
        cpf = cpf.replaceAll("[^\\d]", "");

        if (cpf.length() != 11) {
            return false;
        }

        if (cpf.matches("(\\d)\\1{10}")) {
            return false;
        }

        int soma = 0;
        for (int i = 0; i < 9; i++) {
            int numero = Character.getNumericValue(cpf.charAt(i));
            soma += numero * (10 - i);
        }

        int primeiroDigitoVerificador = 11 - (soma % 11);
        if (primeiroDigitoVerificador >= 10) {
            primeiroDigitoVerificador = 0;
        }

        if (primeiroDigitoVerificador != Character.getNumericValue(cpf.charAt(9))) {
            return false;
        }

        soma = 0;
        for (int i = 0; i < 10; i++) {
            int numero = Character.getNumericValue(cpf.charAt(i));
            soma += numero * (11 - i);
        }

        int segundoDigitoVerificador = 11 - (soma % 11);
        if (segundoDigitoVerificador >= 10) {
            segundoDigitoVerificador = 0;
        }
        return segundoDigitoVerificador == Character.getNumericValue(cpf.charAt(10));
    }

    public Simulacao calcular(SimulacaoForm simulacaoDados) throws SimulationException {
        long idade = ChronoUnit.YEARS.between(simulacaoDados.getDataNascimento(), LocalDate.now());
        long numeroMeses = ChronoUnit.MONTHS.between(LocalDate.now(), simulacaoDados.getDataFimContrato());

        List<Produto> listaProduto = produtoRepositorio.buscaProdutoPorIdade(idade);

        if (listaProduto.isEmpty()) {
            throw new SimulationException("Não existe Produto que seja compatível com a idade do usuário idade = " + idade);
        }

        if (numeroMeses > 120 || numeroMeses < 1) {
            throw new SimulationException("O número de meses da Simulação: " + numeroMeses + " é inválido por ser maior que 120 ou menor que 1");
        }

        Produto produtoSelecionado = listaProduto.get(0);

        BigDecimal valorPremio = BigDecimal.valueOf(simulacaoDados.getValorSegurado())
                .multiply(produtoSelecionado.getTaxaJuros())
                .divide(BigDecimal.valueOf(1000), RoundingMode.HALF_EVEN)
                .multiply(BigDecimal.valueOf(numeroMeses));

        if (valorPremio.compareTo(produtoSelecionado.getValorMinimoPremio()) < 0) {
            valorPremio = produtoSelecionado.getValorMinimoPremio();
        }

        if (!cpfValido(simulacaoDados.getCpf())) {
            throw new SimulationException("O número do CPF é inválido: " + simulacaoDados.getCpf());
        }

        Simulacao simulacaoAtual = new Simulacao();
        simulacaoAtual.setDataSimulacao(LocalDate.now());
        simulacaoAtual.setDataNacimento(simulacaoDados.getDataNascimento());
        simulacaoAtual.setNumeroContratoEmprestimo(simulacaoDados.getNumeroContratoDeEmprestimo());
        simulacaoAtual.setProdutoEscolhido(produtoSelecionado);
        simulacaoAtual.setValorTotalPremio(valorPremio);
        simulacaoAtual.setValorSegurado(BigDecimal.valueOf(simulacaoDados.getValorSegurado()));
        simulacaoAtual.setCpf(simulacaoDados.getCpf());
        simulacaoAtual.setNome(simulacaoDados.getNomePessoa());
        simulacaoAtual.setFimContratoEmprestimo(simulacaoDados.getDataFimContrato());

        return simulacaoRepositorio.save(simulacaoAtual);
    }
}
