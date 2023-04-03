package service;

import model.Tarefa;

import java.util.ArrayList;
import java.util.List;

public class LembreteService {
    private final List<Tarefa> lembretes = new ArrayList<>();

    private TarefaService tarefaService = new TarefaService();

    public void adicionarLembrete(Tarefa tarefa){
        lembretes.add(tarefa);
        tarefaService.alterarLembrete(tarefa,true);
    }

    public void removerLembrete(Tarefa tarefa) throws Exception{
        if (tarefa.getUsuario().isPodeRemoverLembrete()) {
            lembretes.remove(tarefa);
            tarefaService.alterarLembrete(tarefa, false);
        } else {
            throw new Exception("Usuário não tem permissão para remover lembrete!");
        }
    }

    public List<Tarefa> listarTodosLembretes(){
        return lembretes;
    }

    public int quantidadeDeLembretes(){
        return lembretes.size();
    }
}
