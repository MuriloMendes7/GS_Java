package br.com.fiap.entities;

public class AnaliseAgro {
    private SensorSolo leituraSensor;
    private SatelitesNASA leituraSatelite;
    private SensorNutrientesNPT leituraNutrientes;
    private EstacaoMeteorologica leituraEstacao;
    private boolean riscoEstresseHidrico;
    private String insightGerado;

    public AnaliseAgro(SensorSolo leituraSensor, SatelitesNASA leituraSatelite) {
        this.leituraSensor = leituraSensor;
        this.leituraSatelite = leituraSatelite;
        this.processarInteligenciaDados();
    }

    public AnaliseAgro(SensorSolo leituraSensor, SatelitesNASA leituraSatelite,
                       SensorNutrientesNPT leituraNutrientes, EstacaoMeteorologica leituraEstacao) {
        this.leituraSensor = leituraSensor;
        this.leituraSatelite = leituraSatelite;
        this.leituraNutrientes = leituraNutrientes;
        this.leituraEstacao = leituraEstacao;
        this.processarInteligenciaDados();
    }

    public void processarInteligenciaDados() {
        if (leituraSensor == null || leituraSatelite == null) {
            this.insightGerado = "Dados insuficientes para análise básica.";
            this.riscoEstresseHidrico = false;
            return;
        }

        if (leituraSensor.getUmidadeSolo() < 20.0 && leituraSatelite.getIndiceVegetacao() < 0.4) {
            this.riscoEstresseHidrico = true;
            this.insightGerado = "ALERTA: Risco de estresse hídrico alto verificado no solo e órbita. Inicie irrigação.";
        } else if (leituraSatelite.getAlertaClimatico().toLowerCase().contains("geada")) {
            this.riscoEstresseHidrico = false;
            this.insightGerado = "ATENÇÃO: Previsão de geada detectada por satélite na região.";
        } else if (leituraNutrientes != null && leituraNutrientes.getNivelNitrogenio() < 20.0) {
            this.riscoEstresseHidrico = false;
            this.insightGerado = "Cultura húmida, mas exausta. Nível de Nitrogénio crítico. Recomendada fertirrigação azotada.";
        } else {
            this.riscoEstresseHidrico = false;
            this.insightGerado = "Cultura estável. Condições normais de operação.";
        }
    }

    public String verificarSaudeEquipamentos() {
        StringBuilder diagnostico = new StringBuilder();

        if (leituraSensor != null) {
            if (!leituraSensor.isStatusConexao()) {
                diagnostico.append("⚠️ INFRAESTRUTURA: Sensor de Solo offline.\n");
            }
            if (leituraSensor.getBateriaSensor() < 15) {
                diagnostico.append("🪫 BATERIA: Sensor do solo [" + leituraSensor.getIdFonte() + "] abaixo de 15%.\n");
            }
        }

        if (leituraSatelite != null && !leituraSatelite.isStatusConexao()) {
            diagnostico.append("⚠️ INFRAESTRUTURA: Link com satélite decaído.\n");
        }

        if (leituraNutrientes != null && !leituraNutrientes.isStatusConexao()) {
            diagnostico.append("⚠️ INFRAESTRUTURA: Sensor Químico NPK sem sinal de rede.\n");
        }

        if (leituraEstacao != null && !leituraEstacao.isStatusConexao()) {
            diagnostico.append("⚠️ INFRAESTRUTURA: Estação Meteorológica local desconectada.\n");
        }

        if (diagnostico.length() == 0) {
            return "✅ Todos os sistemas e sensores operando perfeitamente em rede estável.";
        }

        return diagnostico.toString().trim();
    }

    public String calcularNecessidadeIrrigacao() {
        if (!this.riscoEstresseHidrico || leituraSensor == null) {
            return "Irrigação Desligada: Condições operacionais dentro dos conformes.";
        }

        if (leituraEstacao != null && leituraEstacao.getIndicePluviometrico() > 5.0) {
            return "🇲🇺 IRRIGAÇÃO SUSPENSA: Risco hídrico mitigado por chuva natural detectada pela estação.";
        }

        double metaUmidade = 50.0;
        double umidadeAtual = leituraSensor.getUmidadeSolo();
        double deficit = metaUmidade - umidadeAtual;
        double litrosPorMetroQuadrado = deficit * 1.5;

        return String.format("💧 PLANO DE ATIVAÇÃO: Iniciar aspersores. Aplicar aproximadamente %.1f L/m² para atingir a meta de %.1f%%.",
                litrosPorMetroQuadrado, metaUmidade);
    }

    public SensorSolo getLeituraSensor() { return leituraSensor; }
    public void setLeituraSensor(SensorSolo lecturaSensor) { this.leituraSensor = lecturaSensor; processarInteligenciaDados(); }

    public SatelitesNASA getLeituraSatelite() { return leituraSatelite; }
    public void setLeituraSatelite(SatelitesNASA leituraSatelite) { this.leituraSatelite = leituraSatelite; processarInteligenciaDados(); }

    public SensorNutrientesNPT getLeituraNutrientes() { return leituraNutrientes; }
    public void setLeituraNutrientes(SensorNutrientesNPT leituraNutrientes) { this.leituraNutrientes = leituraNutrientes; processarInteligenciaDados(); }

    public EstacaoMeteorologica getLeituraEstacao() { return leituraEstacao; }
    public void setLeituraEstacao(EstacaoMeteorologica leituraEstacao) { this.leituraEstacao = leituraEstacao; processarInteligenciaDados(); }

    public boolean isRiscoEstresseHidrico() { return riscoEstresseHidrico; }
    public String getInsightGerado() { return insightGerado; }

    @Override
    public String toString() {
        return "=== RELATÓRIO AGROSYNC SENTINEL ===\n" +
                "-> " + (leituraSensor != null ? leituraSensor.gerarResumoLeitura() : "Sem dados do sensor de solo") + "\n" +
                "-> " + (leituraSatelite != null ? leituraSatelite.gerarResumoLeitura() : "Sem dados do satélite") + "\n" +
                "-> " + (leituraNutrientes != null ? leituraNutrientes.gerarResumoLeitura() : "Sem telemetria química NPK") + "\n" +
                "-> " + (leituraEstacao != null ? leituraEstacao.gerarResumoLeitura() : "Sem dados climatológicos locais") + "\n" +
                "-> [Saúde do Sistema]: \n" + verificarSaudeEquipamentos() + "\n" +
                "-> [Resultado IA] Risco Estresse Hídrico: " + (riscoEstresseHidrico ? "SIM" : "NÃO") + "\n" +
                "-> [Insight]: " + insightGerado + "\n" +
                "-> [Automação]: " + calcularNecessidadeIrrigacao() + "\n" +
                "==================================";
    }
}