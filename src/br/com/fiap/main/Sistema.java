package br.com.fiap.main;

import br.com.fiap.entities.AnaliseAgro;
import br.com.fiap.entities.EstacaoMeteorologica;
import br.com.fiap.entities.SatelitesNASA;
import br.com.fiap.entities.SensorSolo;
import br.com.fiap.entities.SensorNutrientesNPT;
import java.util.Scanner;

public class Sistema {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== CADASTRO DE TELEMETRIA - AGROSYNC ===");

        System.out.println("\n--- Dados do Sensor de Solo ---");
        System.out.print("ID do Sensor (ex: SS-FAZENDA-01): ");
        String idSensor = scanner.nextLine();
        System.out.print("Umidade do Solo (%) (ex: 15,5): ");
        double umidadeSolo = scanner.nextDouble();
        System.out.print("Temperatura do Solo (°C) (ex: 28,4): ");
        double tempSolo = scanner.nextDouble();
        System.out.print("Bateria do Sensor (%) (ex: 85): ");
        int bateriaSensor = scanner.nextInt();
        scanner.nextLine();

        SensorSolo sensorChao = new SensorSolo(idSensor, true, umidadeSolo, tempSolo, bateriaSensor);

        System.out.println("\n--- Dados do Satélite NASA ---");
        System.out.print("ID do Satélite (ex: SAT-LANDSAT-8): ");
        String idSatelite = scanner.nextLine();
        System.out.print("Índice de Vegetação [NDVI] (0.0 a 1.0) (ex: 0,32): ");
        double indiceVeg = scanner.nextDouble();
        System.out.print("Anomalia de Temperatura (ex: 1,2): ");
        double anomaliaTemp = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Alerta Climático (ex: Sem alertas / Geada): ");
        String alertaClima = scanner.nextLine();

        SatelitesNASA sateliteEspaco = new SatelitesNASA(idSatelite, true, indiceVeg, anomaliaTemp, alertaClima);

        System.out.println("\n--- Dados do Sensor de Nutrientes NPK ---");
        System.out.print("ID do Sensor Químico (ex: SN-FAZENDA-01): ");
        String idQuimico = scanner.nextLine();
        System.out.print("Nível de Nitrogênio (mg/kg): ");
        double nitrogenio = scanner.nextDouble();
        System.out.print("Nível de Fósforo (mg/kg): ");
        double fosforo = scanner.nextDouble();
        System.out.print("Nível de Potássio (mg/kg): ");
        double potassio = scanner.nextDouble();
        scanner.nextLine();

        SensorNutrientesNPT sensorQuimico = new SensorNutrientesNPT(idQuimico, true, nitrogenio, fosforo, potassio);

        System.out.println("\n--- Dados da Estação Meteorológica ---");
        System.out.print("ID da Estação (ex: EM-FAZENDA-01): ");
        String idEstacao = scanner.nextLine();
        System.out.print("Velocidade do Vento (km/h): ");
        double velVento = scanner.nextDouble();
        System.out.print("Índice Pluviométrico (mm): ");
        double chuva = scanner.nextDouble();
        System.out.print("Umidade Relativa do Ar (%): ");
        double umidadeAr = scanner.nextDouble();
        scanner.nextLine();

        EstacaoMeteorologica estacaoClima = new EstacaoMeteorologica(idEstacao, true, velVento, chuva, umidadeAr);

        System.out.println("\n=== PROCESSANDO ANÁLISE AGRO ===\n");
        AnaliseAgro centralIA = new AnaliseAgro(sensorChao, sateliteEspaco, sensorQuimico, estacaoClima);

        System.out.println(centralIA);

        scanner.close();
    }
}