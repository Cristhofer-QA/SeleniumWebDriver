package report;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TestReportVariables {

    @JsonProperty("total")
    private int qtdTotal = 0;

    @JsonProperty("success")
    private int qtdSucesso = 0;

    @JsonProperty("error")
    private int qtdErro = 0;

    public int getQtdTotal() {
        return qtdTotal;
    }

    public int getQtdSucesso() {
        return qtdSucesso;
    }

    public int getQtdErro() {
        return qtdErro;
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
