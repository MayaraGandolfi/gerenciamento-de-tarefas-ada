package model;

import java.time.LocalDate;

public class Tarefa {

    private Long id;
    private String descrição;
    private LocalDate dataCriacao;
    private LocalDate dataConclusão;
    private String Status;

    public Tarefa() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescrição() {
        return descrição;
    }

    public void setDescrição(String descrição) {
        this.descrição = descrição;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LocalDate getDataConclusão() {
        return dataConclusão;
    }

    public void setDataConclusão(LocalDate dataConclusão) {
        this.dataConclusão = dataConclusão;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    @Override
    public String toString() {
        return "Tarefa{" +
                "id=" + id +
                ", descrição='" + descrição + '\'' +
                ", dataCriacao=" + dataCriacao +
                ", dataConclusão=" + dataConclusão +
                ", Status='" + Status + '\'' +
                '}';
    }
}
