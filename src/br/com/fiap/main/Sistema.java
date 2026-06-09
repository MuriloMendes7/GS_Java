package br.com.fiap.main;

import br.com.fiap.entities.AnaliseAgro;
import br.com.fiap.entities.EstacaoMeteorologica;
import br.com.fiap.entities.FonteDados;
import br.com.fiap.entities.SatelitesNASA;
import br.com.fiap.entities.SensorSolo;
import br.com.fiap.entities.SensorNutrientesNPT;

public class Sistema {
    public static void main(String[] args) {
        // 1. Simulando a chegada dos dados do chão (IoT - Humidade e Temperatura)
        SensorSolo sensorChao = new SensorSolo("SS-FAZENDA-01", true, 15.5, 28.4, 85);

        // 2. Simulando a chegada dos dados do espaço (NASA API - Visão Macro)
        SatelitesNASA sateliteEspaco = new SatelitesNASA("SAT-LANDSAT-8", true, 0.32, 1.2, "Sem alertas climáticos extremos");

        // 3. Simulando a chegada dos dados químicos do solo (Novo Sensor NPK)
        SensorNutrientesNPT sensorQuimico = new SensorNutrientesNPT("SN-FAZENDA-01", true, 18.5, 45.2, 60.0);

        // 4. Enviando as referências para o módulo de Inteligência unificar
        AnaliseAgro centralIA = new AnaliseAgro(sensorChao, sateliteEspaco);


        // 5. Exibindo o dashboard completo e mastigado via o toString atualizado
        System.out.println(centralIA);

        System.out.println("\n--- SIMULAÇÃO DE CENÁRIO DE FALHA CRÍTICA ---\n");

        // Simulando o sensor de solo a descarregar a bateria e a perder a conexão à rede
        sensorChao.setBateriaSensor(8);
        sensorChao.setStatusConexao(false);

        // Força a atualização e reavaliação dos alertas de saúde do sistema
        System.out.println(centralIA);
    }
}