package br.com.fiap.entities;

public class AnaliseAgro {
    private SensorSolo leituraSensor;
    private SatelitesNASA leituraSatelite;
    private boolean riscoEstresseHidrico;
    private String insightGerado;

    // Construtor
    public AnaliseAgro(SensorSolo leituraSensor, SatelitesNASA leituraSatelite) {
        this.leituraSensor = leituraSensor;
        this.leituraSatelite = leituraSatelite;
        this.processarInteligenciaDados();
    }

    public void processarInteligenciaDados() {
        if (leituraSensor == null || leituraSatelite == null) {
            this.insightGerado = "Dados insuficientes para análise.";
            this.riscoEstresseHidrico = false;
            return;
        }

        if (leituraSensor.getUmidadeSolo() < 20.0 && leituraSatelite.getIndiceVegetacao() < 0.4) {
            this.riscoEstresseHidrico = true;
            this.insightGerado = "ALERTA: Risco de estresse hídrico alto verificado no solo e órbita. Inicie irrigação.";
        } else if (leituraSatelite.getAlertaClimatico().toLowerCase().contains("geada")) {
            this.riscoEstresseHidrico = false;
            this.insightGerado = "ATENÇÃO: Previsão de geada detectada por satélite na região.";
        } else {
            this.riscoEstresseHidrico = false;
            this.insightGerado = "Cultura estável. Condições normais de operação.";
        }
    }

    /**
     * Valida a integridade dos hardwares e conexões de rede antes de consolidar os dados.
     * @return String contendo o diagnóstico de saúde do ecossistema IoT.
     */
    public String verificarSaudeEquipamentos() {
        if (leituraSensor == null || leituraSatelite == null) {
            return "CRÍTICO: Fontes de dados ausentes.";
        }

        StringBuilder diagnostico = new StringBuilder();

        if (!leituraSensor.isStatusConexao() || !leituraSatelite.isStatusConexao()) {
            diagnostico.append("⚠️ INFRAESTRUTURA: Existe uma falha de conexão ativa em uma das fontes.\n");
        }

        if (leituraSensor.getBateriaSensor() < 15) {
            diagnostico.append("🪫 BATERIA: O sensor do solo [" + leituraSensor.getIdFonte() + "] está operando abaixo de 15%. Substituição recomendada.\n");
        }

        if (diagnostico.length() == 0) {
            return "✅ Todos os sistemas e sensores operando perfeitamente em rede estável.";
        }

        return diagnostico.toString().trim();
    }


    /**
     * Calcula dinamicamente o volume recomendado de lâmina de água baseado no déficit de umidade.
     * Assume-se uma meta ideal de 50% de umidade para o solo em questão.
     * @return String informando a recomendação de vazão técnica.
     */
    public String calcularNecessidadeIrrigacao() {
        if (!this.riscoEstresseHidrico || leituraSensor == null) {
            return "Irrigação Desligada: Nível freático e umidade superficial operando dentro dos conformes.";
        }

        double metaUmidade = 50.0;
        double umidadeAtual = leituraSensor.getUmidadeSolo();

        // Regra simples baseada na diferença para atingir a meta ideal
        double deficit = metaUmidade - umidadeAtual;

        // Simulação de cálculo de litros por metro quadrado baseada no déficit hídrico
        double litrosPorMetroQuadrado = deficit * 1.5;

        return String.format("💧 PLANO DE ATIVAÇÃO: Iniciar aspersores. Necessário aplicar aproximadamente %.1f L/m² para atingir a meta estipulada de %.1f%% de umidade.",
                litrosPorMetroQuadrado, metaUmidade);
    }

    // Getters e Setters
    public SensorSolo getLeituraSensor() { return leituraSensor; }
    public void setLeituraSensor(SensorSolo leituraSensor) { this.leituraSensor = leituraSensor; processarInteligenciaDados(); }
    public SatelitesNASA getLeituraSatelite() { return leituraSatelite; }
    public void setLeituraSatelite(SatelitesNASA leituraSatelite) { this.leituraSatelite = leituraSatelite; processarInteligenciaDados(); }
    public boolean isRiscoEstresseHidrico() { return riscoEstresseHidrico; }
    public String getInsightGerado() { return insightGerado; }

    // ToString Atualizado
    @Override
    public String toString() {
        return "=== RELATÓRIO AGROSYNC SENTINEL ===\n" +
                "-> " + (leituraSensor != null ? leituraSensor.gerarResumoLeitura() : "Sem dados do sensor") + "\n" +
                "-> " + (leituraSatelite != null ? leituraSatelite.gerarResumoLeitura() : "Sem dados do satélite") + "\n" +
                "-> [Saúde do Sistema]: " + verificarSaudeEquipamentos() + "\n" +
                "-> [Resultado IA] Risco Estresse Hídrico: " + (riscoEstresseHidrico ? "SIM" : "NÃO") + "\n" +
                "-> [Insight]: " + insightGerado + "\n" +
                "-> [Automação]: " + calcularNecessidadeIrrigacao() + "\n" +
                "==================================";
    }
}