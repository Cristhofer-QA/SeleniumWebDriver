package report;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TestExecutionReport {

    @JsonProperty("total")
    private static int qtdTotal = 0;

    @JsonProperty("success")
    private static int qtdSucesso = 0;

    @JsonProperty("error")
    private static int qtdErro = 0;

    public static int getQtdTotal() {
        return qtdTotal;
    }

    public static int getQtdSucesso() {
        return qtdSucesso;
    }

    public static int getQtdErro() {
        return qtdErro;
    }

    public static void incrementTotal() {
        qtdTotal++;
    }

    public static void incrementSuccess() {
        qtdSucesso++;
    }

    public static void incrementError() {
        qtdErro++;
    }
}
