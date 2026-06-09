package br.com.fiap.entities;

import java.time.LocalDateTime;

public abstract class FonteDados {
    private String idFonte;
    private LocalDateTime timestamp;
    private boolean statusConexao;

    public FonteDados() {
        this.timestamp = LocalDateTime.now();
    }

    public FonteDados(String idFonte, boolean statusConexao) {
        this();
        this.idFonte = idFonte;
        this.statusConexao = statusConexao;
    }

    public abstract String gerarResumoLeitura();

    public String getIdFonte() {
        return idFonte;
    }

    public void setIdFonte(String idFonte) {
        this.idFonte = idFonte;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public boolean isStatusConexao() {
        return statusConexao;
    }

    public void setStatusConexao(boolean statusConexao) {
        this.statusConexao = statusConexao;
    }

    @Override
    public String toString() {
        return "ID Fonte: " + idFonte +
                " | Timestamp: " + timestamp +
                " | Online: " + (statusConexao ? "Sim" : "Não");
    }
}