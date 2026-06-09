package br.com.fiap.main;

import br.com.fiap.entities.AnaliseAgro;
import br.com.fiap.entities.SatelitesNASA;
import br.com.fiap.entities.SensorSolo;

public class Sistema{
    public static void main(String[] args) {
        // 1. Simulando a chegada dos dados do chão (IoT)
        SensorSolo sensorChao = new SensorSolo("SS-FAZENDA-01", true, 15.5, 28.4, 85);

        // 2. Simulando a chegada dos dados do espaço (NASA API)
        SatelitesNASA sateliteEspaco = new SatelitesNASA("SAT-LANDSAT-8", true, 0.32, 1.2, "Sem alertas climáticos extremos");

        // 3. Enviando as referências para o módulo de Inteligência unificar
        AnaliseAgro centralIA = new AnaliseAgro(sensorChao, sateliteEspaco);

        // 4. Exibindo o dashboard mastigado via toString
        System.out.println(centralIA);
    }
}