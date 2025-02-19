package br.com.robsonlmds.screenmatch;

import br.com.robsonlmds.screenmatch.model.DadosEpisodio;
import br.com.robsonlmds.screenmatch.model.Episodio;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

public class ValidacaoDados {

    @Test
    public void testConstrucaoEpisodioComDadosValidos() {
   
        DadosEpisodio dados = new DadosEpisodio("Episodio 1", 1, "8.5", "2024-11-28");

        Episodio episodio = new Episodio(1, dados);
        assertEquals(1, episodio.getTemporada());
        assertEquals("Episodio 1", episodio.getTitulo());
        assertEquals(1, episodio.getNumeroEpisodio());
        assertEquals(8.5, episodio.getAvaliacao());
        assertEquals(LocalDate.of(2024, 11, 28), episodio.getDataLancamento());
    }

    @Test
    public void testConstrucaoEpisodioComAvaliacaoInvalida() {
   
        DadosEpisodio dados = new DadosEpisodio("Episodio 2", 2, "invalid", "2024-11-28");
        Episodio episodio = new Episodio(2, dados);
        assertEquals(0.0, episodio.getAvaliacao());
    }

    @Test
    public void testConstrucaoEpisodioComDataLancamentoInvalida() {
     
        DadosEpisodio dados = new DadosEpisodio("Episodio 3", 3, "9.0", "invalid-date");
        Episodio episodio = new Episodio(3, dados);
        assertNull(episodio.getDataLancamento());
    }
}

