package model;

import java.time.LocalDate;

public class Tarefa {
    private String titulo;
    private String descricao;
    private LocalDate dataCriacao;
    private LocalDate dataConclusao;
    private boolean possuiLembrete;
    private Prioridade prioridade;
    private boolean concluida;

    private Usuario usuario;

    public Tarefa(String titulo, Prioridade prioridade, Usuario usuario) {
        this.titulo = titulo;
        this.prioridade = prioridade;
        this.usuario = usuario;
    }

    public Tarefa(String titulo, Prioridade prioridade) {
        this.dataCriacao = LocalDate.now();
        this.titulo = titulo;
        this.prioridade = prioridade;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LocalDate getDataConclusao() {
        return dataConclusao;
    }

    public void setDataConclusao(LocalDate dataConclusao) {
        this.dataConclusao = dataConclusao;
    }

    public boolean isPossuiLembrete() {
        return possuiLembrete;
    }

    public void setPossuiLembrete(boolean possuiLembrete) {
        this.possuiLembrete = possuiLembrete;
    }

    public Prioridade getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Prioridade prioridade) {
        this.prioridade = prioridade;
    }

    public boolean isConcluida() {
        return concluida;
    }

    public void setConcluida(boolean concluida) {
        this.concluida = concluida;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
