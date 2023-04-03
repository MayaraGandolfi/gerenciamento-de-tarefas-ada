package service;

import model.Prioridade;
import model.Tarefa;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LembreteServiceTest {

    LembreteService lembreteService;

    @BeforeEach
    public void configurar() {
        lembreteService = new LembreteService();
    }

    @Test
    public void deveAdicionarLembretesCorretamente() {
        //Given
        Tarefa tarefa1 = new Tarefa("Titulo 1", Prioridade.ALTA);

        //When
        lembreteService.adicionarLembrete(tarefa1);

        //Then
        List<Tarefa> lembretes = lembreteService.listarTodosLembretes();
        Assertions.assertTrue(lembretes.contains(tarefa1));
    }

    @Test
    public void deveRetornarQuantidadeDeLembretesExistentes() {
        //Given
        Tarefa tarefa1 = new Tarefa("Titulo 1", Prioridade.ALTA);
        Tarefa tarefa2 = new Tarefa("Titulo 2", Prioridade.MEDIA);
        Tarefa tarefa3 = new Tarefa("Titulo 3", Prioridade.BAIXA);

        lembreteService.adicionarLembrete(tarefa1);
        lembreteService.adicionarLembrete(tarefa2);
        lembreteService.adicionarLembrete(tarefa3);

        //When
        int quantidade = lembreteService.quantidadeDeLembretes();

        //Then
        Assertions.assertEquals(3, quantidade);
    }

    @Test
    public void deveRemoverLembrete() {
        //Given
        Tarefa tarefa = new Tarefa("Titulo 1", Prioridade.ALTA);

        //When
        lembreteService.adicionarLembrete(tarefa);
        lembreteService.removerLembrete(tarefa);

        //Then
        Assertions.assertTrue(lembreteService.listarTodosLembretes().size() == 0);
    }

}
