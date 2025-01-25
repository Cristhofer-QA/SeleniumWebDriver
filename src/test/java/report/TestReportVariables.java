package report;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TestReportVariables {

    @JsonProperty("total")
    private int qtdTotal = 0;

    @JsonProperty("success")
    private int qtdSucesso = 0;

    @JsonProperty("error")
    private int qtdErro = 0;

    @JsonProperty("seconds")
    private long tempoExecucao;

    public void setTempoExecucao(long duration) {
        tempoExecucao = duration;
    }

    public void incrementTotal() {
        qtdTotal++;
    }

    public void incrementSuccess() {
        qtdSucesso++;
    }

    public void incrementError() {
        qtdErro++;
    }
}
