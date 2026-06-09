package br.com.fiap.entities;

public class AnaliseAgro {
    // Atributos de referência (Composição/Associação)
    private SensorSolo leituraSensor;
    private SatelitesNASA leituraSatelite;

    // Atributos de resultado
    private boolean riscoEstresseHidrico;
    private String insightGerado;

    // Construtor que recebe as referências das fontes de dados
    public AnaliseAgro(SensorSolo leituraSensor, SatelitesNASA leituraSatelite) {
        this.leituraSensor = leituraSensor;
        this.leituraSatelite = leituraSatelite;
        this.processarInteligenciaDados(); // Executa a análise automaticamente ao criar
    }

    // Método que simula a IA cruzando os dados Micro (Sensor) e Macro (Satélite)
    public void processarInteligenciaDados() {
        if (leituraSensor == null || leituraSatelite == null) {
            this.insightGerado = "Dados insuficientes para análise.";
            this.riscoEstresseHidrico = false;
            return;
        }

        // Regra de negócio fictícia: Se a umidade do solo for menor que 20%
        // E o índice de vegetação do satélite estiver baixo (menor que 0.4), o risco é alto.
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

    // Getters e Setters
    public SensorSolo getLeituraSensor() {
        return leituraSensor;
    }

    public void setLeituraSensor(SensorSolo leituraSensor) {
        this.leituraSensor = leituraSensor;
        processarInteligenciaDados(); // Reavalia se o dado mudar
    }

    public SatelitesNASA getLeituraSatelite() {
        return leituraSatelite;
    }

    public void setLeituraSatelite(SatelitesNASA leituraSatelite) {
        this.leituraSatelite = leituraSatelite;
        processarInteligenciaDados(); // Reavalia se o dado mudar
    }

    public boolean isRiscoEstresseHidrico() {
        return riscoEstresseHidrico;
    }

    public String getInsightGerado() {
        return insightGerado;
    }

    // ToString
    @Override
    public String toString() {
        return "=== RELATÓRIO AGROSYNC SENTINEL ===\n" +
                "-> " + (leituraSensor != null ? leituraSensor.gerarResumoLeitura() : "Sem dados do sensor") + "\n" +
                "-> " + (leituraSatelite != null ? leituraSatelite.gerarResumoLeitura() : "Sem dados do satélite") + "\n" +
                "-> [Resultado IA] Risco Estresse Hídrico: " + (riscoEstresseHidrico ? "SIM" : "NÃO") + "\n" +
                "-> [Insight]: " + insightGerado + "\n" +
                "==================================";
    }
}