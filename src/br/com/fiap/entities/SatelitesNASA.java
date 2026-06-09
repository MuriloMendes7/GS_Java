package br.com.fiap.entities;

public class SatelitesNASA extends FonteDados {
    private double indiceVegetacao;
    private double anomaliaTemperatura;
    private String alertaClimatico;

    public SatelitesNASA() {
        super();
    }

    public SatelitesNASA(String idFonte, boolean statusConexao, double indiceVegetacao, double anomaliaTemperatura, String alertaClimatico) {
        super(idFonte, statusConexao);
        this.indiceVegetacao = indiceVegetacao;
        this.anomaliaTemperatura = anomaliaTemperatura;
        this.alertaClimatico = alertaClimatico;
    }

    @Override
    public String gerarResumoLeitura() {
        return "Satélite NASA [" + getIdFonte() + "] -> NDVI (Vegetação): " + indiceVegetacao + " | Alerta: " + alertaClimatico;
    }

    public double getIndiceVegetacao() {
        return indiceVegetacao;
    }

    public void setIndiceVegetacao(double indiceVegetacao) {
        this.indiceVegetacao = indiceVegetacao;
    }

    public double getAnomaliaTemperatura() {
        return anomaliaTemperatura;
    }

    public void setAnomaliaTemperatura(double anomaliaTemperatura) {
        this.anomaliaTemperatura = anomaliaTemperatura;
    }

    public String getAlertaClimatico() {
        return alertaClimatico;
    }

    public void setAlertaClimatico(String alertaClimatico) {
        this.alertaClimatico = alertaClimatico;
    }

    @Override
    public String toString() {
        return super.toString() + " | [SatellitesNASA] NDVI: " + indiceVegetacao + ", Anomalia Térmica: " + anomaliaTemperatura + ", Alerta: " + alertaClimatico;
    }
}