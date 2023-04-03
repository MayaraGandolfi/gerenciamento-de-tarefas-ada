package service;

import model.Tarefa;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LembreteService {
    private final List<Tarefa> lembretes = new ArrayList<>();

    public void adicionarLembrete(Tarefa tarefa){
        lembretes.add(tarefa);
    }

    public void removerLembrete(Tarefa tarefa){
        lembretes.remove(tarefa);
    }

    public List<Tarefa> listarTodosLembretes(){
        return lembretes;
    }

    public int quantidadeDeLembretes(){
        return lembretes.size();
    }
}
