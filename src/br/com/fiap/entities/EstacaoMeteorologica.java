package br.com.fiap.entities;

public class EstacaoMeteorologica extends FonteDados {
    private double velocidadeVento;
    private double indicePluviometrico;
    private double umidadeAr;

    // Construtores reaproveitando a Superclasse
    public EstacaoMeteorologica() {
        super();
    }

    public EstacaoMeteorologica(String idFonte, boolean statusConexao, double velocidadeVento, double indicePluviometrico, double umidadeAr) {
        super(idFonte, statusConexao);
        this.velocidadeVento = velocidadeVento;
        this.indicePluviometrico = indicePluviometrico;
        this.umidadeAr = umidadeAr;
    }

    // Implementação obrigatória do método abstrato
    @Override
    public String gerarResumoLeitura() {
        return "Estação Clima [" + getIdFonte() + "] -> Chuva: " + indicePluviometrico + "mm | Vento: " + velocidadeVento + " km/h | UR do Ar: " + umidadeAr + "%";
    }

    // Getters e Setters
    public double getVelocidadeVento() { return velocidadeVento; }
    public void setVelocidadeVento(double velocidadeVento) { this.velocidadeVento = velocidadeVento; }

    public double getIndicePluviometrico() { return indicePluviometrico; }
    public void setIndicePluviometrico(double indicePluviometrico) { this.indicePluviometrico = indicePluviometrico; }

    public double getUmidadeAr() { return umidadeAr; }
    public void setUmidadeAr(double umidadeAr) { this.umidadeAr = umidadeAr; }

    // ToString estendendo o comportamento do pai
    @Override
    public String toString() {
        return super.toString() + " | [EstacaoMeteorologica] Vento: " + velocidadeVento + "km/h, Pluviometria: " + indicePluviometrico + "mm, Umidade Ar: " + umidadeAr + "%";
    }
}