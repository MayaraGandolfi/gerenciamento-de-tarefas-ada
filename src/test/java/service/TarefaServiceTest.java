package service;

import model.Prioridade;
import model.Tarefa;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class TarefaServiceTest {

    TarefaService tarefaService;

    @BeforeEach
    public void configurar() {
        tarefaService = new TarefaService();
    }

    @Test
    public void deveRetornarOTempoEmAbertoCorretamente() {
        //Given
        Tarefa tarefa = new Tarefa("Titulo 1", Prioridade.ALTA);
        tarefa.setDataCriacao(LocalDate.of(2023, 03, 30));

        LocalDate hoje = LocalDate.of(2023, 04, 02);

        //When
        double resultado = tarefaService.calcularTempo(tarefa, hoje);

        //Then
        Assertions.assertEquals((double) 3, resultado);
    }

    @Test
    void deveRetornarExceptionSeCalculoDeTempoEmAbertoDeTarefaConcluida() throws IllegalArgumentException {
        //Given
        Tarefa tarefa = new Tarefa("Titulo 1", Prioridade.ALTA);
        tarefa.setConcluida(true);
        LocalDate hoje = LocalDate.of(2023, 04, 02);

        //When
        IllegalArgumentException thrownTarefaConcluida = Assertions.assertThrows(
                IllegalArgumentException.class, () -> tarefaService.calcularTempo(tarefa, hoje));

        //Then
        Assertions.assertEquals("A tarefa já está concluida!", thrownTarefaConcluida.getMessage());
    }

    @Test
    public void deveConcluirUmaTarefaCorretamente(){
        //Given
        Tarefa tarefa = new Tarefa("Titulo 1", Prioridade.ALTA);

        //When
        tarefaService.concluirTarefa(tarefa);

        //Then
        Assertions.assertTrue(tarefa.isConcluida());
    }

    @Test
    public void deveAlteraroCampoPossuiLembreteCorretamente(){
        //Given
        Tarefa tarefa = new Tarefa("Titulo 1", Prioridade.ALTA);

        //When
        tarefaService.alterarLembrete(tarefa,true);
        tarefaService.alterarLembrete(tarefa,false);

        //Then
        Assertions.assertFalse(tarefa.isPossuiLembrete());
    }



}
