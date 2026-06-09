package br.com.fiap.entities;

public class SensorSolo extends FonteDados {
    private double umidadeSolo;
    private double temperaturaSolo;
    private int bateriaSensor;

    // Construtores
    public SensorSolo() {
        super();
    }

    public SensorSolo(String idFonte, boolean statusConexao, double umidadeSolo, double temperaturaSolo, int bateriaSensor) {
        super(idFonte, statusConexao);
        this.umidadeSolo = umidadeSolo;
        this.temperaturaSolo = temperaturaSolo;
        this.bateriaSensor = bateriaSensor;
    }

    // Implementação do Método Abstrato da Superclasse
    @Override
    public String gerarResumoLeitura() {
        return "Sensor Terra [" + getIdFonte() + "] -> Umidade: " + umidadeSolo + "% | Temp: " + temperaturaSolo + "°C";
    }

    // Getters e Setters
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

    // ToString usando super.toString() para reaproveitar os dados da superclasse
    @Override
    public String toString() {
        return super.toString() + " | [SensorSolo] Umidade: " + umidadeSolo + "% , Temp Solo: " + temperaturaSolo + "°C, Bateria: " + bateriaSensor + "%";
    }
}