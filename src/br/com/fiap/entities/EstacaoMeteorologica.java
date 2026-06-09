package br.com.fiap.entities;

public class EstacaoMeteorologica extends FonteDados {
    private double velocidadeVento;
    private double indicePluviometrico;
    private double umidadeAr;

    public EstacaoMeteorologica() {
        super();
    }

    public EstacaoMeteorologica(String idFonte, boolean statusConexao, double velocidadeVento, double indicePluviometrico, double umidadeAr) {
        super(idFonte, statusConexao);
        this.velocidadeVento = velocidadeVento;
        this.indicePluviometrico = indicePluviometrico;
        this.umidadeAr = umidadeAr;
    }

    @Override
    public String gerarResumoLeitura() {
        return "Estação Clima [" + getIdFonte() + "] -> Chuva: " + indicePluviometrico + "mm | Vento: " + velocidadeVento + " km/h | UR do Ar: " + umidadeAr + "%";
    }

    public double getVelocidadeVento() { return velocidadeVento; }
    public void setVelocidadeVento(double velocidadeVento) { this.velocidadeVento = velocidadeVento; }

    public double getIndicePluviometrico() { return indicePluviometrico; }
    public void setIndicePluviometrico(double indicePluviometrico) { this.indicePluviometrico = indicePluviometrico; }

    public double getUmidadeAr() { return umidadeAr; }
    public void setUmidadeAr(double umidadeAr) { this.umidadeAr = umidadeAr; }

    @Override
    public String toString() {
        return super.toString() + " | [EstacaoMeteorologica] Vento: " + velocidadeVento + "km/h, Pluviometria: " + indicePluviometrico + "mm, Umidade Ar: " + umidadeAr + "%";
    }
}