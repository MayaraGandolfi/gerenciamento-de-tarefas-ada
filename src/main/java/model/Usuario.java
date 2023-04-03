package model;

public class Usuario {
    private String nome;
    private boolean podeRemoverLembrete;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isPodeRemoverLembrete() {
        return podeRemoverLembrete;
    }

    public void setPodeRemoverLembrete(boolean podeRemoverLembrete) {
        this.podeRemoverLembrete = podeRemoverLembrete;
    }
}
