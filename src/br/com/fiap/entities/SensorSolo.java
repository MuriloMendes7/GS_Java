package br.com.fiap.entities;

public class SensorSolo extends FonteDados {
    private double umidadeSolo;
    private double temperaturaSolo;
    private int bateriaSensor;

    public SensorSolo() {
        super();
    }

    public SensorSolo(String idFonte, boolean statusConexao, double umidadeSolo, double temperaturaSolo, int bateriaSensor) {
        super(idFonte, statusConexao);
        this.umidadeSolo = umidadeSolo;
        this.temperaturaSolo = temperaturaSolo;
        this.bateriaSensor = bateriaSensor;
    }

    @Override
    public String gerarResumoLeitura() {
        return "Sensor Terra [" + getIdFonte() + "] -> Umidade: " + umidadeSolo + "% | Temp: " + temperaturaSolo + "°C";
    }

    public double getUmidadeSolo() {
        return umidadeSolo;
    }

    public void setUmidadeSolo(double umidadeSolo) {
        this.umidadeSolo = umidadeSolo;
    }

    public double getTemperaturaSolo() {
        return temperaturaSolo;
    }

    public void setTemperaturaSolo(double temperaturaSolo) {
        this.temperaturaSolo = temperaturaSolo;
    }

    public int getBateriaSensor() {
        return bateriaSensor;
    }

    public void setBateriaSensor(int bateriaSensor) {
        this.bateriaSensor = bateriaSensor;
    }

    @Override
    public String toString() {
        return super.toString() + " | [SensorSolo] Umidade: " + umidadeSolo + "% , Temp Solo: " + temperaturaSolo + "°C, Bateria: " + bateriaSensor + "%";
    }
}