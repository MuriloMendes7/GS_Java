package br.com.fiap.entities;

import java.time.LocalDateTime;

public abstract class FonteDados {
    private String idFonte;
    private LocalDateTime timestamp;
    private boolean statusConexao;

    // Construtor Padrão
    public FonteDados() {
        this.timestamp = LocalDateTime.now(); // Define o momento da criação do dado
    }

    // Construtor Completo
    public FonteDados(String idFonte, boolean statusConexao) {
        this();
        this.idFonte = idFonte;
        this.statusConexao = statusConexao;
    }

    // Método Abstrato: Cada subclasse decidirá como gerar seu resumo de leitura
    public abstract String gerarResumoLeitura();

    // Getters e Setters
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

    // ToString
    @Override
    public String toString() {
        return "ID Fonte: " + idFonte +
                " | Timestamp: " + timestamp +
                " | Online: " + (statusConexao ? "Sim" : "Não");
    }
}