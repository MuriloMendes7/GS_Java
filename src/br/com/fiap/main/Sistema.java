package br.com.fiap.main;

import br.com.fiap.entities.AnaliseAgro;
import br.com.fiap.entities.EstacaoMeteorologica;
import br.com.fiap.entities.SatelitesNASA;
import br.com.fiap.entities.SensorSolo;
import br.com.fiap.entities.SensorNutrientesNPT;

public class Sistema {
    public static void main(String[] args) {
        SensorSolo sensorChao = new SensorSolo("SS-FAZENDA-01", true, 15.5, 28.4, 85);

        SatelitesNASA sateliteEspaco = new SatelitesNASA("SAT-LANDSAT-8", true, 0.32, 1.2, "Sem alertas climáticos extremos");

        SensorNutrientesNPT sensorQuimico = new SensorNutrientesNPT("SN-FAZENDA-01", true, 18.5, 45.2, 60.0);

        EstacaoMeteorologica estacaoClima = new EstacaoMeteorologica("EM-FAZENDA-01", true, 12.4, 0.0, 65.0);

        AnaliseAgro centralIA = new AnaliseAgro(sensorChao, sateliteEspaco, sensorQuimico, estacaoClima);

        System.out.println(centralIA);

        System.out.println("\n--- SIMULAÇÃO DE CENÁRIO DE FALHA CRÍTICA MULTIPLA ---\n");

        sensorChao.setBateriaSensor(5);
        estacaoClima.setStatusConexao(false);

        System.out.println(centralIA);
    }
}