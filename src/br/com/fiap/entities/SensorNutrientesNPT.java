package br.com.fiap.entities;

public class SensorNutrientesNPT extends FonteDados {
    private double nivelNitrogenio;
    private double nivelFosforo;
    private double nivelPotassio;

    public SensorNutrientesNPT() {
        super();
    }


    public SensorNutrientesNPT(String idFonte, boolean statusConexao, double nivelNitrogenio, double nivelFosforo, double nivelPotassio) {
        super(idFonte, statusConexao);
        this.nivelNitrogenio = nivelNitrogenio;
        this.nivelFosforo = nivelFosforo;
        this.nivelPotassio = nivelPotassio;
    }

    @Override
    public String gerarResumoLeitura() {
        return "Sensor NPK [" + getIdFonte() + "] -> Nível Químico Atual | N: "
                + nivelNitrogenio + " mg/kg | P: " + nivelFosforo + " mg/kg | K: " + nivelPotassio + " mg/kg";
    }

    public double getNivelNitrogenio() {
        return nivelNitrogenio;
    }

    public void setNivelNitrogenio(double nivelNitrogenio) {
        this.nivelNitrogenio = nivelNitrogenio;
    }

    public double getNivelFosforo() {
        return nivelFosforo;
    }

    public void setNivelFosforo(double nivelFosforo) {
        this.nivelFosforo = nivelFosforo;
    }

    public double getNivelPotassio() {
        return nivelPotassio;
    }

    public void setNivelPotassio(double nivelPotassio) {
        this.nivelPotassio = nivelPotassio;
    }

    @Override
    public String toString() {
        return super.toString() + " | [SensorNutrientesNPT] Nitrogénio: " + nivelNitrogenio
                + " mg/kg, Fósforo: " + nivelFosforo + " mg/kg, Potássio: " + nivelPotassio + " mg/kg";
    }
}