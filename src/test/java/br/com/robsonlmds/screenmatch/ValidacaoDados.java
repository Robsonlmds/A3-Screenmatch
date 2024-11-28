package br.com.robsonlmds.screenmatch;

import br.com.robsonlmds.screenmatch.model.DadosEpisodio;
import br.com.robsonlmds.screenmatch.model.Episodio;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

public class ValidacaoDados {

    @Test
    public void testConstrucaoEpisodioComDadosValidos() {
        // Dados de entrada
        DadosEpisodio dados = new DadosEpisodio("Episodio 1", 1, "8.5", "2024-11-28");

        // Criação do episódio com temporada 1
        Episodio episodio = new Episodio(1, dados);

        // Verificando se os campos estão sendo atribuídos corretamente
        assertEquals(1, episodio.getTemporada());
        assertEquals("Episodio 1", episodio.getTitulo());
        assertEquals(1, episodio.getNumeroEpisodio());
        assertEquals(8.5, episodio.getAvaliacao());
        assertEquals(LocalDate.of(2024, 11, 28), episodio.getDataLancamento());
    }

    @Test
    public void testConstrucaoEpisodioComAvaliacaoInvalida() {
        // Dados de entrada com avaliação inválida
        DadosEpisodio dados = new DadosEpisodio("Episodio 2", 2, "invalid", "2024-11-28");

        // Criação do episódio com temporada 2
        Episodio episodio = new Episodio(2, dados);

        // Verificando se a avaliação foi definida como 0.0 (pois a string não é um número válido)
        assertEquals(0.0, episodio.getAvaliacao());
    }

    @Test
    public void testConstrucaoEpisodioComDataLancamentoInvalida() {
        // Dados de entrada com data inválida
        DadosEpisodio dados = new DadosEpisodio("Episodio 3", 3, "9.0", "invalid-date");

        // Criação do episódio com temporada 3
        Episodio episodio = new Episodio(3, dados);

        // Verificando se a data de lançamento foi definida como null (data inválida)
        assertNull(episodio.getDataLancamento());
    }
}

