package service;

import model.Prioridade;
import model.Tarefa;
import model.Usuario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LembreteServiceTest {

    static Usuario usuario;
    LembreteService lembreteService;

    @BeforeAll
    public static void incio() {
        usuario = mock(Usuario.class);
    }

    @BeforeEach
    public void configurar() {
        lembreteService = new LembreteService();
    }

    @Test
    public void deveAdicionarLembreteCorretamente() {
        //Given
        Tarefa tarefa1 = new Tarefa("Titulo 1", Prioridade.ALTA);

        //When
        lembreteService.adicionarLembrete(tarefa1);

        //Then
        List<Tarefa> lembretes = lembreteService.listarTodosLembretes();
        Assertions.assertTrue(lembretes.contains(tarefa1));
    }

    @Test
    public void deveRemoverLembrete() throws Exception{
        //Given
        Tarefa tarefa = new Tarefa("Titulo 1", Prioridade.ALTA,usuario);
        Mockito.when(usuario.isPodeRemoverLembrete()).thenReturn(true);

        //When
        lembreteService.adicionarLembrete(tarefa);
        lembreteService.removerLembrete(tarefa);

        //Then
        Assertions.assertTrue(lembreteService.listarTodosLembretes().size() == 0);
    }

    @Test
    void deveRetornarExceptionSeUsuarioNaoTiverPermissaoParaRemoverLembrete() throws Exception {
        //Given
        Tarefa tarefa = new Tarefa("Titulo 1", Prioridade.ALTA,usuario);
        Mockito.when(usuario.isPodeRemoverLembrete()).thenReturn(false);

        //When
        Exception thrownRemoverLembrete = Assertions.assertThrows(
                Exception.class, () -> lembreteService.removerLembrete(tarefa));

        String mensagemEsperada = "Usuário não tem permissão para remover lembrete!";

        //Then
        Assertions.assertEquals(mensagemEsperada, thrownRemoverLembrete.getMessage());
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

}
