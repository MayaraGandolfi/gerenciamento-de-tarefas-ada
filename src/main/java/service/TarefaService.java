package service;

import model.Tarefa;

import java.time.Duration;
import java.time.LocalDate;

public class TarefaService {

    public double calcularTempo(Tarefa tarefa, LocalDate hoje) throws IllegalArgumentException {
        if (tarefa.isConcluida()) {
            throw new IllegalArgumentException("A tarefa já está concluida!");
        }
        return Duration.between(tarefa.getDataCriacao().atStartOfDay(), hoje.atStartOfDay()).toDays();
    }

    public void concluirTarefa(Tarefa tarefa) {
        tarefa.setConcluida(true);
     }

     public void alterarLembrete(Tarefa tarefa,boolean statusLembrete){
           tarefa.setPossuiLembrete(statusLembrete);
     }


}
